package com.jeethink.study.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.jeethink.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.study.mapper.NewWordsSettingMapper;
import com.jeethink.study.domain.NewWordsSetting;
import com.jeethink.study.service.INewWordsSettingService;

/**
 * 生词目标参数设置Service业务层处理
 * 
 * @author jeethink
 * @date 2022-05-10
 */
@Service
public class NewWordsSettingServiceImpl implements INewWordsSettingService 
{
    @Autowired
    private NewWordsSettingMapper newWordsSettingMapper;

    /**
     * 查询生词目标参数设置
     * 
     * @param id 生词目标参数设置ID
     * @return 生词目标参数设置
     */
    @Override
    public NewWordsSetting selectNewWordsSettingById(Integer id)
    {
        return newWordsSettingMapper.selectNewWordsSettingById(id);
    }

    /**
     * 查询生词目标参数设置列表
     * 
     * @param newWordsSetting 生词目标参数设置
     * @return 生词目标参数设置
     */
    @Override
    public List<NewWordsSetting> selectNewWordsSettingList(NewWordsSetting newWordsSetting)
    {
        return newWordsSettingMapper.selectNewWordsSettingList(newWordsSetting);
    }

    /**
     * 新增生词目标参数设置
     * 
     * @param newWordsSetting 生词目标参数设置
     * @return 结果
     */
    @Override
    public int insertNewWordsSetting(NewWordsSetting newWordsSetting)
    {
        newWordsSetting.setCreateTime(DateUtils.getNowDate());
        return newWordsSettingMapper.insertNewWordsSetting(newWordsSetting);
    }

    /**
     * 修改生词目标参数设置
     * 
     * @param newWordsSetting 生词目标参数设置
     * @return 结果
     */
    @Override
    public int updateNewWordsSetting(NewWordsSetting newWordsSetting)
    {
        newWordsSetting.setUpdateTime(DateUtils.getNowDate());
        return newWordsSettingMapper.updateNewWordsSetting(newWordsSetting);
    }

    /**
     * 批量删除生词目标参数设置
     * 
     * @param ids 需要删除的生词目标参数设置ID
     * @return 结果
     */
    @Override
    public int deleteNewWordsSettingByIds(Integer[] ids)
    {
        return newWordsSettingMapper.deleteNewWordsSettingByIds(ids);
    }

    /**
     * 删除生词目标参数设置信息
     * 
     * @param id 生词目标参数设置ID
     * @return 结果
     */
    @Override
    public int deleteNewWordsSettingById(Integer id)
    {
        return newWordsSettingMapper.deleteNewWordsSettingById(id);
    }



    /**
     * 批量修改生词目标参数设置
     *
     * @param newWordsSettingList 生词目标参数设置
     * @return 结果
     */
    @Override
    public int editBatch(List<NewWordsSetting> newWordsSettingList)
    {
        int successCount = 0;

        //确认哪些是要删除的数据
        List deleteList = new ArrayList();
        if(newWordsSettingList.size()>0){
            NewWordsSetting temp = new NewWordsSetting();
            temp.setUserId(newWordsSettingList.get(0).getUserId());
            temp.setSettingType(newWordsSettingList.get(0).getSettingType());
            List tmpList = this.selectNewWordsSettingList(temp);
            for(int i=0;i<tmpList.size();i++){
                boolean isExist = false;
                NewWordsSetting exist = (NewWordsSetting)tmpList.get(i);
                for(NewWordsSetting setting :newWordsSettingList){
                    if(setting.getSettingName().equals(exist.getSettingName())){
                        isExist = true;
                        break;
                    }
                }
                if(!isExist){
                    deleteList.add(exist);
                }
            }
        }

        //更新或增加
        List<NewWordsSetting> oldList = null;
        for(NewWordsSetting setting :newWordsSettingList){
            oldList = this.selectNewWordsSettingList(setting);
            if(oldList.size()>0){
                successCount += this.updateNewWordsSetting(setting);
            }else{
                successCount += this.insertNewWordsSetting(setting);
            }
        }
        //删除
        if(deleteList.size()>0){
            Integer[] ids = new Integer[deleteList.size()];
            for(int i=0;i<deleteList.size();i++){
                ids[i] = ((NewWordsSetting)deleteList.get(i)).getId();
            }
            this.deleteNewWordsSettingByIds(ids);
        }

        return successCount;
    }
}
