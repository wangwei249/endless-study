package com.jeethink.study.domain.assist;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeethink.common.core.annotation.Excel;
import com.jeethink.common.core.web.domain.BaseEntity;
import com.jeethink.study.domain.Means;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 生词对象 new_words
 * 
 * @author jeethink
 * @date 2022-04-08
 */
public class NewWordsCollect extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;

    /** 总数 */
    private Long allNum;

    /** 已消灭数 */
    private Long passNum;

    /** 存活数 */
    private Long aliveNum;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAllNum() {
        return allNum;
    }

    public void setAllNum(Long allNum) {
        this.allNum = allNum;
    }

    public Long getPassNum() {
        return passNum;
    }

    public void setPassNum(Long passNum) {
        this.passNum = passNum;
    }

    public Long getAliveNum() {
        return aliveNum;
    }

    public void setAliveNum(Long aliveNum) {
        this.aliveNum = aliveNum;
    }
}
