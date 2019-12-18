package top.jianx.coolq.annotation;

import com.forte.qqrobot.anno.ByNameType;
import com.forte.qqrobot.anno.Filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@ByNameType(Filter.ByName.class)
public @interface LibraryFilter {

}
