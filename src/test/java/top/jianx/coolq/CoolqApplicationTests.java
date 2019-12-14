package top.jianx.coolq;

import com.forte.qqrobot.component.forhttpapi.HttpApp;
import com.forte.qqrobot.component.forhttpapi.HttpConfiguration;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.utils.CQCodeUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoolqApplicationTests implements HttpApp {

    @Test
    void contextLoads() {
    }

    @Override
    public void before(HttpConfiguration configuration) {
        configuration.setLocalQQCode("1006589597")
                .setLocalQQNick("控制台")
                .setCqPath("E:\\CoolQ\\CQi");
    }

    @Override
    public void after(CQCodeUtil cqCodeUtil, MsgSender sender) {

    }

    @Override
    public String author() {
        return null;
    }
}
