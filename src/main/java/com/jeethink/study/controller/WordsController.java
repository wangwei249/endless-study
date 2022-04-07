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
import com.jeethink.study.domain.Words;
import com.jeethink.study.service.IWordsService;
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
@RequestMapping("/englishWords")
public class WordsController extends BaseController
{
    @Autowired
    private IWordsService wordsService;

    /**
     * 查询英语单词列表
     */
    @PreAuthorize(hasPermi = "study:englishWords:list")
    @GetMapping("/list")
    public TableDataInfo list(Words words)
    {
        startPage();
        List<Words> list = wordsService.selectWordsList(words);
        return getDataTable(list);
    }

    /**
     * 导出英语单词列表
     */
    @PreAuthorize(hasPermi = "study:englishWords:export")
    @Log(title = "英语单词", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Words words) throws IOException
    {
        List<Words> list = wordsService.selectWordsList(words);
        ExcelUtil<Words> util = new ExcelUtil<Words>(Words.class);
        util.exportExcel(response, list, "englishWords");
    }

    /**
     * 获取英语单词详细信息
     */
    @PreAuthorize(hasPermi = "study:englishWords:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wordsService.selectWordsById(id));
    }

    /**
     * 新增英语单词
     */
    @PreAuthorize(hasPermi = "study:englishWords:add")
    @Log(title = "英语单词", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Words words)
    {
        return toAjax(wordsService.insertWords(words));
    }

    /**
     * 修改英语单词
     */
    @PreAuthorize(hasPermi = "study:englishWords:edit")
    @Log(title = "英语单词", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Words words)
    {
        return toAjax(wordsService.updateWords(words));
    }

    /**
     * 删除英语单词
     */
    @PreAuthorize(hasPermi = "study:englishWords:remove")
    @Log(title = "英语单词", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wordsService.deleteWordsByIds(ids));
    }
}
