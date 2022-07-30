package com.jeethink.study.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeethink.common.core.utils.DateUtils;
import com.jeethink.study.domain.assist.FriendsDyn;
import com.jeethink.study.domain.assist.HotWord;
import com.jeethink.study.domain.assist.NewWordsCollect;
import com.jeethink.study.domain.assist.NewWordsRank;
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
     * 查询线性图表信息【查询月份目标设定的目标值，完成值，通过值】
     *
     * @param userId 生词
     * @return 生词
     */
    @Override
    public List<NewWordsCollect> selectExpectActual(long userId)
    {
        return newWordsMapper.selectExpectActual(userId);
    }


    /**
     * 查询好友动态
     * @param userId 生词
     * @return 生词
     */
    @Override
    public List<FriendsDyn> selectFriendsDyn(long userId)
    {
        return newWordsMapper.selectFriendsDyn(userId);
    }

    /**
     * 查询应战数据图表【应战数，成功数，失败数】
     *
     * @param userId 生词
     * @return 生词
     */
    @Override
    public List<NewWordsCollect> selectChallengeCollect(long userId,String type)
    {
        Map map = new HashMap();
        map.put("USER_ID",userId);
        map.put("TYPE",type);
        return newWordsMapper.selectChallengeCollect(map);
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

    /**
     * 查询热词列表
     *
     * @param count 生词
     * @return 生词
     */
    @Override
    public List<HotWord> listHots(Integer count)
    {
        return newWordsMapper.listHots(count);
    }

    /**
     * 查询生词统计排行榜
     * @param status 生词
     * @return 生词
     */
    @Override
    public List<NewWordsRank> selectRank(String status)
    {
        return newWordsMapper.selectRank(status);
    }

}
