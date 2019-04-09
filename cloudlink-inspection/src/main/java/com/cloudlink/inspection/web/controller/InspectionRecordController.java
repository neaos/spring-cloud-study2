package com.cloudlink.inspection.web.controller;

import com.cloudlink.inspection.client.UserFeignClient;
import com.cloudlink.inspection.domain.InspectionRecord;
import com.cloudlink.inspection.dto.PriUser;
import com.cloudlink.inspection.repository.InspectionRecordRepository;
import com.cloudlink.inspection.service.TestService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description: none
 *
 * @author xiefayang
 * 2019/4/3 11:06
 */
@Slf4j
@RestController
@RequestMapping("inspectionRecord")
public class InspectionRecordController {

    @Autowired
    private InspectionRecordRepository inspectionRecordRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private TestService testService;


    /**
     * 演示服务间的调用方式: 使用Spring提供的RestTemplate
     */
    @GetMapping("getAllByRestTemplate")
    public ResponseEntity<List<InspectionRecord>> getAllByRestTemplate() {
        List<InspectionRecord> recordList = this.inspectionRecordRepository.findAll();
        List<String> userIds = recordList.stream().map(InspectionRecord::getInspectionUserId).collect(Collectors.toList());

        // invoke User Micro Server
        List<Map<String, Object>> userDTOs = this.restTemplate.postForObject("http://cloudlink-user/priUser/getByIds", userIds, List.class);

        log.info("userDTOs: {}", userDTOs);
        Map<String, String> idToName = Maps.newHashMap();

        for (Map<String, Object> user : userDTOs) {
            idToName.put(String.valueOf(user.get("id")), String.valueOf(user.get("name")));
        }

        recordList.forEach(s -> s.setInspectionUserName(idToName.get(s.getInspectionUserId())));
        return new ResponseEntity<>(recordList, HttpStatus.OK);
    }


    /**
     * 演示服务间的调用方式: 使用Spring Cloud提供的Feign Client
     * {@link UserFeignClient}
     */
    @GetMapping("getAllByFeign")
    public ResponseEntity<List<InspectionRecord>> getAllByFeign() {
        List<InspectionRecord> recordList = this.inspectionRecordRepository.findAll();
        List<String> userIds = recordList.stream().map(InspectionRecord::getInspectionUserId).collect(Collectors.toList());

        // invoke User Micro Server
        List<PriUser> userLists = this.userFeignClient.getByIds(userIds);

        log.warn("userDTOs: {}", userLists);
        Map<String, String> idToName = Maps.newHashMap();

        for (PriUser user : userLists) {
            idToName.put(user.getId(), user.getName());
        }

        recordList.forEach(s -> s.setInspectionUserName(idToName.get(s.getInspectionUserId())));
        return new ResponseEntity<>(recordList, HttpStatus.OK);
    }

}
