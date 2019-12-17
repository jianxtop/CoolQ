package top.jianx.coolq.listener.privatemsg;

import com.forte.qqrobot.anno.Filter;
import com.forte.qqrobot.anno.Ignore;
import com.forte.qqrobot.anno.Listen;
import com.forte.qqrobot.anno.Spare;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.beans.messages.msgget.PrivateMsg;
import com.forte.qqrobot.beans.messages.types.MsgGetTypes;
import com.forte.qqrobot.beans.types.CQCodeTypes;
import com.forte.qqrobot.beans.types.KeywordMatchType;
import com.forte.qqrobot.sender.MsgSender;

@Beans
public class PrivateMsgListener {
    /**
     * 备用总监听方法
     * 其他监听有匹配时候，此方法不执行
     */
    @Ignore
    @Listen(MsgGetTypes.privateMsg)
    @Spare
    public void listen(PrivateMsg privateMsg, MsgSender msgSender, CQCodeTypes cqCodeTypes){
        msgSender.SENDER.sendPrivateMsg(privateMsg.getQQ(), "嗯");
    }

    @Listen(MsgGetTypes.privateMsg)
    @Filter(value = "(hi)|(hello)|(你好)|(您好)", keywordMatchType = KeywordMatchType.RE_CQCODE_TRIM_REGEX)
    public void onMessage( PrivateMsg privateMsg, MsgSender msgSender ){
        msgSender.SENDER.sendPrivateMsg(privateMsg.getQQ(), privateMsg.getMsg()+"!");
    }

}
