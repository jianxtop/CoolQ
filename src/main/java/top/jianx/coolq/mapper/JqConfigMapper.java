package top.jianx.coolq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.jianx.coolq.pojo.JqConfig;

/**
 * 系统管理
 */
public interface JqConfigMapper extends BaseMapper<JqConfig> {
    @Select("select count(*) from jq_config where qq_master = #{qq_master}")
    int findMasterQQ(@Param("qq_master") String masterQQ);
}
