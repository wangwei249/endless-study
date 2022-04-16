package com.jeethink.study.service.impl;

import java.util.List;
import java.util.Map;

import com.jeethink.common.core.utils.DateUtils;
import com.jeethink.study.domain.assist.NewWordsCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.study.mapper.NewWordsMapper;
import com.jeethink.study.domain.NewWords;
import com.jeethink.study.service.INewWordsService;

/**
 * 生词Service业务层处理
 * 
 * @author jeethink
 * @date 2022-04-08
 */
@Service
public class NewWordsServiceImpl implements INewWordsService 
{
    @Autowired
    private NewWordsMapper newWordsMapper;

    /**
     * 查询生词
     * 
     * @param id 生词ID
     * @return 生词
     */
    @Override
    public NewWords selectNewWordsById(Long id)
    {
        return newWordsMapper.selectNewWordsById(id);
    }

    /**
     * 查询生词列表
     * 
     * @param newWords 生词
     * @return 生词
     */
    @Override
    public List<NewWords> selectNewWordsList(NewWords newWords)
    {
        return newWordsMapper.selectNewWordsList(newWords);
    }


    /**
     * 查询生词列表
     *
     * @param newWords 生词
     * @return 生词
     */
    @Override
    public List<NewWords> selectNewWordsRandomList(NewWords newWords)
    {
        return newWordsMapper.selectNewWordsRandomList(newWords);
    }

    /**
     * 查询生词汇总信息
     *
     * @param userId 生词
     * @return 生词
     */
    @Override
    public NewWordsCollect selectNewWordsCollect(long userId)
    {
        return newWordsMapper.selectNewWordsCollect(userId);
    }

    /**
     * 新增生词
     * 
     * @param newWords 生词
     * @return 结果
     */
    @Override
    public int insertNewWords(NewWords newWords)
    {
        newWords.setCreateTime(DateUtils.getNowDate());
        return newWordsMapper.insertNewWords(newWords);
    }

    /**
     * 修改生词
     * 
     * @param newWords 生词
     * @return 结果
     */
    @Override
    public int updateNewWords(NewWords newWords)
    {
        newWords.setUpdateTime(DateUtils.getNowDate());
        return newWordsMapper.updateNewWords(newWords);
    }

    /**
     * 批量删除生词
     * 
     * @param ids 需要删除的生词ID
     * @return 结果
     */
    @Override
    public int deleteNewWordsByIds(Long[] ids)
    {
        return newWordsMapper.deleteNewWordsByIds(ids);
    }

    /**
     * 删除生词信息
     * 
     * @param id 生词ID
     * @return 结果
     */
    @Override
    public int deleteNewWordsById(Long id)
    {
        return newWordsMapper.deleteNewWordsById(id);
    }
}
