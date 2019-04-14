package com.linxu.pillow.dao;

import com.linxu.pillow.models.Report;
import org.apache.ibatis.annotations.*;


/**
 * @author linxu
 * @date 2019/4/14
 */
@Mapper
public interface ReportDao {
    @Insert("insert into report (time,env_score,time_score,quality_score,light_per,deep_per,heart_high_times,breath_high_times,in_sleep_time" +
            "out_sleep_time,dur_sleep_time,in_bed_time,out_bed_time,dur_bed_time,user_id)" +
            "values (#{r.time},#{r.envScore},#{r.timeScore},#{r.qualityScore},#{r.lightPer},#{r.deepPer}," +
            "#{r.heartHighTimes},#{r.breathHighTimes},#{r.inSleepTime},#{r.outSleepTime},#{r.duringSleepTime},#{r.inBedTime},#{r.outBedTime},#{r.duringBedTime},#{r.userId})")
    void saveReport(@Param("r") Report report);

    @Select("select * from report where time = #{time} and id = #{id};")
    @Results(
            {
                    @Result(property = "time", column = "time"),
                    @Result(property = "envScore", column = "env_score"),
                    @Result(property = "timeScore", column = "time_score"),
                    @Result(property = "qualityScore", column = "quality_score"),
                    @Result(property = "lightPer", column = "light_per"),
                    @Result(property = "deepPer", column = "deep_per"),
                    @Result(property = "heartHighTimes", column = "heart_high_times"),
                    @Result(property = "breathHighTimes", column = "breath_high_times"),
                    @Result(property = "inSleepTime", column = "in_sleep_time"),
                    @Result(property = "outSleepTime", column = "out_sleep_time"),
                    @Result(property = "duringSleepTime", column = "dur_sleep_time"),
                    @Result(property = "inBedTime", column = "in_bed_time"),
                    @Result(property = "outBedTime", column = "out_bed_time"),
                    @Result(property = "duringBedTime", column = "dur_bed_time"),
                    @Result(property = "userId",column = "user_id")
            }
    )
    Report queryReportByTimeAndUserId(@Param("time") String time, @Param("id") int userId);
}
