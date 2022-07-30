package com.jeethink.study.mapper;

import java.util.List;
import com.jeethink.study.domain.Friends;

/**
 * 生词朋友表Mapper接口
 * 
 * @author jeethink
 * @date 2022-05-05
 */
public interface FriendsMapper 
{
    /**
     * 查询生词朋友表
     * 
     * @param id 生词朋友表ID
     * @return 生词朋友表
     */
    public Friends selectFriendsById(Long id);

    /**
     * 查询生词朋友表列表
     * 
     * @param friends 生词朋友表
     * @return 生词朋友表集合
     */
    public List<Friends> selectFriendsList(Friends friends);

    /**
     * 查询生词朋友表列表
     *
     * @param friends 生词朋友表
     * @return 生词朋友表集合
     */
    public List<Friends> selectFriendsListTwoWay(Friends friends);

    /**
     * 新增生词朋友表
     * 
     * @param friends 生词朋友表
     * @return 结果
     */
    public int insertFriends(Friends friends);

    /**
     * 修改生词朋友表
     * 
     * @param friends 生词朋友表
     * @return 结果
     */
    public int updateFriends(Friends friends);

    /**
     * 删除生词朋友表
     * 
     * @param id 生词朋友表ID
     * @return 结果
     */
    public int deleteFriendsById(Long id);

    /**
     * 批量删除生词朋友表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFriendsByIds(Long[] ids);
}
