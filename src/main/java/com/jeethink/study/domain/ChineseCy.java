package com.jeethink.study.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.core.annotation.Excel;
import com.jeethink.common.core.web.domain.BaseEntity;

/**
 * 语文成语词典对象 chinese_cy
 * 
 * @author jeethink
 * @date 2022-03-22
 */
public class ChineseCy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String spell;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String content;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String derivation;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String samples;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
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
    public void setSpell(String spell) 
    {
        this.spell = spell;
    }

    public String getSpell() 
    {
        return spell;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setDerivation(String derivation) 
    {
        this.derivation = derivation;
    }

    public String getDerivation() 
    {
        return derivation;
    }
    public void setSamples(String samples) 
    {
        this.samples = samples;
    }

    public String getSamples() 
    {
        return samples;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("spell", getSpell())
            .append("content", getContent())
            .append("derivation", getDerivation())
            .append("samples", getSamples())
            .append("type", getType())
            .toString();
    }
}
