package com.jeethink.study.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.core.annotation.Excel;
import com.jeethink.common.core.web.domain.BaseEntity;

/**
 * 生词目标参数设置对象 new_words_setting
 * 
 * @author jeethink
 * @date 2022-05-10
 */
public class NewWordsSetting extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long userId;

    /** 配置类型 */
    @Excel(name = "配置类型")
    private String settingType;

    /** 配置项 */
    @Excel(name = "配置项")
    private String settingName;

    /** 配置值 */
    @Excel(name = "配置值")
    private String settingValue;

    /** 状态【T:生效，F：不生效】 */
    @Excel(name = "状态【T:生效，F：不生效】")
    private String status;

    /** $column.columnComment */
    @Excel(name = "状态【T:生效，F：不生效】")
    private String settingValueTwo;

    /** $column.columnComment */
    @Excel(name = "状态【T:生效，F：不生效】")
    private String settingValueThree;

    /** $column.columnComment */
    @Excel(name = "状态【T:生效，F：不生效】")
    private String settingValueFour;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
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
    public void setSettingType(String settingType) 
    {
        this.settingType = settingType;
    }

    public String getSettingType() 
    {
        return settingType;
    }
    public void setSettingName(String settingName) 
    {
        this.settingName = settingName;
    }

    public String getSettingName() 
    {
        return settingName;
    }
    public void setSettingValue(String settingValue) 
    {
        this.settingValue = settingValue;
    }

    public String getSettingValue() 
    {
        return settingValue;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setSettingValueTwo(String settingValueTwo) 
    {
        this.settingValueTwo = settingValueTwo;
    }

    public String getSettingValueTwo() 
    {
        return settingValueTwo;
    }
    public void setSettingValueThree(String settingValueThree) 
    {
        this.settingValueThree = settingValueThree;
    }

    public String getSettingValueThree() 
    {
        return settingValueThree;
    }
    public void setSettingValueFour(String settingValueFour) 
    {
        this.settingValueFour = settingValueFour;
    }

    public String getSettingValueFour() 
    {
        return settingValueFour;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("settingType", getSettingType())
            .append("settingName", getSettingName())
            .append("settingValue", getSettingValue())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("settingValueTwo", getSettingValueTwo())
            .append("settingValueThree", getSettingValueThree())
            .append("settingValueFour", getSettingValueFour())
            .toString();
    }
}
