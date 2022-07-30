package com.jeethink.study.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jeethink.common.log.annotation.Log;
import com.jeethink.common.log.enums.BusinessType;
import com.jeethink.common.security.annotation.PreAuthorize;
import com.jeethink.study.domain.NewWordsSetting;
import com.jeethink.study.service.INewWordsSettingService;
import com.jeethink.common.core.web.controller.BaseController;
import com.jeethink.common.core.web.domain.AjaxResult;
import com.jeethink.common.core.utils.poi.ExcelUtil;
import com.jeethink.common.core.web.page.TableDataInfo;

/**
 * 生词目标参数设置Controller
 * 
 * @author jeethink
 * @date 2022-05-10
 */
@RestController
@RequestMapping("/setting")
public class NewWordsSettingController extends BaseController
{
    @Autowired
    private INewWordsSettingService newWordsSettingService;

    /**
     * 查询生词目标参数设置列表
     */
//    @PreAuthorize(hasPermi = "study:setting:list")
    @GetMapping("/list")
    public TableDataInfo list(NewWordsSetting newWordsSetting)
    {
        startPage();
        List<NewWordsSetting> list = newWordsSettingService.selectNewWordsSettingList(newWordsSetting);
        return getDataTable(list);
    }

    /**
     * 导出生词目标参数设置列表
     */
    @PreAuthorize(hasPermi = "study:setting:export")
    @Log(title = "生词目标参数设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NewWordsSetting newWordsSetting) throws IOException
    {
        List<NewWordsSetting> list = newWordsSettingService.selectNewWordsSettingList(newWordsSetting);
        ExcelUtil<NewWordsSetting> util = new ExcelUtil<NewWordsSetting>(NewWordsSetting.class);
        util.exportExcel(response, list, "setting");
    }

    /**
     * 获取生词目标参数设置详细信息
     */
    @PreAuthorize(hasPermi = "study:setting:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(newWordsSettingService.selectNewWordsSettingById(id));
    }

    /**
     * 新增生词目标参数设置
     */
    @PreAuthorize(hasPermi = "study:setting:add")
    @Log(title = "生词目标参数设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NewWordsSetting newWordsSetting)
    {
        return toAjax(newWordsSettingService.insertNewWordsSetting(newWordsSetting));
    }

    /**
     * 修改生词目标参数设置
     */
    @PreAuthorize(hasPermi = "study:setting:edit")
    @Log(title = "生词目标参数设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NewWordsSetting newWordsSetting)
    {
        return toAjax(newWordsSettingService.updateNewWordsSetting(newWordsSetting));
    }

    /**
     * 修改生词目标参数设置
     */
//    @PreAuthorize(hasPermi = "study:setting:edit")
    @Log(title = "生词目标参数设置", businessType = BusinessType.UPDATE)
    @PostMapping("/editBatch")
    public AjaxResult editBatch(@RequestBody List<NewWordsSetting> newWordsSettingList)
    {
        int successCount = newWordsSettingService.editBatch(newWordsSettingList);
//
//        //确认哪些是要删除的数据
//        List deleteList = new ArrayList();
//        if(newWordsSettingList.size()>0){
//            NewWordsSetting temp = new NewWordsSetting();
//            temp.setUserId(newWordsSettingList.get(0).getUserId());
//            temp.setSettingType(newWordsSettingList.get(0).getSettingType());
//            List tmpList = newWordsSettingService.selectNewWordsSettingList(temp);
//            for(int i=0;i<tmpList.size();i++){
//                boolean isExist = false;
//                NewWordsSetting exist = (NewWordsSetting)tmpList.get(i);
//                for(NewWordsSetting setting :newWordsSettingList){
//                    if(setting.getSettingName().equals(exist.getSettingName())){
//                        isExist = true;
//                        break;
//                    }
//                }
//                if(!isExist){
//                    deleteList.add(exist);
//                }
//            }
//        }
//
//        //更新或增加
//        List<NewWordsSetting> oldList = null;
//        for(NewWordsSetting setting :newWordsSettingList){
//            oldList = newWordsSettingService.selectNewWordsSettingList(setting);
//            if(oldList.size()>0){
//                successCount += newWordsSettingService.updateNewWordsSetting(setting);
//            }else{
//                successCount += newWordsSettingService.insertNewWordsSetting(setting);
//            }
//        }
//        //删除
//        if(deleteList.size()>0){
//            Integer[] ids = new Integer[deleteList.size()];
//            for(int i=0;i<deleteList.size();i++){
//                ids[i] = ((NewWordsSetting)deleteList.get(i)).getId();
//            }
//            newWordsSettingService.deleteNewWordsSettingByIds(ids);
//        }

        return toAjax(successCount);
    }

    /**
     * 删除生词目标参数设置
     */
    @PreAuthorize(hasPermi = "study:setting:remove")
    @Log(title = "生词目标参数设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(newWordsSettingService.deleteNewWordsSettingByIds(ids));
    }
}
