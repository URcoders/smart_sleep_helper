package com.linxu.pillow.dtos;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author linxu
 * @date 2019/4/14
 */
@Data
@Service
public class ResponseData {
    private Integer code;
    private String msg;
    private WrapData data;
}
