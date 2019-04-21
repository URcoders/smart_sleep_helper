package com.linxu.pillow.dtos;

import com.linxu.pillow.models.User;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author linxu
 * @date 2019/4/21
 */
@Data
@Service
public class RequestData {
    private Integer id;
    private User user;
    private Integer deviceId;
}
