package com.sws.hdmshull.controller;

import com.sws.hdmshull.pojo.APIResponse;
import com.sws.hdmshull.pojo.SwsStaffEntity;
import com.sws.hdmshull.service.StaffService;
import jdk.nashorn.internal.ir.ReturnNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @Description
 * @Author 夜羽 <416282949@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/9/23
 */
@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "/getStaffs",method = RequestMethod.GET)
    public Page<SwsStaffEntity> getStaffsByPageAble (@RequestParam(value = "page",defaultValue = "0")Integer page,
                                                     @RequestParam(value = "size",defaultValue = "3")Integer size,
                                                     @RequestParam(value = "name") String name){
        Sort sort = new Sort(Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<SwsStaffEntity> staffs = staffService.findAllStaffs(name,pageable);
        return staffs;
    }

    @RequestMapping(value = "/addStaff",method = RequestMethod.POST)
    public APIResponse addStaff(SwsStaffEntity staffEntity){
        APIResponse apiResponse = staffService.insertStaff(staffEntity);
        return apiResponse;
    }
}
