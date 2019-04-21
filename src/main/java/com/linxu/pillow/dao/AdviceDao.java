package com.linxu.pillow.dao;

import com.linxu.pillow.models.Advice;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author linxu
 * @date 2019/4/14
 */
@Mapper
public interface AdviceDao {
    @Select("select * from user_advice where user_id=#{id}")
    List<Integer> queryAdviceIdsByUserId(@Param("id") int id);
    @Select("select * from advice where id = #{id}")
    Advice queryAdviceByAdviceId(@Param("id") int id);
}
