package top.jianx.coolq.util;

import com.forte.qqrobot.beans.messages.result.LoginQQInfo;
import com.forte.qqrobot.component.forhttpapi.http.HttpSender;

import java.time.LocalDateTime;

public class Util {
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
}
