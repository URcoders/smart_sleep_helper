package com.linxu.pillow.dao;

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
}
