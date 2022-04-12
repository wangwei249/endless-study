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
import com.jeethink.study.domain.NewWords;
import com.jeethink.study.service.INewWordsService;
import com.jeethink.common.core.web.controller.BaseController;
import com.jeethink.common.core.web.domain.AjaxResult;
import com.jeethink.common.core.utils.poi.ExcelUtil;
import com.jeethink.common.core.web.page.TableDataInfo;

/**
 * 生词Controller
 * 
 * @author jeethink
 * @date 2022-04-08
 */
@RestController
@RequestMapping("/newWords")
public class NewWordsController extends BaseController
{
    @Autowired
    private INewWordsService newWordsService;

    /**
     * 查询生词列表
     */
    @PreAuthorize(hasPermi = "study:newWords:list")
    @GetMapping("/list")
    public TableDataInfo list(NewWords newWords)
    {
        startPage();
        List<NewWords> list = newWordsService.selectNewWordsList(newWords);
        return getDataTable(list);
    }

    /**
     * 查询生词列表【随机一条】
     */
    //@PreAuthorize(hasPermi = "study:newWords:list")
    @GetMapping("/listRandom")
    public TableDataInfo listRandom(NewWords newWords)
    {
        //startPage();
        List<NewWords> list = newWordsService.selectNewWordsRandomList(newWords);
        return getDataTable(list);
    }

    /**
     * 导出生词列表
     */
    @PreAuthorize(hasPermi = "study:newWords:export")
    @Log(title = "生词", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NewWords newWords) throws IOException
    {
        List<NewWords> list = newWordsService.selectNewWordsList(newWords);
        ExcelUtil<NewWords> util = new ExcelUtil<NewWords>(NewWords.class);
        util.exportExcel(response, list, "newWords");
    }

    /**
     * 获取生词详细信息
     */
    @PreAuthorize(hasPermi = "study:newWords:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(newWordsService.selectNewWordsById(id));
    }

    /**
     * 新增生词
     */
    @PreAuthorize(hasPermi = "study:newWords:add")
    @Log(title = "生词", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NewWords newWords)
    {
        return toAjax(newWordsService.insertNewWords(newWords));
    }

    /**
     * 修改生词
     */
    @PreAuthorize(hasPermi = "study:newWords:edit")
    @Log(title = "生词", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NewWords newWords)
    {
        return toAjax(newWordsService.updateNewWords(newWords));
    }

    /**
     * 删除生词
     */
    @PreAuthorize(hasPermi = "study:newWords:remove")
    @Log(title = "生词", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(newWordsService.deleteNewWordsByIds(ids));
    }
}
