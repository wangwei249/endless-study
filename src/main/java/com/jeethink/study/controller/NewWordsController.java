package com.jeethink.study.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.jeethink.study.domain.Friends;
import com.jeethink.study.domain.NewWordsSetting;
import com.jeethink.study.domain.assist.*;
import org.springframework.beans.BeanUtils;
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
import java.util.Calendar;
import com.jeethink.study.service.INewWordsSettingService;

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

    @Autowired
    private INewWordsSettingService newWordsSettingService;


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
     * 查询生词汇总信息
     */
    //@PreAuthorize(hasPermi = "study:newWords:list")
    @GetMapping("/selectNewWordsCollect/{userId}")
    public NewWordsCollect selectNewWordsCollect(@PathVariable("userId") Long userId)
    {
        //startPage();
        NewWordsCollect newWordsCollect = newWordsService.selectNewWordsCollect(Long.valueOf(userId));
        return  newWordsCollect;
    }

    /**
     * 查询线性图表信息【查询月份目标设定的目标值，完成值，通过值】
     */
    //@PreAuthorize(hasPermi = "study:newWords:list")
    @GetMapping("/selectExpectActual/{userId}")
    public TableDataInfo selectExpectActual(@PathVariable("userId") Long userId)
    {
        //startPage();
        List<NewWordsCollect> list = newWordsService.selectExpectActual(Long.valueOf(userId));
        return getDataTable(list);
    }

    /**
     * 查询应战数据图表【应战数，成功数，失败数】
     */
    //@PreAuthorize(hasPermi = "study:newWords:list")
    @GetMapping("/selectChallengeCollect/{userId}/{type}")
    public TableDataInfo selectChallengeCollect(@PathVariable("userId") Long userId,@PathVariable("type") String type)
    {
        //startPage();
        List<NewWordsCollect> list = newWordsService.selectChallengeCollect(Long.valueOf(userId),type);
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
     * 批量修改生词
     */
    @PreAuthorize(hasPermi = "study:newWords:edit")
    @Log(title = "生词", businessType = BusinessType.UPDATE)
    @PostMapping("/editBatch")
    public AjaxResult editBatch(@RequestBody List<NewWords> newWords)
    {
        int cot = 0;
        for(NewWords word:newWords){
            cot = newWordsService.updateNewWords(word);
        }
        return toAjax(cot);
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

    /**
     * 新增生词挑战
     */
    @PreAuthorize(hasPermi = "study:newWords:add")
    @Log(title = "生词挑战", businessType = BusinessType.INSERT)
    @PostMapping("/addChallenge")
    public AjaxResult addChallenge(@RequestBody NewWordsChallenge newWordsChallenge)
    {
        List<Friends> fsList = newWordsChallenge.getChallengeUserList();
        System.out.println("获取到的应战者id长度:"+fsList.size());
        int count = 0;
        for(int i=0;i<fsList.size();i++){
            NewWords newWords = new NewWords();
            BeanUtils.copyProperties(newWordsChallenge,newWords);
            newWords.setChallengeId(fsList.get(i).getFriendId());
            newWords.setChallengeStatus("E");
            count += newWordsService.insertNewWords(newWords);
        }
        System.out.println("成功插入："+count+"条挑战记录");
        return toAjax(count);
    }

    /**
     * 查询好友动态
     */
    //@PreAuthorize(hasPermi = "study:newWords:list")
    @GetMapping("/selectFriendsDyn/{userId}")
    public TableDataInfo selectFriendsDyn(@PathVariable("userId") Long userId)
    {
        //startPage();
        List<FriendsDyn> list = newWordsService.selectFriendsDyn(Long.valueOf(userId));
        return getDataTable(list);
    }


    /**
     * 查询热词列表
     */
    //@PreAuthorize(hasPermi = "study:newWords:list")
    @GetMapping("/listHots/{count}")
    public TableDataInfo listHots(@PathVariable("count") Integer count)
    {
        //startPage();
        List<HotWord> list = newWordsService.listHots(count);
        return getDataTable(list);
    }

    /**
     * 创建新用户生词系统相关的默认数据
     */
    //@PreAuthorize(hasPermi = "study:newWords:list")
    @GetMapping("/addUserDefaultSetting/{userId}")
    public AjaxResult addUserDefaultSetting(@PathVariable("userId") String userId)
    {
        //startPage();
        //List<HotWord> list = newWordsService.listHots(count);

        //插入生词间隔
        List<NewWordsSetting> newWordsSettingList = new ArrayList<NewWordsSetting>();
        NewWordsSetting word1 = new NewWordsSetting();
        word1.setUserId(Long.valueOf(userId));
        word1.setSettingType("memory_method");
        word1.setSettingName("1");
        word1.setSettingValue("0");
        word1.setCreateBy("admin");
        word1.setUpdateBy("admin");
        word1.setStatus("T");
        NewWordsSetting word2 = new NewWordsSetting();
        BeanUtils.copyProperties(word1,word2);
        word1.setSettingName("2");
        word1.setSettingValue("24");
        NewWordsSetting word3= new NewWordsSetting();
        BeanUtils.copyProperties(word1,word3);
        word3.setSettingName("3");
        word3.setSettingValue("72");
        NewWordsSetting word4= new NewWordsSetting();
        BeanUtils.copyProperties(word1,word4);
        word4.setSettingName("4");
        word4.setSettingValue("72");
        NewWordsSetting word5= new NewWordsSetting();
        BeanUtils.copyProperties(word1,word5);
        word5.setSettingName("4");
        word5.setSettingValue("168");
        newWordsSettingList.add(word1);
        newWordsSettingList.add(word2);
        newWordsSettingList.add(word3);
        newWordsSettingList.add(word4);
        newWordsSettingList.add(word5);

        //生词目标设置默认数据
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);  // 当前年
        int month = cal.get(Calendar.MONTH) + 1;  // 当前月
        String nextYearMonth = "";
        for(int i=0;i<=5;i++){
            if(month < 10){
                nextYearMonth = year+ "-0" + month;
            }else{
                if(month == 12){
                    nextYearMonth = (year+1) + "-01";
                }else{
                    nextYearMonth = year+ "-"+ month;
                }
            }
            month++;

            NewWordsSetting target = new NewWordsSetting();
            target.setUserId(Long.valueOf(userId));
            target.setSettingType("collect_target");
            target.setSettingName(nextYearMonth);
            target.setSettingValue("100");
            target.setSettingValueTwo("50");
            target.setSettingValueThree("0.8");
            target.setCreateBy("admin");
            target.setUpdateBy("admin");
            newWordsSettingList.add(target);
        }

        int successCount = newWordsSettingService.editBatch(newWordsSettingList);


        return toAjax(successCount);
    }


    /**
     * 查询生词统计排行榜
     */
    //@PreAuthorize(hasPermi = "study:newWords:list")
    @GetMapping("/selectRank/{status}")
    public TableDataInfo selectRank(@PathVariable("status") String status)
    {
        //startPage();
        List<NewWordsRank> list = newWordsService.selectRank(status);
        return getDataTable(list);
    }
}
