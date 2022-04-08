package com.jeethink.study.service;

import java.util.List;
import com.jeethink.study.domain.NewWords;

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
