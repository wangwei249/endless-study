package com.jeethink.study.controller;

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
import com.jeethink.study.domain.NewWordsRecords;
import com.jeethink.study.service.INewWordsRecordsService;
import com.jeethink.common.core.web.controller.BaseController;
import com.jeethink.common.core.web.domain.AjaxResult;
import com.jeethink.common.core.utils.poi.ExcelUtil;
import com.jeethink.common.core.web.page.TableDataInfo;

/**
 * 生词练习记录Controller
 * 
 * @author jeethink
 * @date 2022-04-08
 */
@RestController
@RequestMapping("/newWordsRecords")
public class NewWordsRecordsController extends BaseController
{
    @Autowired
    private INewWordsRecordsService newWordsRecordsService;

    /**
     * 查询生词练习记录列表
     */
    @PreAuthorize(hasPermi = "study:newWordsRecords:list")
    @GetMapping("/list")
    public TableDataInfo list(NewWordsRecords newWordsRecords)
    {
        startPage();
        List<NewWordsRecords> list = newWordsRecordsService.selectNewWordsRecordsList(newWordsRecords);
        return getDataTable(list);
    }

    /**
     * 导出生词练习记录列表
     */
    @PreAuthorize(hasPermi = "study:newWordsRecords:export")
    @Log(title = "生词练习记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NewWordsRecords newWordsRecords) throws IOException
    {
        List<NewWordsRecords> list = newWordsRecordsService.selectNewWordsRecordsList(newWordsRecords);
        ExcelUtil<NewWordsRecords> util = new ExcelUtil<NewWordsRecords>(NewWordsRecords.class);
        util.exportExcel(response, list, "newWordsRecords");
    }

    /**
     * 获取生词练习记录详细信息
     */
    @PreAuthorize(hasPermi = "study:newWordsRecords:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(newWordsRecordsService.selectNewWordsRecordsById(id));
    }

    /**
     * 新增生词练习记录
     */
    @PreAuthorize(hasPermi = "study:newWordsRecords:add")
    @Log(title = "生词练习记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NewWordsRecords newWordsRecords)
    {
        return toAjax(newWordsRecordsService.insertNewWordsRecords(newWordsRecords));
    }

    /**
     * 修改生词练习记录
     */
    @PreAuthorize(hasPermi = "study:newWordsRecords:edit")
    @Log(title = "生词练习记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NewWordsRecords newWordsRecords)
    {
        return toAjax(newWordsRecordsService.updateNewWordsRecords(newWordsRecords));
    }

    /**
     * 删除生词练习记录
     */
    @PreAuthorize(hasPermi = "study:newWordsRecords:remove")
    @Log(title = "生词练习记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(newWordsRecordsService.deleteNewWordsRecordsByIds(ids));
    }
}
