package top.jianx.coolq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("jq_library_dialog")
public class JqLogGroup {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Integer type;
    private String manageqq;
}
