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
public class HotWord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 单词ID */
    @Excel(name = "单词ID")
    private Long wordId;

    /**新增关联表数据*/
    /** 单词 */
    @Excel(name = "单词")
    private String word;

    /** 单词收集次数 */
    @Excel(name = "收集次数")
    private Integer totalCount;

    /**新增关联表数据*/
    /** 单词 */
    @Excel(name = "读音")
    private String voice;

    /** 含义列表 */
    private List<Means> meansList;


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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public List<Means> getMeansList() {
        return meansList;
    }

    public void setMeansList(List<Means> meansList) {
        this.meansList = meansList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("wordId", getWordId())
            .append("totalCount", getTotalCount())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }

}
