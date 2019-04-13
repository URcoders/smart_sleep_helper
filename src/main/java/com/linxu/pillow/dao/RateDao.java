package com.linxu.pillow.dao;

import com.linxu.pillow.models.Rate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author linxu
 * @date 2019/4/13
 */
@Mapper
public interface RateDao {
    @Insert("insert into rate (device_id,time,heart_avg,breath_avg,env_avg,signal_t) " +
            "values (#{r.deviceId},#{r.time},#{r.heartAvg},#{r.breathAvg},#{r.envAvg},#{r.signal});")
    void saveRate(@Param("r") Rate rate);
}
