package com.jeethink.study.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.core.annotation.Excel;
import com.jeethink.common.core.web.domain.BaseEntity;

/**
 * 英语单词对象 means
 * 
 * @author jeethink
 * @date 2022-04-07
 */
public class Means extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long wordid;

    /** 词性ID */
    @Excel(name = "词性ID")
    private Integer posid;


    /** 词性代码 【外联表】 */
    @Excel(name = "词性代码")
    private String posName;
    /** 词性含义 【外联表】 */
    @Excel(name = "词性含义")
    private String posMean;



    /** 中文含义 */
    @Excel(name = "中文含义")
    private String means;



    public void setWordid(Long wordid) 
    {
        this.wordid = wordid;
    }

    public Long getWordid() 
    {
        return wordid;
    }
    public void setPosid(Integer posid) 
    {
        this.posid = posid;
    }

    public Integer getPosid() 
    {
        return posid;
    }
    public void setMeans(String means) 
    {
        this.means = means;
    }

    public String getMeans() 
    {
        return means;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("wordid", getWordid())
            .append("posid", getPosid())
            .append("means", getMeans())
            .toString();
    }



    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getPosMean() {
        return posMean;
    }

    public void setPosMean(String posMean) {
        this.posMean = posMean;
    }
}
