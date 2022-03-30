package com.jeethink.study.service;

import java.util.List;
import com.jeethink.study.domain.ChineseCy;

/**
 * 语文成语词典Service接口
 * 
 * @author jeethink
 * @date 2022-03-22
 */
public interface IChineseCyService 
{
    /**
     * 查询语文成语词典
     * 
     * @param id 语文成语词典ID
     * @return 语文成语词典
     */
    public ChineseCy selectChineseCyById(Long id);

    /**
     * 查询语文成语词典列表
     * 
     * @param chineseCy 语文成语词典
     * @return 语文成语词典集合
     */
    public List<ChineseCy> selectChineseCyList(ChineseCy chineseCy);

    /**
     * 新增语文成语词典
     * 
     * @param chineseCy 语文成语词典
     * @return 结果
     */
    public int insertChineseCy(ChineseCy chineseCy);

    /**
     * 修改语文成语词典
     * 
     * @param chineseCy 语文成语词典
     * @return 结果
     */
    public int updateChineseCy(ChineseCy chineseCy);

    /**
     * 批量删除语文成语词典
     * 
     * @param ids 需要删除的语文成语词典ID
     * @return 结果
     */
    public int deleteChineseCyByIds(Long[] ids);

    /**
     * 删除语文成语词典信息
     * 
     * @param id 语文成语词典ID
     * @return 结果
     */
    public int deleteChineseCyById(Long id);
}
