package com.thank.cloudlinkuser.web.controller;

import com.thank.cloudlinkuser.domain.PriUser;
import com.thank.cloudlinkuser.repository.PriUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * description: none
 *
 * @author xiefayang
 * 2019/4/3 10:34
 */
@Slf4j
@RestController
@RequestMapping("priUser")
public class PriUserController {

    @Autowired
    private PriUserRepository priUserRepository;

    @PostMapping("save")
    public ResponseEntity save(@RequestParam String name, @RequestParam Integer age) {
        PriUser priUser = new PriUser(name, age);
        priUser.setId(UUID.randomUUID().toString());
        this.priUserRepository.save(priUser);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<PriUser>> getAll() {
        List<PriUser> priUserList = this.priUserRepository.findAll();
        return new ResponseEntity<>(priUserList, HttpStatus.OK);
    }


    /**
     * for cloudlink-inspection micro service
     */
    @PostMapping("getByIds")
    public List<PriUser> getByIds(@RequestBody List<String> userIds) {

        // test hystrix of feign timeout
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//        }

//        throw new IllegalArgumentException();
        return this.priUserRepository.findAllById(userIds);
    }


}
