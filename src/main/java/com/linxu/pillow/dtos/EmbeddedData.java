package com.linxu.pillow.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmbeddedData {
    private Integer blueteeth;
    private Integer wifi;
    private List<Rate> rateList;
}
