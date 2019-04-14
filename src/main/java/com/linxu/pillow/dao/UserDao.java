package com.linxu.pillow.dao;

import com.linxu.pillow.models.User;
import org.apache.ibatis.annotations.*;

/**
 * @author linxu
 * @date 2019/4/14
 */
@Mapper
public interface UserDao {
    @Select("select device_id from user where id=#{id}")
    @Results(
            @Result(property = "deviceId",column = "device_id")
    )
    int queryDeviceIdByUserId(@Param("id") int integer);
    @Insert("insert into user open_id values #{open_id} ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer userRegister(@Param("open_id")String openId);
    @Select("select id from user where open_id = #{open_id}")
    Integer isRegisterOrNot(@Param("open_id")String openId);

}
