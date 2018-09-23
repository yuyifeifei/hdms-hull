package com.sws.hdmshull.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Description
 * @Author 夜羽 <416282949@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/9/23
 */
@Entity
@Table(name = "sws_staff", schema = "hdms", catalog = "")
public class SwsStaffEntity {
    private long id;
    private String userName;
    private Integer sex;
    private Integer age;
    private Date birthday;
    private String address;
    private String division;
    private String workCardNumber;

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
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "division")
    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Basic
    @Column(name = "work_card_number")
    public String getWorkCardNumber() {
        return workCardNumber;
    }

    public void setWorkCardNumber(String workCardNumber) {
        this.workCardNumber = workCardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SwsStaffEntity that = (SwsStaffEntity) o;
        return id == that.id &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(age, that.age) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(address, that.address) &&
                Objects.equals(division, that.division) &&
                Objects.equals(workCardNumber, that.workCardNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userName, sex, age, birthday, address, division, workCardNumber);
    }
}
