package top.jianx.coolq.listener.sysmsg;

import com.forte.qqrobot.anno.Ignore;
import com.forte.qqrobot.anno.Listen;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.beans.messages.FlagAble;
import com.forte.qqrobot.beans.messages.GroupCodeAble;
import com.forte.qqrobot.beans.messages.msgget.FriendAddRequest;
import com.forte.qqrobot.beans.messages.msgget.GroupAddRequest;
import com.forte.qqrobot.beans.messages.msgget.GroupMsg;
import com.forte.qqrobot.beans.messages.result.GroupMemberList;
import com.forte.qqrobot.beans.messages.types.MsgGetTypes;
import com.forte.qqrobot.sender.MsgSender;

import java.util.List;

@Beans
public class SysAddMsgListener {
    /**
     * 添加好友 [同意][拒绝]
     * @param msgSender
     * @param friendAddRequest
     */
    @Ignore
    @Listen(MsgGetTypes.friendAdd)
    public void friendAddRequestAgree(MsgSender msgSender, FlagAble flagAble, FriendAddRequest friendAddRequest){
        System.out.println("1.添加好友 "+friendAddRequest+"\n"+"flagAble:   "+flagAble);
        msgSender.SETTER.setFriendAddRequest("1.添加好友ok", friendAddRequest.getQQ(),true);
    }

    /**
     *  添加好友请求，例如：群内请求加好友
     * @param msgSender
     * @param friendAddRequest
     */
    @Listen(MsgGetTypes.friendAddRequest)
    public void friendAddReq1( MsgSender msgSender, FriendAddRequest friendAddRequest ){
        System.out.println("2."+friendAddRequest);
//        int i=0;
//        if (i==0)
            msgSender.SETTER.setFriendAddRequest("ok", "okok", true);
//        else
//        msgSender.SETTER.setFriendAddRequestDisagree("no");
    }

    //群操作系列
    @Listen(MsgGetTypes.groupAddRequest)
    public void groupAddRequest(MsgSender msgSender, GroupAddRequest groupAddRequest ){
        System.out.println(groupAddRequest);
        msgSender.SETTER.setGroupAddRequestDisagree( groupAddRequest, "????");
    }

    @Listen(MsgGetTypes.groupMemberIncrease)
    public List getGroupMenberList(MsgSender msgSender, GroupCodeAble groupCodeAble) {
        GroupMemberList groupMemberList = msgSender.GETTER.getGroupMemberList(groupCodeAble.getGroupCode());
        System.out.println(groupMemberList.getList());
        System.out.println(groupCodeAble.getGroupCodeNumber());
        return (List) groupMemberList;
    }
    @Listen(MsgGetTypes.groupMemberReduce)
    public List getGroupMenberList2(MsgSender msgSender, GroupCodeAble groupCodeAble) {
        GroupMemberList groupMemberList = msgSender.GETTER.getGroupMemberList(groupCodeAble.getGroupCode());
        System.out.println(groupMemberList.getList());
        System.out.println(groupCodeAble.getGroupCodeNumber());
        return (List) groupMemberList;
    }
    @Listen(MsgGetTypes.unknownType)
    public void getGroupMenberBan(MsgSender msgSender, GroupMsg groupMsg) {
        msgSender.GETTER.getBanList(groupMsg.getGroupCode());
    }
}
