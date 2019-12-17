package top.jianx.coolq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.jianx.coolq.pojo.JqGroupAuth;

import java.util.Date;

public interface JqGroupAuthMapper  extends BaseMapper<JqGroupAuth> {
    void saveGrantAuth(String groupQQ, String grantAuthCode, Date date);
}
