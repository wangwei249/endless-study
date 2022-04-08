package com.jeethink.study.service.impl;

import java.util.List;
import com.jeethink.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.study.mapper.NewWordsRecordsMapper;
import com.jeethink.study.domain.NewWordsRecords;
import com.jeethink.study.service.INewWordsRecordsService;

/**
 * 生词练习记录Service业务层处理
 * 
 * @author jeethink
 * @date 2022-04-08
 */
@Service
public class NewWordsRecordsServiceImpl implements INewWordsRecordsService 
{
    @Autowired
    private NewWordsRecordsMapper newWordsRecordsMapper;

    /**
     * 查询生词练习记录
     * 
     * @param id 生词练习记录ID
     * @return 生词练习记录
     */
    @Override
    public NewWordsRecords selectNewWordsRecordsById(Long id)
    {
        return newWordsRecordsMapper.selectNewWordsRecordsById(id);
    }

    /**
     * 查询生词练习记录列表
     * 
     * @param newWordsRecords 生词练习记录
     * @return 生词练习记录
     */
    @Override
    public List<NewWordsRecords> selectNewWordsRecordsList(NewWordsRecords newWordsRecords)
    {
        return newWordsRecordsMapper.selectNewWordsRecordsList(newWordsRecords);
    }

    /**
     * 新增生词练习记录
     * 
     * @param newWordsRecords 生词练习记录
     * @return 结果
     */
    @Override
    public int insertNewWordsRecords(NewWordsRecords newWordsRecords)
    {
        newWordsRecords.setCreateTime(DateUtils.getNowDate());
        return newWordsRecordsMapper.insertNewWordsRecords(newWordsRecords);
    }

    /**
     * 修改生词练习记录
     * 
     * @param newWordsRecords 生词练习记录
     * @return 结果
     */
    @Override
    public int updateNewWordsRecords(NewWordsRecords newWordsRecords)
    {
        return newWordsRecordsMapper.updateNewWordsRecords(newWordsRecords);
    }

    /**
     * 批量删除生词练习记录
     * 
     * @param ids 需要删除的生词练习记录ID
     * @return 结果
     */
    @Override
    public int deleteNewWordsRecordsByIds(Long[] ids)
    {
        return newWordsRecordsMapper.deleteNewWordsRecordsByIds(ids);
    }

    /**
     * 删除生词练习记录信息
     * 
     * @param id 生词练习记录ID
     * @return 结果
     */
    @Override
    public int deleteNewWordsRecordsById(Long id)
    {
        return newWordsRecordsMapper.deleteNewWordsRecordsById(id);
    }
}
