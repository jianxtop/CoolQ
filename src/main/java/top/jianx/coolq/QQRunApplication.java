package top.jianx.coolq;

import com.forte.qqrobot.anno.Ignore;
import com.forte.qqrobot.component.forhttpapi.HttpApp;
import com.forte.qqrobot.component.forhttpapi.HttpApplication;
import com.forte.qqrobot.component.forhttpapi.HttpConfiguration;
import com.forte.qqrobot.depend.DependGetter;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.utils.CQCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import top.jianx.coolq.util.Utils;

import java.time.LocalDateTime;

/**
 * 这个是simple-robot框架的启动器类
 * 使用HTTP API组件进行示例, 实现{@link HttpApp}接口并进行相应的配置
 * 由于需要整合Spring的依赖管理系统，所以需要Spring的依赖工厂来自定义依赖获取方式
 * 所以自定义依赖获取由构造方法进行提供
 *
 * @author jianx <[email]jianx@jianx.top>
 * @since JDK1.8
 **/
public class QQRunApplication implements HttpApp {
    /**
     * 通过Spring注入robot启动器
     */
    @Autowired
    private HttpApplication httpApplication;
    /**
     * 自定义的依赖获取器
     */
    private DependGetter dependGetter;

    /**
     * 构造，需要提供一个自定义的依赖获取器
     */
    public QQRunApplication(DependGetter dependGetter) {
        this.dependGetter = dependGetter;
    }

    @Override
    public void before(HttpConfiguration configuration) {
        configuration
            //设置本地请求路径
            .setIp("127.0.0.1")
            //映射消息端口15514
            .setJavaPort(15551)
            //httpapi插件配置的模拟请求路径/coolq
            .setServerPath("/jq")
            //酷Q端的配置8877
            .setServerPort(7788)
            //配置自定义的依赖获取器
            .setDependGetter(dependGetter);
    }
@Ignore
    @Override
    public void after(CQCodeUtil cqCodeUtil, MsgSender sender) {
//        for (int i=0;i<50;i++)
//        sender.SENDER.sendPrivateMsg("1490820507", "机器人【"+ Utils.getLoginQQInfo().getQQ()+"】启动成功！" +
//                "\r\n作者："+ author() +
//                "\r\n作者交流社区网站：" +
//                "\r\nhttp://jianx.top");
        sender.SENDER.sendGroupMsg(
                "993722908",
                "启动成功！" +
                "\r\n时间："+Utils.formatLocalDateTime(LocalDateTime.now().toString())+
                "\r\n机器人: "+ Utils.getLoginQQInfo().getName()+"【"+Utils.getLoginQQInfo().getQQ()+"】" +
                "\r\n作者："+ author() +
                "\r\n作者交流社区网站：" +
                "\r\n"+site());
    }

    @Override
    public String author() {
        return "jianx <jianx@jianx.top>";
    }

    public String site(){
        return "http://jianx.top";
    }
}
