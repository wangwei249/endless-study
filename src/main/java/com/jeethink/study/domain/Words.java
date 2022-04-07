package com.jeethink.study.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.core.annotation.Excel;
import com.jeethink.common.core.web.domain.BaseEntity;

/**
 * 英语单词对象 words
 * 
 * @author jeethink
 * @date 2022-04-07
 */
public class Words extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 单词ID */
    private Long id;

    /** 单词 */
    @Excel(name = "单词")
    private String word;

    /** 单词变换 */
    @Excel(name = "单词变换")
    private String exchange;

    /** 发音 */
    @Excel(name = "发音")
    private String voice;

    /** 时长 */
    @Excel(name = "时长")
    private Long times;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWord(String word) 
    {
        this.word = word;
    }

    public String getWord() 
    {
        return word;
    }
    public void setExchange(String exchange) 
    {
        this.exchange = exchange;
    }

    public String getExchange() 
    {
        return exchange;
    }
    public void setVoice(String voice) 
    {
        this.voice = voice;
    }

    public String getVoice() 
    {
        return voice;
    }
    public void setTimes(Long times) 
    {
        this.times = times;
    }

    public Long getTimes() 
    {
        return times;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("word", getWord())
            .append("exchange", getExchange())
            .append("voice", getVoice())
            .append("times", getTimes())
            .toString();
    }
}
