package com.jeethink.study.service;

import java.util.List;
import java.util.Map;

import com.jeethink.study.domain.NewWords;
import com.jeethink.study.domain.assist.NewWordsCollect;

/**
 * 生词Service接口
 * 
 * @author jeethink
 * @date 2022-04-08
 */
public interface INewWordsService 
{
    /**
     * 查询生词
     * 
     * @param id 生词ID
     * @return 生词
     */
    public NewWords selectNewWordsById(Long id);

    /**
     * 查询生词列表
     * 
     * @param newWords 生词
     * @return 生词集合
     */
    public List<NewWords> selectNewWordsList(NewWords newWords);

    /**
     * 查询生词列表
     *
     * @param newWords 生词
     * @return 生词集合
     */
    public List<NewWords> selectNewWordsRandomList(NewWords newWords);

    /**
     * 查询生词汇总信息
     *
     * @param userId 生词
     * @return 【总数，已消灭，未消灭】
     */
    public NewWordsCollect selectNewWordsCollect(long userId);

    /**
     * 查询线性图表信息【查询月份目标设定的目标值，完成值，通过值】
     *
     * @param userId 生词
     * @return 【总数，已消灭，未消灭】
     */
    public List<NewWordsCollect> selectExpectActual(long userId);

    /**
     * 查询应战数据图表【应战数，成功数，失败数】
     *
     * @param userId 生词
     * @return
     */
    public List<NewWordsCollect> selectChallengeCollect(long userId,String type);

    /**
     * 新增生词
     * 
     * @param newWords 生词
     * @return 结果
     */
    public int insertNewWords(NewWords newWords);

    /**
     * 修改生词
     * 
     * @param newWords 生词
     * @return 结果
     */
    public int updateNewWords(NewWords newWords);

    /**
     * 批量删除生词
     * 
     * @param ids 需要删除的生词ID
     * @return 结果
     */
    public int deleteNewWordsByIds(Long[] ids);

    /**
     * 删除生词信息
     * 
     * @param id 生词ID
     * @return 结果
     */
    public int deleteNewWordsById(Long id);
}
