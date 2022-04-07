package com.jeethink.study.mapper;

import java.util.List;
import com.jeethink.study.domain.Words;

/**
 * 英语单词Mapper接口
 * 
 * @author jeethink
 * @date 2022-04-07
 */
public interface WordsMapper 
{
    /**
     * 查询英语单词
     * 
     * @param id 英语单词ID
     * @return 英语单词
     */
    public Words selectWordsById(Long id);

    /**
     * 查询英语单词列表
     * 
     * @param words 英语单词
     * @return 英语单词集合
     */
    public List<Words> selectWordsList(Words words);

    /**
     * 新增英语单词
     * 
     * @param words 英语单词
     * @return 结果
     */
    public int insertWords(Words words);

    /**
     * 修改英语单词
     * 
     * @param words 英语单词
     * @return 结果
     */
    public int updateWords(Words words);

    /**
     * 删除英语单词
     * 
     * @param id 英语单词ID
     * @return 结果
     */
    public int deleteWordsById(Long id);

    /**
     * 批量删除英语单词
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWordsByIds(Long[] ids);
}
