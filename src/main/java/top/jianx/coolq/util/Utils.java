package top.jianx.coolq.util;

import com.forte.qqrobot.beans.messages.result.LoginQQInfo;
import com.forte.qqrobot.component.forhttpapi.http.HttpSender;
import com.forte.utils.basis.MD5Utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Utils {
    /**
     *  获取酷Q登录的QQ号信息
     * @return
     */
    public static LoginQQInfo getLoginQQInfo(){
        LoginQQInfo loginQQInfo = HttpSender.build().getLoginQQInfo();
        return loginQQInfo;
    }

    /**
     * LocalDateTime时间处理
     *      LocalDateTime.now()
     *      "2019-12-14T18:12:50.001"
     */
    public static String formatLocalDateTime(String localDateTimeString) {
        String[] ts = localDateTimeString.split("T");
        if (ts[1].contains("."))
            return ts[0] + "  "+ ts[1].substring(0, ts[1].lastIndexOf("."));
        return ts[0] + "  " + ts[1];
    }

    /**
     *  群授权命令解析
     * @param cmGroupnum 命令+群号码
     * @param cmLenth 命令字数
     * @return  "命令" + 群号
     */
    public static Map<String, String> parseCommand(String cmGroupnum, int cmLenth) {
        HashMap<String, String> map = new HashMap<>();
        String command = cmGroupnum.substring( 1, cmLenth+1 );
        String groupNum = cmGroupnum.substring( cmLenth+1, cmGroupnum.length() );
        map.put( "命令", command );
        map.put( "群号", groupNum );
        return map;
    }

    //根据[群号]和[时间戳]\[盐值]生成群授权码:取出前十
    public static String getGrantAuthCode(String groupQQ){
//        UUID.randomUUID().toString()
//                .replace( "-", "" )
//                .substring( 0,8 );
        return MD5Utils.toMD5(groupQQ + getCurrentTimeMillis() + getSalt()).substring(0, 15);
    }

    /**
     * 将时间戳转换为[时分秒]格式
     * @param currentTimeMillis
     * @return  HH:mm:ss
     */
    private static String currentTimeMillisToTime(Long currentTimeMillis){
        Long ll = currentTimeMillis/1000;
        return (ll/60/60%24+8)+":"+ll/60%60+":"+ll%60;
    }

    /**
     * 获取时间戳
     * @return [long]
     */
    private static long getCurrentTimeMillis(){
        return System.currentTimeMillis();
    }

    /**
     * 取盐值
     * @return
     */
    private static String getSalt(){
        return "70687547";
    }

    /**
     * 生成uuid
     * @return
     */
    public String getUUID(){
        return UUID.randomUUID().toString().replace( "-", "" );
    }

    /**
     * 截取消息中的at串
     * @param strMsg
     * @return
     */
    public static String subStringAt(String strMsg, String qqNum){
        //[CQ:at,qq=1006589597] 简兮
        return strMsg.substring(strMsg.indexOf("]")+1,strMsg.length()).trim();
    }

    public static void main(String[] args) {
        String s = MD5Utils.toMD5( "123456" );
        System.out.println(s);
        Date date = new Date();
        System.out.println(date);
    }
}
