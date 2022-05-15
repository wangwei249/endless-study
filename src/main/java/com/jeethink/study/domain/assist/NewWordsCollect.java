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

    /** 待应战数 */
    private Long challengeNum;

    /** 可练习生词数 */
    private Long practiseNum;


    /**  线性图表 【年月】 */
    private String yearMonth;
    /**  线性图表 【目标数】 */
    private String expectNum;
    /**  线性图表 【实际数】 */
    private String actualNum;
    /**  线性图表 【月度通过数】 */
    private String actualPassNum;

    /**  线性图表 【月度目标通过数】 */
    private String expectPassNum;
    /**  线性图表 【月度目标通过数】 */
    private String expectRightRatio;
    /**  线性图表 【月度目标通过数】 */
    private String actualRightRatio;

    /**  线性图表 【月度应战/挑战成功数量】 */
    private String challengePassNum;
    /**  线性图表 【月度应战/挑战失败数量】 */
    private String challengeFailNum;


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

    public Long getChallengeNum() {
        return challengeNum;
    }

    public void setChallengeNum(Long challengeNum) {
        this.challengeNum = challengeNum;
    }

    public Long getPractiseNum() {
        return practiseNum;
    }

    public void setPractiseNum(Long practiseNum) {
        this.practiseNum = practiseNum;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getExpectNum() {
        return expectNum;
    }

    public void setExpectNum(String expectNum) {
        this.expectNum = expectNum;
    }

    public String getActualNum() {
        return actualNum;
    }

    public void setActualNum(String actualNum) {
        this.actualNum = actualNum;
    }

    public String getActualPassNum() {
        return actualPassNum;
    }

    public void setActualPassNum(String actualPassNum) {
        this.actualPassNum = actualPassNum;
    }

    public String getExpectPassNum() {
        return expectPassNum;
    }

    public void setExpectPassNum(String expectPassNum) {
        this.expectPassNum = expectPassNum;
    }

    public String getExpectRightRatio() {
        return expectRightRatio;
    }

    public void setExpectRightRatio(String expectRightRatio) {
        this.expectRightRatio = expectRightRatio;
    }

    public String getActualRightRatio() {
        return actualRightRatio;
    }

    public void setActualRightRatio(String actualRightRatio) {
        this.actualRightRatio = actualRightRatio;
    }

    public String getChallengePassNum() {
        return challengePassNum;
    }

    public void setChallengePassNum(String challengePassNum) {
        this.challengePassNum = challengePassNum;
    }

    public String getChallengeFailNum() {
        return challengeFailNum;
    }

    public void setChallengeFailNum(String challengeFailNum) {
        this.challengeFailNum = challengeFailNum;
    }
}
