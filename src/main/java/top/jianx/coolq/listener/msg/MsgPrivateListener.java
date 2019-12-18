package top.jianx.coolq.listener.msg;

import com.forte.qqrobot.anno.Filter;
import com.forte.qqrobot.anno.Ignore;
import com.forte.qqrobot.anno.Listen;
import com.forte.qqrobot.anno.Spare;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.anno.depend.Depend;
import com.forte.qqrobot.beans.messages.GroupCodeAble;
import com.forte.qqrobot.beans.messages.QQCodeAble;
import com.forte.qqrobot.beans.messages.msgget.GroupMsg;
import com.forte.qqrobot.beans.messages.msgget.PrivateMsg;
import com.forte.qqrobot.beans.messages.types.MsgGetTypes;
import com.forte.qqrobot.beans.types.CQCodeTypes;
import com.forte.qqrobot.beans.types.KeywordMatchType;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.utils.CQCodeUtil;
import top.jianx.coolq.config.CacheConfig;
import top.jianx.coolq.service.MsgService;

import java.util.Map;

@Beans
public class MsgPrivateListener {
    @Depend
    private MsgService msgService;
    /**
     * 备用总监听方法
     * 其他监听有匹配时候，此方法不执行
     */
    @Listen( value = MsgGetTypes.privateMsg )
    @Spare
    public void allPrivateMsgListen(PrivateMsg privateMsg,
                                     MsgSender msgSender) {
        System.out.println(msgService);
        try{
            Map<String, String> cikuChche = CacheConfig.getLibrary();
            if (cikuChche == null)
                cikuChche = msgService.getCikuChche( privateMsg.getMsg().trim() );
            if ("".equals(cikuChche) || cikuChche != null)
            msgSender.SENDER.sendPrivateMsg( privateMsg.getQQCode(), cikuChche.get(privateMsg.getMsg()) );
        }catch (NullPointerException eNull){
            System.out.println("空指针异常");
            eNull.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Listen(value = MsgGetTypes.privateMsg)
    @Filter(value = "(hi)|(hello)|(你好)|(您好)", keywordMatchType = KeywordMatchType.RE_CQCODE_TRIM_REGEX)
    public void onMessage( PrivateMsg privateMsg, MsgSender msgSender ){
        msgSender.SENDER.sendPrivateMsg(privateMsg.getQQ(), privateMsg.getMsg()+"!");
    }

}
