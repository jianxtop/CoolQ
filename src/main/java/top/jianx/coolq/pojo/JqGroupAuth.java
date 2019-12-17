package top.jianx.coolq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("jq_group_auth")
public class JqGroupAuth {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String group_no;        //'群号',
    private String group_describe;  //'群描述',
    private String group_namel;     //群名
    private String group_people_num; //'群成员数量',
    private String group_auth_code; //'授权码 需要与群号 绑定',
    private Date group_auth_time; //授权时间
}
