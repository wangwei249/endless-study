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
import com.jeethink.study.domain.Pos;
import com.jeethink.study.service.IPosService;
import com.jeethink.common.core.web.controller.BaseController;
import com.jeethink.common.core.web.domain.AjaxResult;
import com.jeethink.common.core.utils.poi.ExcelUtil;
import com.jeethink.common.core.web.page.TableDataInfo;

/**
 * 英语单词-词性Controller
 * 
 * @author jeethink
 * @date 2022-04-07
 */
@RestController
@RequestMapping("/englishPos")
public class PosController extends BaseController
{
    @Autowired
    private IPosService posService;

    /**
     * 查询英语单词-词性列表
     */
    @PreAuthorize(hasPermi = "study:englishPos:list")
    @GetMapping("/list")
    public TableDataInfo list(Pos pos)
    {
        startPage();
        List<Pos> list = posService.selectPosList(pos);
        return getDataTable(list);
    }

    /**
     * 导出英语单词-词性列表
     */
    @PreAuthorize(hasPermi = "study:englishPos:export")
    @Log(title = "英语单词-词性", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Pos pos) throws IOException
    {
        List<Pos> list = posService.selectPosList(pos);
        ExcelUtil<Pos> util = new ExcelUtil<Pos>(Pos.class);
        util.exportExcel(response, list, "englishPos");
    }

    /**
     * 获取英语单词-词性详细信息
     */
    @PreAuthorize(hasPermi = "study:englishPos:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(posService.selectPosById(id));
    }

    /**
     * 新增英语单词-词性
     */
    @PreAuthorize(hasPermi = "study:englishPos:add")
    @Log(title = "英语单词-词性", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Pos pos)
    {
        return toAjax(posService.insertPos(pos));
    }

    /**
     * 修改英语单词-词性
     */
    @PreAuthorize(hasPermi = "study:englishPos:edit")
    @Log(title = "英语单词-词性", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Pos pos)
    {
        return toAjax(posService.updatePos(pos));
    }

    /**
     * 删除英语单词-词性
     */
    @PreAuthorize(hasPermi = "study:englishPos:remove")
    @Log(title = "英语单词-词性", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(posService.deletePosByIds(ids));
    }
}
