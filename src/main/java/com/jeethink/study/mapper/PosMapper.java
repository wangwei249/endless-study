package com.jeethink.study.mapper;

import java.util.List;
import com.jeethink.study.domain.Pos;

/**
 * 英语单词-词性Mapper接口
 * 
 * @author jeethink
 * @date 2022-04-07
 */
public interface PosMapper 
{
    /**
     * 查询英语单词-词性
     * 
     * @param id 英语单词-词性ID
     * @return 英语单词-词性
     */
    public Pos selectPosById(Integer id);

    /**
     * 查询英语单词-词性列表
     * 
     * @param pos 英语单词-词性
     * @return 英语单词-词性集合
     */
    public List<Pos> selectPosList(Pos pos);

    /**
     * 新增英语单词-词性
     * 
     * @param pos 英语单词-词性
     * @return 结果
     */
    public int insertPos(Pos pos);

    /**
     * 修改英语单词-词性
     * 
     * @param pos 英语单词-词性
     * @return 结果
     */
    public int updatePos(Pos pos);

    /**
     * 删除英语单词-词性
     * 
     * @param id 英语单词-词性ID
     * @return 结果
     */
    public int deletePosById(Integer id);

    /**
     * 批量删除英语单词-词性
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePosByIds(Integer[] ids);
}
