package com.linxu.pillow.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author linxu
 * @date 2019/4/14
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private Integer id;
    private String name;
    private String sex;
    private Double height;
    private Double weight;
    private String birthday;
    private String tag;
    private Double sleepScoreAvg;
    private Double sleepTimeAvg;
    private Integer deviceId;
}
