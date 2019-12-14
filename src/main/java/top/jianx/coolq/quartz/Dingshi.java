package top.jianx.coolq.quartz;

import com.forte.qqrobot.anno.timetask.CronTask;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.timetask.BaseTimeJob;
import com.forte.qqrobot.utils.CQCodeUtil;
import top.jianx.coolq.util.Util;

import java.time.LocalDateTime;

@CronTask("0 * * * * ? *")
public class Dingshi  extends BaseTimeJob {
        @Override
        public void execute(MsgSender msgSender, CQCodeUtil cqCodeUtil) {
            msgSender.SENDER.sendPrivateMsg(
                    Util.getLoginQQInfo().getQQ(),
                    Util.formatLocalDateTime(LocalDateTime.now().toString()));
        }
}
