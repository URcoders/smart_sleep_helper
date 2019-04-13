package com.linxu.pillow.models;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author linxu
 * @date 2019/4/13
 */
@Data
@Service
public class Rate {
    private String deviceId;
    private String time;
    private int signal;
    private int heartAvg;
    private int breathAvg;
    private int envAvg;
}
