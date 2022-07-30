package com.jeethink.study.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.core.annotation.Excel;
import com.jeethink.common.core.web.domain.BaseEntity;

/**
 * 生词朋友表对象 friends
 * 
 * @author jeethink
 * @date 2022-05-05
 */
public class Friends extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 朋友ID */
    @Excel(name = "朋友ID")
    private Long friendId;

    /** N:申请状态，S:生效，F：拒绝 */
    @Excel(name = "N:申请状态，S:生效，F：拒绝")
    private String status;

    /** 申请加好友时的留言 */
    @Excel(name = "申请加好友时的留言")
    private String reqMsg;

    /** 接受或拒绝时的留言 */
    @Excel(name = "接受或拒绝时的留言")
    private String replyMsg;

    //自己
    private String userName;

    private String nickName;

    private String avatar;

    //要加的好友
    private String fuserName;

    private String fnickName;

    private String favatar;




    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setFriendId(Long friendId) 
    {
        this.friendId = friendId;
    }

    public Long getFriendId() 
    {
        return friendId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setReqMsg(String reqMsg) 
    {
        this.reqMsg = reqMsg;
    }

    public String getReqMsg() 
    {
        return reqMsg;
    }
    public void setReplyMsg(String replyMsg) 
    {
        this.replyMsg = replyMsg;
    }

    public String getReplyMsg() 
    {
        return replyMsg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFuserName() {
        return fuserName;
    }

    public void setFuserName(String fuserName) {
        this.fuserName = fuserName;
    }

    public String getFnickName() {
        return fnickName;
    }

    public void setFnickName(String fnickName) {
        this.fnickName = fnickName;
    }

    public String getFavatar() {
        return favatar;
    }

    public void setFavatar(String favatar) {
        this.favatar = favatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("friendId", getFriendId())
            .append("status", getStatus())
            .append("reqMsg", getReqMsg())
            .append("replyMsg", getReplyMsg())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }


}
