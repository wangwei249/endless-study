package com.jeethink.study.service.impl;

import java.util.List;
import com.jeethink.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.study.mapper.FriendsMapper;
import com.jeethink.study.domain.Friends;
import com.jeethink.study.service.IFriendsService;

/**
 * 生词朋友表Service业务层处理
 * 
 * @author jeethink
 * @date 2022-05-05
 */
@Service
public class FriendsServiceImpl implements IFriendsService 
{
    @Autowired
    private FriendsMapper friendsMapper;

    /**
     * 查询生词朋友表
     * 
     * @param id 生词朋友表ID
     * @return 生词朋友表
     */
    @Override
    public Friends selectFriendsById(Long id)
    {
        return friendsMapper.selectFriendsById(id);
    }

    /**
     * 查询生词朋友表列表
     * 
     * @param friends 生词朋友表
     * @return 生词朋友表
     */
    @Override
    public List<Friends> selectFriendsList(Friends friends)
    {
        return friendsMapper.selectFriendsList(friends);
    }

    /**
     * 查询生词朋友表列表
     *
     * @param friends 生词朋友表
     * @return 生词朋友表
     */
    @Override
    public List<Friends> selectFriendsListTwoWay(Friends friends)
    {
        return friendsMapper.selectFriendsListTwoWay(friends);
    }

    /**
     * 新增生词朋友表
     * 
     * @param friends 生词朋友表
     * @return 结果
     */
    @Override
    public int insertFriends(Friends friends)
    {
        friends.setCreateTime(DateUtils.getNowDate());
        return friendsMapper.insertFriends(friends);
    }

    /**
     * 修改生词朋友表
     * 
     * @param friends 生词朋友表
     * @return 结果
     */
    @Override
    public int updateFriends(Friends friends)
    {
        friends.setUpdateTime(DateUtils.getNowDate());
        return friendsMapper.updateFriends(friends);
    }

    /**
     * 批量删除生词朋友表
     * 
     * @param ids 需要删除的生词朋友表ID
     * @return 结果
     */
    @Override
    public int deleteFriendsByIds(Long[] ids)
    {
        return friendsMapper.deleteFriendsByIds(ids);
    }

    /**
     * 删除生词朋友表信息
     * 
     * @param id 生词朋友表ID
     * @return 结果
     */
    @Override
    public int deleteFriendsById(Long id)
    {
        return friendsMapper.deleteFriendsById(id);
    }
}
