package com.fl.fbs.repositories;

import com.fl.fbs.entities.LoanRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRecordRepository extends JpaRepository<LoanRecord, Long> {
}
