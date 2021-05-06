package com.example.questionairmanage.model;

/**
 * @author Acloud
 * @message
 * @date 2021/4/26 11:15
 **/
public class Admin {
    private Integer adminId;
    private String username;
    private String password;
    private String mail;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Admin(Integer adminId, String username, String password, String mail) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public Admin(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
