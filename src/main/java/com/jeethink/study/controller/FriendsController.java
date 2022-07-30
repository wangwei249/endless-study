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
import com.jeethink.study.domain.Friends;
import com.jeethink.study.service.IFriendsService;
import com.jeethink.common.core.web.controller.BaseController;
import com.jeethink.common.core.web.domain.AjaxResult;
import com.jeethink.common.core.utils.poi.ExcelUtil;
import com.jeethink.common.core.web.page.TableDataInfo;

/**
 * 生词朋友表Controller
 * 
 * @author jeethink
 * @date 2022-05-05
 */
@RestController
@RequestMapping("/friends")
public class FriendsController extends BaseController
{
    @Autowired
    private IFriendsService friendsService;

    /**
     * 查询生词朋友表列表
     */
    @PreAuthorize(hasPermi = "study:friends:list")
    @GetMapping("/list")
    public TableDataInfo list(Friends friends)
    {
        startPage();
        List<Friends> list = friendsService.selectFriendsList(friends);
        return getDataTable(list);
    }

    /**
     * 查询生词朋友表列表
     */
//    @PreAuthorize(hasPermi = "study:friends:list")
    @GetMapping("/listTwoWay")
    public TableDataInfo listTwoWay(Friends friends)
    {
        startPage();
        List<Friends> list = friendsService.selectFriendsListTwoWay(friends);
        return getDataTable(list);
    }

    /**
     * 导出生词朋友表列表
     */
    @PreAuthorize(hasPermi = "study:friends:export")
    @Log(title = "生词朋友表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Friends friends) throws IOException
    {
        List<Friends> list = friendsService.selectFriendsList(friends);
        ExcelUtil<Friends> util = new ExcelUtil<Friends>(Friends.class);
        util.exportExcel(response, list, "friends");
    }

    /**
     * 获取生词朋友表详细信息
     */
    @PreAuthorize(hasPermi = "study:friends:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(friendsService.selectFriendsById(id));
    }

    /**
     * 新增生词朋友表
     */
    @PreAuthorize(hasPermi = "study:friends:add")
    @Log(title = "生词朋友表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Friends friends)
    {
        return toAjax(friendsService.insertFriends(friends));
    }

    /**
     * 修改生词朋友表
     */
    @PreAuthorize(hasPermi = "study:friends:edit")
    @Log(title = "生词朋友表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Friends friends)
    {
        return toAjax(friendsService.updateFriends(friends));
    }

    /**
     * 删除生词朋友表
     */
    @PreAuthorize(hasPermi = "study:friends:remove")
    @Log(title = "生词朋友表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(friendsService.deleteFriendsByIds(ids));
    }
}
