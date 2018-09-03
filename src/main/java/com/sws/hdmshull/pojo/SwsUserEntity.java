package com.sws.hdmshull.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "sws_user", schema = "hdms", catalog = "")
public class SwsUserEntity {
    private long id;
    private String username;
    @NotEmpty
    @Size(max = 12,min = 6)
    private String password;
    @NotEmpty
    private String workNumberCard;
    private String graduationYear;
    @Pattern(regexp = "yyyy-mm-dd")
    private Date birthday;
    private String gender;
    private String department;
    private String administrativeOffice;
    private String photo;
    private String desciption;
    private String signature;
    private Integer state;
    private Integer groupleadId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "workNumberCard")
    public String getWorkNumberCard() {
        return workNumberCard;
    }

    public void setWorkNumberCard(String workNumberCard) {
        this.workNumberCard = workNumberCard;
    }

    @Basic
    @Column(name = "graduationYear")
    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "administrativeOffice")
    public String getAdministrativeOffice() {
        return administrativeOffice;
    }

    public void setAdministrativeOffice(String administrativeOffice) {
        this.administrativeOffice = administrativeOffice;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "desciption")
    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Basic
    @Column(name = "signature")
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "groupleadId")
    public Integer getGroupleadId() {
        return groupleadId;
    }

    public void setGroupleadId(Integer groupleadId) {
        this.groupleadId = groupleadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SwsUserEntity that = (SwsUserEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(workNumberCard, that.workNumberCard) &&
                Objects.equals(graduationYear, that.graduationYear) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(department, that.department) &&
                Objects.equals(administrativeOffice, that.administrativeOffice) &&
                Objects.equals(photo, that.photo) &&
                Objects.equals(desciption, that.desciption) &&
                Objects.equals(signature, that.signature) &&
                Objects.equals(state, that.state) &&
                Objects.equals(groupleadId, that.groupleadId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, workNumberCard, graduationYear, birthday, gender, department, administrativeOffice, photo, desciption, signature, state, groupleadId);
    }
}
