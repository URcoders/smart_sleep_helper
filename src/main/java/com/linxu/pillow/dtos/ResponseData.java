package com.linxu.pillow.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.linxu.pillow.models.User;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author linxu
 * @date 2019/4/14
 */
@Data
@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData {
    private Integer code;
    private String msg;
    private WrapData data;
}
