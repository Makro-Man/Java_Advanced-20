package ua.lviv.lgs.domain;

import javax.persistence.*;

@Entity
@Table
public class UserRole {
    @Id
    @GeneratedValue
    @Column
    private Long userroleid;
    @Column
    private Long userid;
    @Column
    private String role;

    public Long getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(Long userroleid) {
        this.userroleid = userroleid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
