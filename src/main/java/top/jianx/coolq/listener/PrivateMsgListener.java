package top.jianx.coolq.listener;

import com.forte.qqrobot.anno.Filter;
import com.forte.qqrobot.anno.Listen;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.beans.messages.msgget.PrivateMsg;
import com.forte.qqrobot.beans.messages.types.MsgGetTypes;
import com.forte.qqrobot.beans.types.KeywordMatchType;
import com.forte.qqrobot.sender.MsgSender;

@Beans
public class PrivateMsgListener {
    @Listen(MsgGetTypes.privateMsg)
    @Filter(value = "/w", keywordMatchType = KeywordMatchType.REGEX)
    public void onMessage( PrivateMsg privateMsg, MsgSender msgSender ){
        boolean b = msgSender.SENDER.sendPrivateMsg(privateMsg.getQQ(), privateMsg.getMsg());
        System.out.println(b);
    }
}
