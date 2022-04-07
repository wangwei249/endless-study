package com.jeethink.study.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.core.annotation.Excel;
import com.jeethink.common.core.web.domain.BaseEntity;

/**
 * 英语单词-词性对象 pos
 * 
 * @author jeethink
 * @date 2022-04-07
 */
public class Pos extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 词性ID */
    private Integer id;

    /** 词性代码 */
    @Excel(name = "词性代码")
    private String name;

    /** 词性名称 */
    @Excel(name = "词性名称")
    private String means;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
            .append("id", getId())
            .append("name", getName())
            .append("means", getMeans())
            .toString();
    }
}
