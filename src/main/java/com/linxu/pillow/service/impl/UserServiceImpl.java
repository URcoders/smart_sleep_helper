package com.linxu.pillow.service.impl;

import com.linxu.pillow.dao.RateDao;
import com.linxu.pillow.dao.ReportDao;
import com.linxu.pillow.dao.UserDao;
import com.linxu.pillow.dtos.EmbeddedData;
import com.linxu.pillow.dtos.ResponseData;
import com.linxu.pillow.dtos.WrapData;
import com.linxu.pillow.enums.MsgStatus;
import com.linxu.pillow.models.Rate;
import com.linxu.pillow.models.Report;
import com.linxu.pillow.models.WxAuthMsg;
import com.linxu.pillow.service.UserService;
import com.linxu.pillow.utils.DateUtil;
import com.linxu.pillow.utils.EmptyUtil;
import com.linxu.pillow.utils.RequestUtil;
import com.linxu.pillow.utils.ResolveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linxu
 * @date 2019/4/14
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RateDao rateDao;
    @Autowired
    private ReportDao reportDao;
    @Autowired
    private UserDao userDao;

    @Override
    public ResponseData querySleepReport(String date, int id) {
        if (EmptyUtil.isEmpty(date)) {
            System.err.println("date null");
            return null;
        }
        ResponseData responseData = new ResponseData();
        WrapData wrapData = new WrapData();
        //query database
        List<Rate> rateList = rateDao.queryRateListByDeviceIdAndTime(date, DateUtil.addDay(date), userDao.queryDeviceIdByUserId(id));
        //set embedded data
        EmbeddedData embeddedData = new EmbeddedData();
        embeddedData.setRateList(rateList);
        //do first query from database
        Report report = reportDao.queryReportByTimeAndUserId(date, id);
        if (EmptyUtil.isEmpty(report)) {
            //如果no db
            report = ResolveUtil.gsonWoker.fromJson(RequestUtil.requestSleepReport(embeddedData), Report.class);
            try {
                report.setUserId(id);
            } catch (NullPointerException e) {
                System.err.println("query data from big data happen error!");
                responseData.setMsg(MsgStatus.ERROR.getMsg());
            }
            //执行保存
            reportDao.saveReport(report);
        }
        wrapData.setRateList(rateList);
        wrapData.setReport(report);
        responseData.setCode(0);
        responseData.setMsg(MsgStatus.SUCCESS.getMsg());
        responseData.setData(wrapData);
        return responseData;
    }

    @Override
    public ResponseData queryAdvice(int id) {
        return null;
    }

    @Override
    public ResponseData login(String code) {
        if (EmptyUtil.isEmpty(code)) {
            System.err.println("code null");
            return null;
        }
        ResponseData responseData = new ResponseData();
        WrapData wrapData = new WrapData();
        WxAuthMsg wxAuthMsg = ResolveUtil.gsonWoker.fromJson(RequestUtil.code2Session(code), WxAuthMsg.class);
        Integer userId;
        if (EmptyUtil.isEmpty(wxAuthMsg) || EmptyUtil.isEmpty(wxAuthMsg.getOpenid())) {
            responseData.setCode(-1);
            responseData.setMsg(MsgStatus.ERROR.getMsg());
        } else if ((userId = userDao.isRegisterOrNot(wxAuthMsg.getOpenid())) != 0) {
            //已经注册
            wrapData.setId(userId);
            responseData.setMsg(MsgStatus.SUCCESS.getMsg());
            responseData.setCode(0);
            responseData.setData(wrapData);

        } else {
            //未注册
            userId = userDao.userRegister(wxAuthMsg.getOpenid());
            wrapData.setId(userId);
            responseData.setMsg(MsgStatus.SUCCESS.getMsg());
            responseData.setCode(0);
            responseData.setData(wrapData);
        }
        return responseData;
    }
}
