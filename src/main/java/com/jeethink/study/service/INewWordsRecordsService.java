package com.jeethink.study.service;

import java.util.List;
import com.jeethink.study.domain.NewWordsRecords;

/**
 * 生词练习记录Service接口
 * 
 * @author jeethink
 * @date 2022-04-08
 */
public interface INewWordsRecordsService 
{
    /**
     * 查询生词练习记录
     * 
     * @param id 生词练习记录ID
     * @return 生词练习记录
     */
    public NewWordsRecords selectNewWordsRecordsById(Long id);

    /**
     * 查询生词练习记录列表
     * 
     * @param newWordsRecords 生词练习记录
     * @return 生词练习记录集合
     */
    public List<NewWordsRecords> selectNewWordsRecordsList(NewWordsRecords newWordsRecords);

    /**
     * 新增生词练习记录
     * 
     * @param newWordsRecords 生词练习记录
     * @return 结果
     */
    public int insertNewWordsRecords(NewWordsRecords newWordsRecords);

    /**
     * 修改生词练习记录
     * 
     * @param newWordsRecords 生词练习记录
     * @return 结果
     */
    public int updateNewWordsRecords(NewWordsRecords newWordsRecords);

    /**
     * 批量删除生词练习记录
     * 
     * @param ids 需要删除的生词练习记录ID
     * @return 结果
     */
    public int deleteNewWordsRecordsByIds(Long[] ids);

    /**
     * 删除生词练习记录信息
     * 
     * @param id 生词练习记录ID
     * @return 结果
     */
    public int deleteNewWordsRecordsById(Long id);
}
