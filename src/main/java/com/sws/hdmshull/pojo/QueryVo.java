package com.sws.hdmshull.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author 夜羽 <416282949@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/9/2
 */
public class QueryVo implements Serializable {

    private String projectNo;
    private String designer;
    private Integer modified;
    private Integer confirmed;
    private String status;

    public QueryVo() {
    }

    public QueryVo(String projectNo, String designer, Integer modified, Integer confirmed, String status) {
        this.projectNo = projectNo;
        this.designer = designer;
        this.modified = modified;
        this.confirmed = confirmed;
        this.status = status;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public Integer getModified() {
        return modified;
    }

    public void setModified(Integer modified) {
        this.modified = modified;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
