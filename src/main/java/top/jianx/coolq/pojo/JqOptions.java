package top.jianx.coolq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("jq_options")
public class JqOptions {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String key;
    private Integer type;
    private String value;
}
