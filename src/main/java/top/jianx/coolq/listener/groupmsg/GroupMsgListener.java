package top.jianx.coolq.listener.groupmsg;

import com.forte.qqrobot.anno.Filter;
import com.forte.qqrobot.anno.Listen;
import com.forte.qqrobot.anno.Spare;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.beans.messages.GroupCodeAble;
import com.forte.qqrobot.beans.messages.QQCodeAble;
import com.forte.qqrobot.beans.messages.msgget.GroupMsg;
import com.forte.qqrobot.beans.messages.msgget.PrivateMsg;
import com.forte.qqrobot.beans.messages.types.MsgGetTypes;
import com.forte.qqrobot.beans.types.KeywordMatchType;
import com.forte.qqrobot.sender.MsgSender;

@Beans
public class GroupMsgListener {
    /**
     * 备用总监听方法
     * 其他监听有匹配时候，此方法不执行
     */
    @Listen(MsgGetTypes.groupMsg)
    @Spare
    public void listen(GroupMsg groupMsg, MsgSender msgSender, GroupCodeAble groupCodeAble, QQCodeAble qqCodeAble){
        String group=groupCodeAble.getGroupCodeNumber()+"  "+groupCodeAble.getGroupCode();
        String qq=qqCodeAble.getQQCodeNumber()+"  "+qqCodeAble.getQQCode();

        msgSender.SENDER.sendGroupMsg(
                groupMsg.getGroupCode(),
                "嗯"+" "+/*groupCodeAble+" "+qqCodeAble+" "+*/groupMsg.getQQ());
    }

    @Listen(MsgGetTypes.groupMsg)
    @Filter(value = "(hi)|(hello)|(你好)|(您好)", keywordMatchType = KeywordMatchType.RE_CQCODE_TRIM_REGEX)
    public void onMessage(GroupMsg groupMsg, MsgSender msgSender){
        msgSender.SENDER.sendGroupMsg(groupMsg.getGroupCode(), groupMsg.getMsg());
    }
}
