package com.jeethink.study.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.study.mapper.MeansMapper;
import com.jeethink.study.domain.Means;
import com.jeethink.study.service.IMeansService;

/**
 * 英语单词Service业务层处理
 * 
 * @author jeethink
 * @date 2022-04-07
 */
@Service
public class MeansServiceImpl implements IMeansService 
{
    @Autowired
    private MeansMapper meansMapper;

    /**
     * 查询英语单词
     * 
     * @param wordid 英语单词ID
     * @return 英语单词
     */
    @Override
    public Means selectMeansById(Long wordid)
    {
        return meansMapper.selectMeansById(wordid);
    }

    /**
     * 查询英语单词列表
     * 
     * @param means 英语单词
     * @return 英语单词
     */
    @Override
    public List<Means> selectMeansList(Means means)
    {
        return meansMapper.selectMeansList(means);
    }

    /**
     * 新增英语单词
     * 
     * @param means 英语单词
     * @return 结果
     */
    @Override
    public int insertMeans(Means means)
    {
        return meansMapper.insertMeans(means);
    }

    /**
     * 修改英语单词
     * 
     * @param means 英语单词
     * @return 结果
     */
    @Override
    public int updateMeans(Means means)
    {
        return meansMapper.updateMeans(means);
    }

    /**
     * 批量删除英语单词
     * 
     * @param wordids 需要删除的英语单词ID
     * @return 结果
     */
    @Override
    public int deleteMeansByIds(Long[] wordids)
    {
        return meansMapper.deleteMeansByIds(wordids);
    }

    /**
     * 删除英语单词信息
     * 
     * @param wordid 英语单词ID
     * @return 结果
     */
    @Override
    public int deleteMeansById(Long wordid)
    {
        return meansMapper.deleteMeansById(wordid);
    }
}
