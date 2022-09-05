package com.cpb.service;

import com.cpb.utils.Utils;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.dnspod.v20210323.DnspodClient;
import com.tencentcloudapi.dnspod.v20210323.models.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务类实现类
 *
 * @author LuoYemao
 * @since 2022/9/5 9:17
 */
@Slf4j
public class ReqServiceImpl implements ReqService {

    @Override
    public List<Long> GetRecordList(DnspodClient dnsPodClient, String domain, String logLevel) {
        DescribeRecordListRequest req = new DescribeRecordListRequest();
        req.setDomain(domain);
        try {
            DescribeRecordListResponse resp = dnsPodClient.DescribeRecordList(req);
            RecordListItem[] recordList = resp.getRecordList();
            List<Long> recordListID = new ArrayList<>();
            for (RecordListItem recordListItem : recordList) {
                recordListID.add(recordListItem.getRecordId());
            }
            //前两个记录是不需要删除的
            recordListID.remove(0);
            recordListID.remove(0);
            if (logLevel.equals("info")) log.info("获取记录成功：" + resp.getRequestId() + "::" + recordListID);
            return recordListID;
        } catch (TencentCloudSDKException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean DeleteRecord(DnspodClient dnsPodClient, String domain, String logLevel) {
        List<Long> deleteIdList = GetRecordList(dnsPodClient, domain, logLevel);
        if (deleteIdList.size() == 0) {
            if (logLevel.equals("info")) log.info("无待删除记录");
            return true;
        }
        for (Long x : deleteIdList) {
            try {
                DeleteRecordRequest req = new DeleteRecordRequest();
                req.setDomain(domain);
                req.setRecordId(x);
                DeleteRecordResponse resp = dnsPodClient.DeleteRecord(req);
                if (logLevel.equals("info")) log.info("删除单条记录成功：" + resp.getRequestId());
                return true;
            } catch (TencentCloudSDKException e) {
                log.error(e.getMessage());
                return false;
            }
        }
        if (logLevel.equals("info")) log.info("删除全部记录成功：" + deleteIdList.size());
        return true;
    }

    @Override
    public Boolean CreateRecord(DnspodClient dnsPodClient, String domain, String logLevel, List<String> subDomain) {
        for (String s : subDomain) {
            try {
                CreateRecordRequest req = new CreateRecordRequest();
                req.setDomain(domain);
                req.setRecordType("A");
                req.setRecordLine("默认");
                req.setValue(Utils.getIpAddress("INFO"));
                req.setSubDomain(s);
                CreateRecordResponse resp = dnsPodClient.CreateRecord(req);
                if (logLevel.equals("info"))
                    log.info("添加单条记录成功：" + resp.getRequestId() + "::" + subDomain + "::" + domain + req.getValue());
            } catch (TencentCloudSDKException e) {
                log.error(e.getMessage());
                return false;
            }
        }
        if (logLevel.equals("info")) log.info("添加全部记录成功：" + subDomain.size());
        return true;
    }
}
