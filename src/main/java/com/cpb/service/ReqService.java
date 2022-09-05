package com.cpb.service;

import com.tencentcloudapi.dnspod.v20210323.DnspodClient;

import java.util.List;

/**
 * 业务类封装请求方法
 *
 * @author LuoYemao
 * @since 2022/9/5 9:17
 */
public interface ReqService {

    List<Long> GetRecordList(DnspodClient dnsPodClient, String domain, String logLevel);

    Boolean DeleteRecord(DnspodClient dnsPodClient, String domain, String logLevel);

    Boolean CreateRecord(DnspodClient dnsPodClient, String domain, String logLevel, List<String> subDomain);
}
