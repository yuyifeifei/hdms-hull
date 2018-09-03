package com.sws.hdmshull.controller;

import com.sun.org.apache.bcel.internal.generic.IDIV;
import com.sws.hdmshull.pojo.APIResponse;
import com.sws.hdmshull.pojo.QueryVo;
import com.sws.hdmshull.pojo.ResultEnum;
import com.sws.hdmshull.pojo.SwsRecordEntity;
import com.sws.hdmshull.repository.RecordRepository;
import com.sws.hdmshull.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    //新增记录
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public APIResponse insertRecord(SwsRecordEntity recordEntity, HttpServletRequest request){



        SwsRecordEntity record = recordService.insertRecord(recordEntity,request);
       if (null!=record) {
           return new APIResponse(ResultEnum.SUCCESS, "新增记录成功！", record);
       }else{
           return new APIResponse(ResultEnum.FAIL,"新增记录失败");
       }
    }
    //更新记录
    //查询记录列表
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public APIResponse findAllRecords(){
       List<SwsRecordEntity> records = recordService.findAllRecords();
       if (null == records &&records.size()<=0){
           return  new APIResponse(ResultEnum.FAIL,"获取列表失败");
       }
        return  new APIResponse(ResultEnum.SUCCESS,"获取列表成功",records);
    }
    //根据用户名查询
    //根据工程项目查询
    //根据工程项目和
    //删除记录

    //测试排序
    @Autowired
    private RecordRepository recordRepository;
    @RequestMapping(value = "/sort",method = RequestMethod.GET)
    public APIResponse sortRecords(){
        List<SwsRecordEntity> list = recordRepository.findAll(Sort.by(Sort.Direction.DESC, "registrationtime"));
        return new APIResponse(ResultEnum.SUCCESS,"okok!",list);
    }
    //测试分页
    //如果是mybais的话，分页通过分页插件
    ////将参数传给这个方法就可以实现物理分页了，非常简单。
    //        PageHelper.startPage(pageNum, pageSize);基于拦截器
    //        List<User> users = userMapper.selectUsers();
    //        PageInfo result = new PageInfo(users);
    //此处使用JPA的自带的原生的分页
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public APIResponse findAllPageandSort(Integer page,Integer size){
        if (null == page|| StringUtils.isEmpty(page)){
            page = 0;
        }
        if (null == size || StringUtils.isEmpty(size)){
            size = 2;
        }
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.ASC, "registrationtime");
        Page<SwsRecordEntity> records = recordRepository.findAll(pageable);
        if (null!=records &&records.getSize()> 0){
            return new APIResponse(ResultEnum.SUCCESS,"分页查询ok",records);
        }else {
            return new APIResponse(ResultEnum.FAIL,"查询失败");
        }
    }


    //动态查询
    @RequestMapping(value = "/findAllDt",method = RequestMethod.POST)
    public APIResponse findAllByCondition(QueryVo queryVo){
        List<SwsRecordEntity> list = recordService.findALLRecordsByCondition(queryVo);
        if(null != list &&list.size()>0){
            return new APIResponse(ResultEnum.SUCCESS, list);
        }else {
            return new APIResponse(ResultEnum.FAIL, null);
        }
    }


}
