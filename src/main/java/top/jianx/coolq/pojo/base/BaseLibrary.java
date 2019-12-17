package top.jianx.coolq.pojo.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 词库配置父类
 * @author Jianx <jianx@jian.top>
 * @since 1.0
 */
@Data
@Accessors(chain=true)
public class BaseLibrary  implements Serializable {
    private String key;
    private String value;
    private String describe;
}
