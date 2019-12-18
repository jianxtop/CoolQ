package top.jianx.coolq.listener.msg;

import com.forte.qqrobot.anno.Filter;
import com.forte.qqrobot.anno.Listen;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.anno.depend.Depend;
import com.forte.qqrobot.beans.messages.GroupCodeAble;
import com.forte.qqrobot.beans.messages.QQCodeAble;
import com.forte.qqrobot.beans.messages.msgget.DiscussMsg;
import com.forte.qqrobot.beans.messages.msgget.GroupMsg;
import com.forte.qqrobot.beans.messages.types.MsgGetTypes;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.utils.CQCodeUtil;
import top.jianx.coolq.config.CacheConfig;
import top.jianx.coolq.service.MsgService;
import top.jianx.coolq.util.Utils;

import java.util.Map;

/**
 * 讨论组消息相关
 */
@Beans
public class MsgDisGroupListener {

    @Depend
    private MsgService msgService;
    /**
     * 讨论组内被at词库回复
     * @param discussMsg
     * @param msgSender
     * @param cqCodeUtil
     */
    @Listen( value = MsgGetTypes.discussMsg, sort = 1 )
    @Filter(value = "([\\w\\W]*)",at = true)
    public void listenAtMsg(DiscussMsg discussMsg,
                            MsgSender msgSender,
                            GroupCodeAble groupCodeAble,
                            QQCodeAble qqCodeAble,
                            CQCodeUtil cqCodeUtil ){
        try{
            String keyMsg = Utils.subStringAt(discussMsg.getMsg(), null);
            Map<String, String> cikuChche = CacheConfig.getLibrary();
            if (cikuChche == null) {

                cikuChche = msgService.getCikuChche(keyMsg);
            }
            if ("".equals(cikuChche) || cikuChche != null)
                msgSender.SENDER.sendGroupMsg(discussMsg.getGroupCode(), cikuChche.get( keyMsg ) );
        }catch (NullPointerException eNull){
            System.out.println("空指针异常");
            eNull.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
