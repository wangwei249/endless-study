package com.jeethink.study.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.core.annotation.Excel;
import com.jeethink.common.core.web.domain.BaseEntity;

/**
 * 生词练习记录对象 new_words_records
 * 
 * @author jeethink
 * @date 2022-04-08
 */
public class NewWordsRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 生词ID */
    @Excel(name = "生词ID")
    private Long newWordsId;


    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** S:成功、F：失败 */
    @Excel(name = "S:成功、F：失败")
    private String result;

    /** 应战回复 【用于接收】*/
    private String challengeReply;
    /** 应战回复 【用于接收】*/
    private String challengeStatus;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setNewWordsId(Long newWordsId) 
    {
        this.newWordsId = newWordsId;
    }

    public Long getNewWordsId() 
    {
        return newWordsId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setResult(String result) 
    {
        this.result = result;
    }

    public String getResult() 
    {
        return result;
    }

    public String getChallengeReply() {
        return challengeReply;
    }

    public void setChallengeReply(String challengeReply) {
        this.challengeReply = challengeReply;
    }

    public String getChallengeStatus() {
        return challengeStatus;
    }

    public void setChallengeStatus(String challengeStatus) {
        this.challengeStatus = challengeStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("newWordsId", getNewWordsId())
            .append("userId", getUserId())
            .append("result", getResult())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
