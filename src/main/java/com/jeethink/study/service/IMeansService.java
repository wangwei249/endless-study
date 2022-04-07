package com.jeethink.study.service;

import java.util.List;
import com.jeethink.study.domain.Means;

/**
 * 英语单词Service接口
 * 
 * @author jeethink
 * @date 2022-04-07
 */
public interface IMeansService 
{
    /**
     * 查询英语单词
     * 
     * @param wordid 英语单词ID
     * @return 英语单词
     */
    public Means selectMeansById(Long wordid);

    /**
     * 查询英语单词列表
     * 
     * @param means 英语单词
     * @return 英语单词集合
     */
    public List<Means> selectMeansList(Means means);

    /**
     * 新增英语单词
     * 
     * @param means 英语单词
     * @return 结果
     */
    public int insertMeans(Means means);

    /**
     * 修改英语单词
     * 
     * @param means 英语单词
     * @return 结果
     */
    public int updateMeans(Means means);

    /**
     * 批量删除英语单词
     * 
     * @param wordids 需要删除的英语单词ID
     * @return 结果
     */
    public int deleteMeansByIds(Long[] wordids);

    /**
     * 删除英语单词信息
     * 
     * @param wordid 英语单词ID
     * @return 结果
     */
    public int deleteMeansById(Long wordid);
}
