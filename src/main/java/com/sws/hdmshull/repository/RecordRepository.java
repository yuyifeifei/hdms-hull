package com.sws.hdmshull.repository;

import com.sws.hdmshull.pojo.SwsRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface RecordRepository extends JpaRepository<SwsRecordEntity,String>,JpaSpecificationExecutor {
}
