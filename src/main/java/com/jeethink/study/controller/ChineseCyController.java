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
import com.jeethink.study.domain.ChineseCy;
import com.jeethink.study.service.IChineseCyService;
import com.jeethink.common.core.web.controller.BaseController;
import com.jeethink.common.core.web.domain.AjaxResult;
import com.jeethink.common.core.utils.poi.ExcelUtil;
import com.jeethink.common.core.web.page.TableDataInfo;

/**
 * 语文成语词典Controller
 * 
 * @author jeethink
 * @date 2022-03-22
 */
@RestController
@RequestMapping("/chineseCy")
public class ChineseCyController extends BaseController
{
    @Autowired
    private IChineseCyService chineseCyService;

    /**
     * 查询语文成语词典列表
     */
    @PreAuthorize(hasPermi = "study:chineseCy:list")
    @GetMapping("/list")
    public TableDataInfo list(ChineseCy chineseCy)
    {
        startPage();
        List<ChineseCy> list = chineseCyService.selectChineseCyList(chineseCy);
        return getDataTable(list);
    }

    /**
     * 导出语文成语词典列表
     */
    @PreAuthorize(hasPermi = "study:chineseCy:export")
    @Log(title = "语文成语词典", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChineseCy chineseCy) throws IOException
    {
        List<ChineseCy> list = chineseCyService.selectChineseCyList(chineseCy);
        ExcelUtil<ChineseCy> util = new ExcelUtil<ChineseCy>(ChineseCy.class);
        util.exportExcel(response, list, "chineseCy");
    }

    /**
     * 获取语文成语词典详细信息
     */
    @PreAuthorize(hasPermi = "study:chineseCy:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(chineseCyService.selectChineseCyById(id));
    }

    /**
     * 新增语文成语词典
     */
    @PreAuthorize(hasPermi = "study:chineseCy:add")
    @Log(title = "语文成语词典", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChineseCy chineseCy)
    {
        return toAjax(chineseCyService.insertChineseCy(chineseCy));
    }

    /**
     * 修改语文成语词典
     */
    @PreAuthorize(hasPermi = "study:chineseCy:edit")
    @Log(title = "语文成语词典", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChineseCy chineseCy)
    {
        return toAjax(chineseCyService.updateChineseCy(chineseCy));
    }

    /**
     * 删除语文成语词典
     */
    @PreAuthorize(hasPermi = "study:chineseCy:remove")
    @Log(title = "语文成语词典", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chineseCyService.deleteChineseCyByIds(ids));
    }
}
