package com.sws.hdmshull.service;

import com.sws.hdmshull.pojo.APIResponse;
import com.sws.hdmshull.pojo.QueryVo;
import com.sws.hdmshull.pojo.SwsRecordEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface RecordService {
    SwsRecordEntity insertRecord(SwsRecordEntity recordEntity, HttpServletRequest request);

    List<SwsRecordEntity> findAllRecords();

    List<SwsRecordEntity> findALLRecordsByCondition( final QueryVo queryvo);
}
