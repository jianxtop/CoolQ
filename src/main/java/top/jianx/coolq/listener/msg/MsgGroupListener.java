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
import com.forte.qqrobot.beans.messages.types.MsgGetTypes;
import com.forte.qqrobot.beans.types.KeywordMatchType;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.utils.CQCodeUtil;
import top.jianx.coolq.config.CacheConfig;
import top.jianx.coolq.service.MsgService;
import top.jianx.coolq.util.Utils;

import java.util.Map;

/**
 * 群消息相关
 */
@Beans
public class MsgGroupListener {

    @Depend
    private MsgService msgService;
    /**
     * 备用总监听方法
     * 其他监听有匹配时候，此方法不执行
     */
    @Listen( value = MsgGetTypes.groupMsg, sort = 0 )
    @Spare
    public void listen(GroupMsg groupMsg,
                       MsgSender msgSender,
                       GroupCodeAble groupCodeAble,
                       QQCodeAble qqCodeAble,
                       CQCodeUtil cqCodeUtil ){
        ///////.......///////
        msgSender.SENDER.sendGroupMsg(
                groupMsg.getGroupCode(),
                cqCodeUtil.getCQCode_At(groupMsg.getQQ()).toString()+" "+
                " 嗯,"+/*groupCodeAble+" "+qqCodeAble+" "+*/groupMsg.getQQ());
    }
    /**
     * 群内被at词库回复
     * @param groupMsg
     * @param msgSender
     * @param cqCodeUtil
     */
    @Listen( value = MsgGetTypes.groupMsg, sort = 1 )
    @Filter(value = "([\\w\\W]*)",at = true)
    public void listenAtMsg(GroupMsg groupMsg,
                       MsgSender msgSender,
                       GroupCodeAble groupCodeAble,
                       QQCodeAble qqCodeAble,
                       CQCodeUtil cqCodeUtil ){
        try{
            String keyMsg = Utils.subStringAt(groupMsg.getMsg(), null);
            Map<String, String> cikuChche = CacheConfig.getLibrary();
            if (cikuChche == null) {

                cikuChche = msgService.getCikuChche(keyMsg);
            }
            if ("".equals(cikuChche) || cikuChche != null)
                msgSender.SENDER.sendGroupMsg(groupMsg.getGroupCode(), cikuChche.get( keyMsg ) );
        }catch (NullPointerException eNull){
            System.out.println("空指针异常");
            eNull.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Listen( value = MsgGetTypes.groupMsg, sort = 2 )
    @Filter(value = "是机器", keywordMatchType = KeywordMatchType.RE_CQCODE_TRIM_CONTAINS, at = true)
    public void onMessageAt( GroupMsg groupMsg, MsgSender msgSender, CQCodeUtil cqCodeUtil ){
        msgSender.SENDER.sendGroupMsg(groupMsg.getGroupCode(), cqCodeUtil.getCQCode_At(groupMsg.getQQ()).toString()+" 我不是机器人哟");
    }

    /**
     * 签到 | 我来了 | 打卡
     * @param groupMsg
     * @param msgSender
     * @param cqCodeUtil
     */
    @Listen( value = MsgGetTypes.groupMsg, sort = 2)
    @Filter(value = "(签到)|(打卡)|(我来了)", keywordMatchType = KeywordMatchType.RE_CQCODE_TRIM_REGEX)
    public void signIn( GroupMsg groupMsg, MsgSender msgSender, CQCodeUtil cqCodeUtil ){
        msgSender.SENDER.sendGroupMsg( groupMsg.getGroupCode(),
                cqCodeUtil.getCQCode_at(groupMsg.getQQCode()).toString()+""+cqCodeUtil.getCQCode_Emoji("127774").toString() );
    }
}
