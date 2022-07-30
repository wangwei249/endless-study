package com.jeethink.study.domain.assist;

import com.jeethink.common.core.web.domain.BaseEntity;

/**
 * 生词对象 new_words
 * 
 * @author jeethink
 * @date 2022-04-08
 */
public class NewWordsRank extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;

    /** 昵称 */
    private String userName;

    /** 已消灭数 */
    private Long passNum;

    /** 总数 */
    private Long allNum;


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

    public Long getPassNum() {
        return passNum;
    }

    public void setPassNum(Long passNum) {
        this.passNum = passNum;
    }

    public Long getAllNum() {
        return allNum;
    }

    public void setAllNum(Long allNum) {
        this.allNum = allNum;
    }
}
