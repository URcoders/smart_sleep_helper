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
            @Result(property = "deviceId", column = "device_id")
    )
    int queryDeviceIdByUserId(@Param("id") int integer);

    @Insert("insert into user open_id values #{open_id} ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer userRegister(@Param("open_id") String openId);

    @Select("select id from user where open_id = #{open_id}")
    Integer isRegisterOrNot(@Param("open_id") String openId);

    @Select("select * from user where id=#{id}")
    @Results(
            {@Result(property = "name", column = "name"),
                    @Result(property = "sex", column = "sex"),
                    @Result(property = "height", column = "height"),
                    @Result(property = "birthday", column = "tag"),
                    @Result(property = "sleepScoreAvg", column = "sleep_score_avg"),
                    @Result(property = "power", column = "power"),
                    @Result(property = "sleepTimeAvg", column = "sleep_time_avg"),
                    @Result(property = "weight", column = "weight"),
                    @Result(property = "tag",column = "tag")
            }
    )
    User queryUserInfoById(@Param("id") int id);
    @Update("update user set name=#{u.name},sex=#{u.sex},height=#{u.height},weight=#{u.weight},birthday=#{u.birthday} where id =#{id}")
    void updateUserInfoById(@Param("id") int id,@Param("u")User user);

    @Update("update user set device_id=#{device_id} where id=#{id}")
    void updateDeviceStatus(@Param("id") int id,@Param("device_id")int deviceId);

}
