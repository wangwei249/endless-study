package com.jeethink.study.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.study.mapper.ChineseCyMapper;
import com.jeethink.study.domain.ChineseCy;
import com.jeethink.study.service.IChineseCyService;

/**
 * 语文成语词典Service业务层处理
 * 
 * @author jeethink
 * @date 2022-03-22
 */
@Service
public class ChineseCyServiceImpl implements IChineseCyService 
{
    @Autowired
    private ChineseCyMapper chineseCyMapper;

    /**
     * 查询语文成语词典
     * 
     * @param id 语文成语词典ID
     * @return 语文成语词典
     */
    @Override
    public ChineseCy selectChineseCyById(Long id)
    {
        return chineseCyMapper.selectChineseCyById(id);
    }

    /**
     * 查询语文成语词典列表
     * 
     * @param chineseCy 语文成语词典
     * @return 语文成语词典
     */
    @Override
    public List<ChineseCy> selectChineseCyList(ChineseCy chineseCy)
    {
        return chineseCyMapper.selectChineseCyList(chineseCy);
    }

    /**
     * 新增语文成语词典
     * 
     * @param chineseCy 语文成语词典
     * @return 结果
     */
    @Override
    public int insertChineseCy(ChineseCy chineseCy)
    {
        return chineseCyMapper.insertChineseCy(chineseCy);
    }

    /**
     * 修改语文成语词典
     * 
     * @param chineseCy 语文成语词典
     * @return 结果
     */
    @Override
    public int updateChineseCy(ChineseCy chineseCy)
    {
        return chineseCyMapper.updateChineseCy(chineseCy);
    }

    /**
     * 批量删除语文成语词典
     * 
     * @param ids 需要删除的语文成语词典ID
     * @return 结果
     */
    @Override
    public int deleteChineseCyByIds(Long[] ids)
    {
        return chineseCyMapper.deleteChineseCyByIds(ids);
    }

    /**
     * 删除语文成语词典信息
     * 
     * @param id 语文成语词典ID
     * @return 结果
     */
    @Override
    public int deleteChineseCyById(Long id)
    {
        return chineseCyMapper.deleteChineseCyById(id);
    }
}
