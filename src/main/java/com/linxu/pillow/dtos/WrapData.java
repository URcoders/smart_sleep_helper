package com.linxu.pillow.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.linxu.pillow.models.Rate;
import com.linxu.pillow.models.Report;
import com.linxu.pillow.models.User;
import lombok.Data;

import java.util.List;

/**
 * @author linxu
 * @date 2019/4/14
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WrapData {
    private List adviceList;
    private Report report;
    private List<Rate> rateList;
    //登录返回的用户ID
    private Integer id;
    private User user;
}
