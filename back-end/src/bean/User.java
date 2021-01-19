package bean;

import java.util.Date;

public class User {
    /**
     * userid int primary key,--账号
     * tser_password varchar(15),  --密码
     * tser_avatar varchar(255)not null,--头像
     * tser_mailbox varchar(20),--邮箱
     * tser_name varchar(7),--昵称
     * tser_sex char(2) check(Tser_sex='男' or Tser_sex='女')not null,--性别
     * tser_registration datetime, --注册时间
     * tser_birthday varchar(15) not null  --出生日期
     * <p>
     * 注释创建时间：19点47分 2021\1
     */


    int userid;
    String password;
    String avatar;
    String mailbox;
    String name;
    String sex;
    Date registration;
    Date birthday;

    public User() {
    }

    /**
     * @param userid       账号
     * @param password     密码
     * @param avatar       头像
     * @param mailbox      邮箱
     * @param name         昵称
     * @param sex          性别(男、女)
     * @param registration 注册时间
     * @param birthday     出生日期
     *                     注释时间：20点36分 2021\1
     */
    public User(int userid, String password, String avatar, String mailbox, String name, String sex, Date registration, Date birthday) {
        this.userid = userid;
        this.password = password;
        this.avatar = avatar;
        this.mailbox = mailbox;
        this.name = name;
        this.sex = sex;
        this.registration = registration;
        this.birthday = birthday;
    }

    public User(int id, String password, String email) {
    }

    public User(int userid, String password) {
        this.userid = userid;
        this.password = password;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
