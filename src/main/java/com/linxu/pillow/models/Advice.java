package com.linxu.pillow.models;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author linxu
 * @date 2019/4/21
 */
@Data
@Service
public class Advice {
    private String name;
    private String note;
    private String img;
}
