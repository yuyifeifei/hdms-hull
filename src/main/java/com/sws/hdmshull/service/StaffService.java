package com.sws.hdmshull.service;

import com.sws.hdmshull.pojo.APIResponse;
import com.sws.hdmshull.pojo.SwsStaffEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Description
 * @Author 夜羽 <416282949@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/9/23
 */
public interface StaffService {

    Page<SwsStaffEntity> findAllStaffs(String name,Pageable pageable);

    APIResponse insertStaff(SwsStaffEntity staffEntity);
}
