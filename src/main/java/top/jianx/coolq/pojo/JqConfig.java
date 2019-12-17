package top.jianx.coolq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@TableName("jq_group_auth")
public class JqConfig implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String qq_robot;    //'机器人QQ',
    private String qq_master;   //'主人QQ',
    private String qq_master_describe;
    private String qq_mother;   //'机器人的mother',
    private String qq_mother_describe;
    private String qq_father;   //'机器人的father',
    private String qq_father_describe;
    private String qq_ip;       //'服务器ip',
    private String qq_javaport;     //'服务器端口配置，监听酷Q消息',
    private String qq_serverport;   //'酷Q端的配置,发送到酷Q的端口',
    private String qq_serverpath;   //请求监听路径 http://localhost:port(/coolq)
}
