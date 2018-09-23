package com.sws.hdmshull.repository;

import com.sws.hdmshull.pojo.SwsStaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StaffRepository extends JpaRepository<SwsStaffEntity,String>,JpaSpecificationExecutor {

}
