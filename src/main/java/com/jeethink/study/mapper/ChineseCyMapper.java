package com.jeethink.study.mapper;

import java.util.List;
import com.jeethink.study.domain.ChineseCy;
import org.springframework.stereotype.Component;

/**
 * 语文成语词典Mapper接口
 * 
 * @author jeethink
 * @date 2022-03-22
 */
public interface ChineseCyMapper 
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
     * 删除语文成语词典
     * 
     * @param id 语文成语词典ID
     * @return 结果
     */
    public int deleteChineseCyById(Long id);

    /**
     * 批量删除语文成语词典
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteChineseCyByIds(Long[] ids);
}
