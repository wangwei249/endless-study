package com.jeethink.study.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.study.mapper.WordsMapper;
import com.jeethink.study.domain.Words;
import com.jeethink.study.service.IWordsService;

/**
 * 英语单词Service业务层处理
 * 
 * @author jeethink
 * @date 2022-04-07
 */
@Service
public class WordsServiceImpl implements IWordsService 
{
    @Autowired
    private WordsMapper wordsMapper;

    /**
     * 查询英语单词
     * 
     * @param id 英语单词ID
     * @return 英语单词
     */
    @Override
    public Words selectWordsById(Long id)
    {
        return wordsMapper.selectWordsById(id);
    }

    /**
     * 查询英语单词列表
     * 
     * @param words 英语单词
     * @return 英语单词
     */
    @Override
    public List<Words> selectWordsList(Words words)
    {
        return wordsMapper.selectWordsList(words);
    }

    /**
     * 新增英语单词
     * 
     * @param words 英语单词
     * @return 结果
     */
    @Override
    public int insertWords(Words words)
    {
        return wordsMapper.insertWords(words);
    }

    /**
     * 修改英语单词
     * 
     * @param words 英语单词
     * @return 结果
     */
    @Override
    public int updateWords(Words words)
    {
        return wordsMapper.updateWords(words);
    }

    /**
     * 批量删除英语单词
     * 
     * @param ids 需要删除的英语单词ID
     * @return 结果
     */
    @Override
    public int deleteWordsByIds(Long[] ids)
    {
        return wordsMapper.deleteWordsByIds(ids);
    }

    /**
     * 删除英语单词信息
     * 
     * @param id 英语单词ID
     * @return 结果
     */
    @Override
    public int deleteWordsById(Long id)
    {
        return wordsMapper.deleteWordsById(id);
    }
}
