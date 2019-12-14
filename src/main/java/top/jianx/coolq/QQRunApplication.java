package top.jianx.coolq;

import com.forte.qqrobot.component.forhttpapi.HttpApp;
import com.forte.qqrobot.component.forhttpapi.HttpApplication;
import com.forte.qqrobot.component.forhttpapi.HttpConfiguration;
import com.forte.qqrobot.depend.DependGetter;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.utils.CQCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import top.jianx.coolq.util.Util;

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
        configuration.setIp("127.0.0.1")
                .setJavaPort(15514)
                .setServerPath("/coolq")
                //酷Q端的配置
                .setServerPort(8877)
                //配置自定义的依赖获取器
                .setDependGetter(dependGetter);
    }

    @Override
    public void after(CQCodeUtil cqCodeUtil, MsgSender sender) {
//        for (int i=0;i<50;i++)
        sender.SENDER.sendPrivateMsg("1490820507", "机器人【"+ Util.getLoginQQInfo().getQQ()+"】启动成功！" +
                "\r\n作者："+ author() +
                "\r\n作者交流社区网站：" +
                "\r\nhttp://jianx.top");
    }

    @Override
    public String author() {
        return "jianx";
    }
}
