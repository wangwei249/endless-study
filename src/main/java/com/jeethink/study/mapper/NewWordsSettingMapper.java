package com.jeethink.study.mapper;

import java.util.List;
import com.jeethink.study.domain.NewWordsSetting;

/**
 * 生词目标参数设置Mapper接口
 * 
 * @author jeethink
 * @date 2022-05-10
 */
public interface NewWordsSettingMapper 
{
    /**
     * 查询生词目标参数设置
     * 
     * @param id 生词目标参数设置ID
     * @return 生词目标参数设置
     */
    public NewWordsSetting selectNewWordsSettingById(Integer id);

    /**
     * 查询生词目标参数设置列表
     * 
     * @param newWordsSetting 生词目标参数设置
     * @return 生词目标参数设置集合
     */
    public List<NewWordsSetting> selectNewWordsSettingList(NewWordsSetting newWordsSetting);

    /**
     * 新增生词目标参数设置
     * 
     * @param newWordsSetting 生词目标参数设置
     * @return 结果
     */
    public int insertNewWordsSetting(NewWordsSetting newWordsSetting);

    /**
     * 修改生词目标参数设置
     * 
     * @param newWordsSetting 生词目标参数设置
     * @return 结果
     */
    public int updateNewWordsSetting(NewWordsSetting newWordsSetting);

    /**
     * 删除生词目标参数设置
     * 
     * @param id 生词目标参数设置ID
     * @return 结果
     */
    public int deleteNewWordsSettingById(Integer id);

    /**
     * 批量删除生词目标参数设置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNewWordsSettingByIds(Integer[] ids);
}
