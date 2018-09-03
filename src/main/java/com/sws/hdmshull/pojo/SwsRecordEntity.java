package com.sws.hdmshull.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "sws_record", schema = "hdms", catalog = "")
//@GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
public class SwsRecordEntity {
    private String id;
    private String projectNo;
    private String blockNo;
    private String issueType;
    private String issueContent;
    private String designer;
    private String checker;
    private String groupleader;
    private Integer modified;
    private Integer confirmed;
    //@JsonFormat(timezone = "GMT+8", pattern = "yyyy-mm-dd")
    private Date registrationtime;
    private Date confirmedtime;
    private String status;

    @Id
    @Column(name = "id")
   // @GeneratedValue(generator="idGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "projectNo")
    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    @Basic
    @Column(name = "blockNo")
    public String getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(String blockNo) {
        this.blockNo = blockNo;
    }

    @Basic
    @Column(name = "issueType")
    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    @Basic
    @Column(name = "issueContent")
    public String getIssueContent() {
        return issueContent;
    }

    public void setIssueContent(String issueContent) {
        this.issueContent = issueContent;
    }

    @Basic
    @Column(name = "designer")
    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    @Basic
    @Column(name = "checker")
    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    @Basic
    @Column(name = "groupleader")
    public String getGroupleader() {
        return groupleader;
    }

    public void setGroupleader(String groupleader) {
        this.groupleader = groupleader;
    }

    @Basic
    @Column(name = "modified")
    public Integer getModified() {
        return modified;
    }

    public void setModified(Integer modified) {
        this.modified = modified;
    }

    @Basic
    @Column(name = "confirmed")
    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    @Basic
    @Column(name = "registrationtime")
    public Date getRegistrationtime() {
        return registrationtime;
    }

    public void setRegistrationtime(Date registrationtime) {
        this.registrationtime = registrationtime;
    }

    @Basic
    @Column(name = "confirmedtime")
    public Date getConfirmedtime() {
        return confirmedtime;
    }

    public void setConfirmedtime(Date confirmedtime) {
        this.confirmedtime = confirmedtime;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SwsRecordEntity that = (SwsRecordEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(projectNo, that.projectNo) &&
                Objects.equals(blockNo, that.blockNo) &&
                Objects.equals(issueType, that.issueType) &&
                Objects.equals(issueContent, that.issueContent) &&
                Objects.equals(designer, that.designer) &&
                Objects.equals(checker, that.checker) &&
                Objects.equals(groupleader, that.groupleader) &&
                Objects.equals(modified, that.modified) &&
                Objects.equals(confirmed, that.confirmed) &&
                Objects.equals(registrationtime, that.registrationtime) &&
                Objects.equals(confirmedtime, that.confirmedtime) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, projectNo, blockNo, issueType, issueContent, designer, checker, groupleader, modified, confirmed, registrationtime, confirmedtime, status);
    }
}
