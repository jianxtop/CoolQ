package top.jianx.coolq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jianx.coolq.mapper.JqConfigMapper;
import top.jianx.coolq.mapper.JqGroupAuthMapper;
import top.jianx.coolq.pojo.JqGroupAuth;
import top.jianx.coolq.service.CMService;
import top.jianx.coolq.util.Utils;

import java.sql.Struct;
import java.util.Date;

/**
 * 命令管理实现类
 * @author Jianx <jianx@jianx.top>
 * @since 2019.12.17 15:52:41
 */
@Service
public class CMServiceImpl implements CMService {
    @Autowired(required=true)
    private JqConfigMapper jqConfigMapper;
    @Autowired
    private JqGroupAuthMapper jqGroupAuthMapper;


    @Override
    public String toGrantAuth( String QQ, String groupQQ) {
        boolean isSuccess = verifyMasterQQ(QQ);
        if(!isSuccess) return "";
        String grantAuthCode = saveGrantAuth(groupQQ);
        return grantAuthCode;
    }

    /**
     *  根据群号生成群授权码
     * @param groupQQ
     */
    private String saveGrantAuth(String groupQQ) {
        //grantAuthCode [授权码] :根据群号获取
        String grantAuthCode = Utils.getGrantAuthCode( groupQQ );
        JqGroupAuth jqGroupAuth = new JqGroupAuth();
        jqGroupAuth.setGroup_no(groupQQ)
                .setGroup_auth_code(grantAuthCode)
                .setGroup_auth_time(new Date());
        int i = jqGroupAuthMapper.insert(jqGroupAuth);
        return grantAuthCode;
    }
    /**
     * 验证是不是masterQQ
     * @param masterQQ 系统管理员QQ
     * @return
     */
    public boolean verifyMasterQQ( String masterQQ ) {
        int exist = jqConfigMapper.findMasterQQ(masterQQ);
        return  exist > 0 ? true : false;
    }

}
