package com.linxu.pillow.dao;

import com.linxu.pillow.models.Rate;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author linxu
 * @date 2019/4/13
 */
@Mapper
public interface RateDao {
    @Insert("insert into rate (device_id,time,heart_avg,breath_avg,env_avg,signal_t) " +
            "values (#{r.deviceId},#{r.time},#{r.heartAvg},#{r.breathAvg},#{r.envAvg},#{r.signal});")
    void saveRate(@Param("r") Rate rate);

    @Select("select * from rate where time between #{start} and #{end} " +
            "and device_id = #{id} ;")
    @Results({
            @Result(property = "deviceId", column = "device_id"),
            @Result(property = "time", column = "time"),
            @Result(property = "heartAvg", column = "heart_avg"),
            @Result(property = "breathAvg", column = "breath_avg"),
            @Result(property = "envAvg", column = "env_avg"),
            @Result(property = "signal", column = "signal_t")
    }
    )
    List<Rate> queryRateListByDeviceIdAndTime(@Param("start") String startTime, @Param("end") String endTime, @Param("id") int id);
}
