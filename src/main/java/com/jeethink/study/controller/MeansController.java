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
import com.jeethink.study.domain.Means;
import com.jeethink.study.service.IMeansService;
import com.jeethink.common.core.web.controller.BaseController;
import com.jeethink.common.core.web.domain.AjaxResult;
import com.jeethink.common.core.utils.poi.ExcelUtil;
import com.jeethink.common.core.web.page.TableDataInfo;

/**
 * 英语单词Controller
 * 
 * @author jeethink
 * @date 2022-04-07
 */
@RestController
@RequestMapping("/wordsMean")
public class MeansController extends BaseController
{
    @Autowired
    private IMeansService meansService;

    /**
     * 查询英语单词列表
     */
    @PreAuthorize(hasPermi = "study:wordsMean:list")
    @GetMapping("/list")
    public TableDataInfo list(Means means)
    {
        startPage();
        List<Means> list = meansService.selectMeansList(means);
        return getDataTable(list);
    }

    /**
     * 导出英语单词列表
     */
    @PreAuthorize(hasPermi = "study:wordsMean:export")
    @Log(title = "英语单词", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Means means) throws IOException
    {
        List<Means> list = meansService.selectMeansList(means);
        ExcelUtil<Means> util = new ExcelUtil<Means>(Means.class);
        util.exportExcel(response, list, "wordsMean");
    }

    /**
     * 获取英语单词详细信息
     */
    @PreAuthorize(hasPermi = "study:wordsMean:query")
    @GetMapping(value = "/{wordid}")
    public AjaxResult getInfo(@PathVariable("wordid") Long wordid)
    {
        return AjaxResult.success(meansService.selectMeansById(wordid));
    }

    /**
     * 新增英语单词
     */
    @PreAuthorize(hasPermi = "study:wordsMean:add")
    @Log(title = "英语单词", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Means means)
    {
        return toAjax(meansService.insertMeans(means));
    }

    /**
     * 修改英语单词
     */
    @PreAuthorize(hasPermi = "study:wordsMean:edit")
    @Log(title = "英语单词", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Means means)
    {
        return toAjax(meansService.updateMeans(means));
    }

    /**
     * 删除英语单词
     */
    @PreAuthorize(hasPermi = "study:wordsMean:remove")
    @Log(title = "英语单词", businessType = BusinessType.DELETE)
	@DeleteMapping("/{wordids}")
    public AjaxResult remove(@PathVariable Long[] wordids)
    {
        return toAjax(meansService.deleteMeansByIds(wordids));
    }
}
