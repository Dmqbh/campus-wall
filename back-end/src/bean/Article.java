package bean;

import java.util.Date;

public class Article {
    /**
     * article_id int not null identity(1000,1) primary key,--文章号
     * article_title varchar(20),--标题
     * article_content varchar(800),--内容
     * userid int foreign key references tser(userid),--发表用户（账号）外键
     * article_time datetime,--发表时间
     */
    int id;
    String title;
    String content;
    int userid;
    Date articletime;

    public Article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getArticletime() {
        return articletime;
    }

    public void setArticletime(Date articletime) {
        this.articletime = articletime;
    }
}
