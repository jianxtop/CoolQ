package top.jianx.coolq.listener.manage;

import com.forte.qqrobot.anno.Filter;
import com.forte.qqrobot.anno.Listen;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.anno.depend.Depend;
import com.forte.qqrobot.beans.messages.msgget.PrivateMsg;
import com.forte.qqrobot.beans.messages.types.MsgGetTypes;
import com.forte.qqrobot.beans.types.KeywordMatchType;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.utils.CQCodeUtil;
import top.jianx.coolq.service.CMService;
import top.jianx.coolq.util.Utils;
import java.util.Map;

/**
 * 命令消息管理监听类
 */
@Beans
public class CommandManagement {
    @Depend
    private CMService cmService;
    /**
     * 授权群使用权限
     *  私聊方式授权
     *  命令格式：#授权+群号
     */
    @Listen( value = MsgGetTypes.privateMsg, sort = 5 )
    @Filter( value = "#授权",keywordMatchType = KeywordMatchType.RE_CQCODE_TRIM_CONTAINS )
    public void toGrantAuthorization(PrivateMsg privateMsg, MsgSender msgSender, CQCodeUtil cqCodeUtil){
        System.out.println( "授权操作QQ："+privateMsg.getQQ() );
        //处理命令
        Map<String, String> commandMap = Utils.parseCommand(privateMsg.getMsg(), 2);
        try{
            //授权处理
            String grantAuthCode = cmService.toGrantAuth( privateMsg.getQQ(), commandMap.get( "群号" ) );
            cqCodeUtil.getCQCode_At("70687547");
            msgSender.SENDER.sendPrivateMsg( privateMsg.getQQ(), "授权成功,授权码如下：\r\n"+grantAuthCode );
            msgSender.SENDER.sendGroupMsg( commandMap.get( "群号" ),"大家好，我来当管理员了哟" );
        }catch (Exception e){
            msgSender.SENDER.sendPrivateMsg( privateMsg.getQQ(), "授权失败" );
        }
    }

}
