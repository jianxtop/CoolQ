package top.jianx.coolq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import top.jianx.coolq.pojo.base.BaseLibrary;

/**
 * 对话词库表映射类
 */
@Data
@Accessors(chain = true)
@TableName("jq_library_dialog")
public class JqLibraryDialog extends BaseLibrary {

    @TableId(type = IdType.AUTO)
    private Long id;

}
