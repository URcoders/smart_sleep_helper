package com.linxu.pillow.dtos;

import com.linxu.pillow.models.Rate;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linxu
 * @date 2019/4/13
 * 接收嵌入式数据
 */
@Data
@Service
public class EmbeddedData {
    private int blueteeth;
    private int wifi;
    private List<Rate> rateList;
}
