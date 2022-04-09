package com.jeethink.study.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.core.annotation.Excel;
import com.jeethink.common.core.web.domain.BaseEntity;

/**
 * 生词对象 new_words
 * 
 * @author jeethink
 * @date 2022-04-08
 */
public class NewWords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 单词ID */
    @Excel(name = "单词ID")
    private Long wordId;

    /** 生词状态：S/在生存，D/已消灭 */
    @Excel(name = "生词状态：S/在生存，D/已消灭")
    private String status;

    /** 已练习错误次数 */
    @Excel(name = "已练习错误次数")
    private Integer wrongTimes;

    /** 正确次数 */
    @Excel(name = "正确次数")
    private Integer rightTimes;

    /** 上一次正确时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上一次正确时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastRigthTime;


    /**新增关联表数据*/
    /** 单词 */
    @Excel(name = "单词")
    private String word;



    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setWordId(Long wordId) 
    {
        this.wordId = wordId;
    }

    public Long getWordId() 
    {
        return wordId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setWrongTimes(Integer wrongTimes) 
    {
        this.wrongTimes = wrongTimes;
    }

    public Integer getWrongTimes() 
    {
        return wrongTimes;
    }
    public void setRightTimes(Integer rightTimes) 
    {
        this.rightTimes = rightTimes;
    }

    public Integer getRightTimes() 
    {
        return rightTimes;
    }
    public void setLastRigthTime(Date lastRigthTime) 
    {
        this.lastRigthTime = lastRigthTime;
    }

    public Date getLastRigthTime() 
    {
        return lastRigthTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("wordId", getWordId())
            .append("status", getStatus())
            .append("wrongTimes", getWrongTimes())
            .append("rightTimes", getRightTimes())
            .append("lastRigthTime", getLastRigthTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
