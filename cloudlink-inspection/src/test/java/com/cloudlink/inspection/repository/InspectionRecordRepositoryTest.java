package com.cloudlink.inspection.repository;

import com.cloudlink.inspection.domain.InspectionRecord;
import com.thank.client.ClientApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

/**
 * description: none
 *
 * @author xiefayang
 * 2019/4/3 10:59
 */
@Slf4j
public class InspectionRecordRepositoryTest extends ClientApplicationTests {

    @Autowired
    private InspectionRecordRepository inspectionRecordRepository;

    @Test
    public void testSave() {
        InspectionRecord inspectionRecord = new InspectionRecord("code001", 200, "985f24dd-80d8-49e8-b050-1575aa8a47dd");
        inspectionRecord.setId(UUID.randomUUID().toString());
        InspectionRecord result = this.inspectionRecordRepository.save(inspectionRecord);
        Assert.assertNotNull(result);
    }


    @Test
    public void testFindAll() {
        List<InspectionRecord> results = this.inspectionRecordRepository.findAll();
        log.info("{}", results);
        Assert.assertTrue(!CollectionUtils.isEmpty(results));
    }

}