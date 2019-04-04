package com.cloudlink.inspection.repository;

import com.cloudlink.inspection.domain.InspectionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description: none
 *
 * @author xiefayang
 * 2019/4/3 10:58
 */
public interface InspectionRecordRepository extends JpaRepository<InspectionRecord, String> {
}
