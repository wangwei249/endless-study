package com.jeethink.study.domain.assist;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeethink.common.core.web.domain.BaseEntity;
import com.jeethink.study.domain.Means;

import java.util.Date;
import java.util.List;

/**
 * 生词对象 new_words
 * 
 * @author jeethink
 * @date 2022-04-08
 */
public class FriendsDyn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;

    private String userName;

    private String nickName;

    /** 单词ID */
    private Long wordId;

    /** 单词 */
    private String word;

    /** 含义列表 */
    private List<Means> meansList;

    /** 上一次正确时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getWordId() {
        return wordId;
    }

    public void setWordId(Long wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Means> getMeansList() {
        return meansList;
    }

    public void setMeansList(List<Means> meansList) {
        this.meansList = meansList;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
