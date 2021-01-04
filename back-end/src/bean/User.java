package bean;

import java.util.Date;

public class User {
    /**
     * 账号
     * 密码
     * 头像
     * 邮箱
     * 昵称
     * 性别
     * 注册时间
     * 出生日期
     */
    /**
     * create table tser(
     * userid int primary key,--账号
     * tser_password varchar(15),  --密码
     * tser_avatar varchar(255)not null,--头像
     * tser_mailbox varchar(20),--邮箱
     * tser_name varchar(7),--昵称
     * tser_sex char(2) check(Tser_sex='男' or Tser_sex='女')not null,--性别
     * tser_registration datetime, --注册时间
     * tser_birthday varchar(15) not null  --出生日期
     *
     * )
     */
    int userid;
    String password;
    String avatar;
    String mailbox;
    String name;
    String gender;
    Date registration;
    String birthday;

    public User() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
