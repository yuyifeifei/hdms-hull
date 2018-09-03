package com.sws.hdmshull.service;

import com.sun.org.apache.regexp.internal.RE;
import com.sws.hdmshull.config.DateConverterConfig;
import com.sws.hdmshull.pojo.APIResponse;
import com.sws.hdmshull.pojo.QueryVo;
import com.sws.hdmshull.pojo.SwsRecordEntity;
import com.sws.hdmshull.pojo.SwsUserEntity;
import com.sws.hdmshull.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RecordServiceImpl implements  RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private DateConverterConfig dateConverterConfig;
    //新增
    @Override
    public SwsRecordEntity insertRecord(SwsRecordEntity recordEntity, HttpServletRequest request) {
        //业务逻辑
       /* private String id;
        private String designer;
        private String checker;
        private String groupleader;
        private Integer modified;
        private Integer confirmed;
        private Timestamp registrationtime;
        private Timestamp confirmedtime;
        private String status;*/
        recordEntity.setId(UUID.randomUUID().toString());
        //designer可以手动填写，也可以默认按dp来获取。
        //获取校对人员，username是中文。必须登陆才能做这样的操作
        SwsUserEntity user = (SwsUserEntity) request.getSession().getAttribute("user");
       if(null != user){
           recordEntity.setChecker(user.getUsername());
       }else {
           //如果未登录，业务处理。
           //此处测试
           recordEntity.setChecker("李思思");
       }
       //grouperleader可以页面展示，也可以后台查询。下拉框直接获取。
        //modified，初始化是0，0代表未修改，1表示已修改
        recordEntity.setModified(0);
       //confirmed 0 代表未确认，1代表 已确认
        recordEntity.setConfirmed(0);

        //private Timestamp registrationtime;
        recordEntity.setRegistrationtime(new Date());
       // private Timestamp confirmedtime;
        recordEntity.setConfirmedtime(null);
       // private String status;*/ open表示未关闭，closed 表示关闭
        recordEntity.setStatus("open");

        SwsRecordEntity record = recordRepository.save(recordEntity);
        return record;
    }

    @Override
    public List<SwsRecordEntity> findAllRecords() {
        List<SwsRecordEntity> list = recordRepository.findAll();
        return list;
    }

    @Override
    //动态条件查询
    public List<SwsRecordEntity> findALLRecordsByCondition(final QueryVo queryvo) {

        return recordRepository.findAll(new Specification<SwsRecordEntity>() {
            @Override
            public Predicate toPredicate(Root<SwsRecordEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if(null !=queryvo.getProjectNo()&&!queryvo.getProjectNo().equals("")){
                    predicateList.add(criteriaBuilder.equal(root.get("projectNo"), queryvo.getProjectNo()));
                }
                if(null !=queryvo.getDesigner()&&!queryvo.getDesigner().equals("")){
                    predicateList.add(criteriaBuilder.like(root.get("designer"), "%"+queryvo.getDesigner()+"%"));
                }
                if(null !=queryvo.getConfirmed()&&!queryvo.getConfirmed().equals("")){
                    predicateList.add(criteriaBuilder.equal(root.get("confirmed"), queryvo.getConfirmed()));
                }
                return criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()])).getRestriction();
               /* Predicate predicate1  =null;
                Predicate predicate2  =null;
                Predicate predicate3  =null;

                //根据项目，设计者，未确认 projectNo designer confirmed

                Path projectNo = root.get("projectNo");
                Path designer = root.get("designer");
                Path confirmed = root.get("confirmed");

                if(null!= queryvo.getProjectNo()){
                    predicate1 = criteriaBuilder.equal(projectNo, queryvo.getProjectNo());
                }
                if(null!= queryvo.getDesigner()){
                    predicate2 = criteriaBuilder.like(designer,"%"+queryvo.getDesigner()+"%");
                }
                if(null != queryvo.getConfirmed()){
                    predicate3 = criteriaBuilder.equal(confirmed,queryvo.getConfirmed());
                }

                if(null !=predicate1){
                    if(null !=predicate2){
                        predicate1 =criteriaBuilder.and(predicate1,predicate2);
                    }
                    if(null !=predicate3){
                        predicate1 =criteriaBuilder.and(predicate1,predicate3);
                    }
                    return predicate1;

                }else if(null!=predicate2){
                    if(null!=predicate3){
                        predicate2 =criteriaBuilder.and(predicate2,predicate3);
                    }
                    return predicate2;
                }else if(null!=predicate3){
                    return predicate3;
                }
                return null;*/
            }
        });
    }

    /*
  动态查询的条件：
      条件1:性别为 男;
      条件2:年龄在25-35之间；
      条件3：吴国人;
   */
/*    public List findByDynamicCases() {

        return studentRepository.findAll( new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate1,predicate2,predicate3;

                Path sex = root.get("sex");
                Path age = root.get("age");
                Path address = root.get("address");

                predicate1 = cb.like(sex,"男");
                predicate2 = cb.between(age,25,35);
                predicate3 = cb.equal(address,"吴国");

                query.where(predicate1,predicate2,predicate3);
                return null;
            }
        });
    }*/

}
