package com.linxu.pillow.service.impl;

import com.google.gson.JsonSyntaxException;
import com.linxu.pillow.dao.RateDao;
import com.linxu.pillow.dtos.EmbeddedData;
import com.linxu.pillow.models.Rate;
import com.linxu.pillow.service.EmbeddedService;
import com.linxu.pillow.utils.EmptyUtil;
import com.linxu.pillow.utils.ResolveUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linxu
 * @date 2019/4/13
 */
@Service
@Slf4j
public class EmbeddedServiceImplV1<T> implements EmbeddedService<T> {
    @Autowired
    private RateDao rateDao;
    @Override
    public boolean resolve(T data) {
        if (EmptyUtil.isEmpty(data)) {
            return false;
        }
        //resolve string
        if (data instanceof String) {
            EmbeddedData embeddedData;
            //
            try {
                embeddedData = ResolveUtil.gsonWoker.fromJson((String) data, EmbeddedData.class);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            //如果数据存储失败
            if (!saveEmbeddedData(embeddedData.getRateList())) {
                log.error("数据存储失败,数据:{}",data);
            }
            return true;
        }
        //not support another data type ,so return false;
        return false;

    }
    private boolean saveEmbeddedData(List<Rate> data) {
        try {
            for (Rate rate : data) {
                rateDao.saveRate(rate);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        //default;
        return true;
    }
}
