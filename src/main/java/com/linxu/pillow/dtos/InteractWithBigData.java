package com.linxu.pillow.dtos;

import com.linxu.pillow.models.Report;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author linxu
 * @date 2019/4/14
 */
@Data
@Service
public class InteractWithBigData {
    private Report report;
}
