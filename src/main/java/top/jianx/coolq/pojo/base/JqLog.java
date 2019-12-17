package top.jianx.coolq.pojo.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain=true)
public class JqLog  implements Serializable {
    private String describe;
}
