package top.jianx.coolq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.jianx.coolq.pojo.JqLibraryDialog;

public interface JqLibraryDialogMapper extends BaseMapper<JqLibraryDialog> {
    @Select("select value from jq_library_dialog where kkey = #{kkey}")
    String getValByKey(@Param("kkey") String kkey);
}
