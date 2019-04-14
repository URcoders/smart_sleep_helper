package com.linxu.pillow.models;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author linxu
 * @date 2019/4/14
 */
@Data
@Service
public class Report {
    private Date time;
    private Double envScore;
    private Double timeScore;
    private Double qualityScore;
    private Integer deepPer;
    private Integer lightPer;
    private Integer heartHighTimes;
    private Integer breathHighTimes;
    private String inSleepTime;
    private String outSleepTime;
    private String duringSleepTime;
    private String inBedTime;
    private String outBedTime;
    private String duringBedTime;
    private Integer userId;
}
