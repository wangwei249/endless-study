package com.jeethink.study.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.study.mapper.PosMapper;
import com.jeethink.study.domain.Pos;
import com.jeethink.study.service.IPosService;

/**
 * 英语单词-词性Service业务层处理
 * 
 * @author jeethink
 * @date 2022-04-07
 */
@Service
public class PosServiceImpl implements IPosService 
{
    @Autowired
    private PosMapper posMapper;

    /**
     * 查询英语单词-词性
     * 
     * @param id 英语单词-词性ID
     * @return 英语单词-词性
     */
    @Override
    public Pos selectPosById(Integer id)
    {
        return posMapper.selectPosById(id);
    }

    /**
     * 查询英语单词-词性列表
     * 
     * @param pos 英语单词-词性
     * @return 英语单词-词性
     */
    @Override
    public List<Pos> selectPosList(Pos pos)
    {
        return posMapper.selectPosList(pos);
    }

    /**
     * 新增英语单词-词性
     * 
     * @param pos 英语单词-词性
     * @return 结果
     */
    @Override
    public int insertPos(Pos pos)
    {
        return posMapper.insertPos(pos);
    }

    /**
     * 修改英语单词-词性
     * 
     * @param pos 英语单词-词性
     * @return 结果
     */
    @Override
    public int updatePos(Pos pos)
    {
        return posMapper.updatePos(pos);
    }

    /**
     * 批量删除英语单词-词性
     * 
     * @param ids 需要删除的英语单词-词性ID
     * @return 结果
     */
    @Override
    public int deletePosByIds(Integer[] ids)
    {
        return posMapper.deletePosByIds(ids);
    }

    /**
     * 删除英语单词-词性信息
     * 
     * @param id 英语单词-词性ID
     * @return 结果
     */
    @Override
    public int deletePosById(Integer id)
    {
        return posMapper.deletePosById(id);
    }
}
