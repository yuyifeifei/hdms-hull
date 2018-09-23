package com.sws.hdmshull.service;

import com.sws.hdmshull.pojo.APIResponse;
import com.sws.hdmshull.pojo.SwsStaffEntity;
import com.sws.hdmshull.repository.StaffRepository;
import jdk.nashorn.internal.runtime.Specialization;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author 夜羽 <416282949@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/9/23
 */
@Service
public class StaffServiceImpl implements StaffService {
   /* @RequestMapping(value = "/params", method=RequestMethod.GET)
    public Page<Blog> getEntryByParams(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                       @RequestParam(value = "size", defaultValue = "15") Integer size) {
        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return blogRepository.findAll(pageable);

    }*/
   @Autowired
   private StaffRepository staffRepository;

    @Override
    public Page<SwsStaffEntity> findAllStaffs(final String name,Pageable pageable) {
        Specification specification = null;
        if(StringUtils.isNotBlank(name)){
             specification = new Specification<SwsStaffEntity>() {
                @Override
                public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicateList = new ArrayList<>();
                    predicateList.add(criteriaBuilder.like(root.get("userName"),"%"+name+"%"));
                    return criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()])).getRestriction();
                }
            };
        }
        /*List<Predicate> predicateList = new ArrayList<>();
        if(null !=queryvo.getProjectNo()&&!queryvo.getProjectNo().equals("")){
            predicateList.add(criteriaBuilder.equal(root.get("projectNo"), queryvo.getProjectNo()));
        }
        if(null !=queryvo.getDesigner()&&!queryvo.getDesigner().equals("")){
            predicateList.add(criteriaBuilder.like(root.get("designer"), "%"+queryvo.getDesigner()+"%"));
        }
        if(null !=queryvo.getConfirmed()&&!queryvo.getConfirmed().equals("")){
            predicateList.add(criteriaBuilder.equal(root.get("confirmed"), queryvo.getConfirmed()));
        }
        return criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()])).getRestriction();*/
        //Page<SwsStaffEntity> staffs = staffRepository.findAll(specification, pageable);
        Page<SwsStaffEntity> staffs = staffRepository.findAll(specification, pageable);
        return staffs;
    }

    @Override
    public APIResponse insertStaff(SwsStaffEntity staffEntity) {
        SwsStaffEntity entity = staffRepository.save(staffEntity);
        if(null != entity){
            return  APIResponse.ok(entity);
        }
        return APIResponse.isNotOk("保存失败");
    }


}
