package com.cpb;

import com.cpb.service.ReqService;
import com.cpb.service.ReqServiceImpl;
import com.cpb.utils.ClientFactory;
import com.cpb.utils.Utils;
import com.tencentcloudapi.dnspod.v20210323.DnspodClient;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 主程序
 *
 * @author LuoYemao
 * @since 2022/9/4 22:57
 */
@Slf4j
public class Kernal {

    public static void main(String[] args) {
        log.info("初始化开始");
        //初始化参数
        Scanner sc = new Scanner(System.in);
        log.info("SecretID:");
        String secretId = sc.next();
        log.info("SecretKey:");
        String secretKey = sc.next();
        log.info("Interval(输入0使用默认值):");
        int interval = sc.nextInt();
        if (interval == 0) {
            interval = 30;
        }
        log.info("Domain:");
        String domain = sc.next();
        log.info("Region(输入0使用默认值):");
        String region = sc.next();
        if (region.equals("0")) {
            region = "ap-guangzhou";
        }
        log.info("LogLevel(输入0使用默认值):");
        String logLevel = sc.next();
        if (logLevel.equals("0")) {
            logLevel = "info";
        }
        logLevel = logLevel.toLowerCase();
        log.info("subDomain(输入0使用默认值):");
        String subDomain = sc.next();
        if (subDomain.equals("0")) {
            subDomain = "www;@";
        }
        List<String> subDomainList = new ArrayList<>();
        String[] subDomains = subDomain.split(";");
        for (String s : subDomains) {
            subDomainList.add(s);
        }
        String ipAddress = Utils.getIpAddress(logLevel);
        ReqService service = new ReqServiceImpl();
        DnspodClient client = ClientFactory.generate(secretId, secretKey, region);
        log.info("初始化结束");
        log.info("执行参数：" + region + "::" + interval + "s::" + domain + "::" + logLevel + "::" + ipAddress);
        log.info("内核启动");

        //初始轮
        while (true) {
            try {
                Long start = System.currentTimeMillis();
                if (logLevel.equals("info")) log.info("IP改变：" + ipAddress + " -> " + Utils.getIpAddress(logLevel));
                Boolean statusDelete = service.DeleteRecord(client, domain, logLevel);
                if (!statusDelete) {
                    log.error("初始轮执行失败，重试中");
                }
                Boolean statusCreate = service.CreateRecord(client, domain, logLevel, subDomainList);
                if (!statusCreate) {
                    log.error("初始轮执行失败，重试中");
                }
                List<Long> idList = service.GetRecordList(client, domain, logLevel);
                if (idList.size() > 0) {
                    log.info("初始轮完成：" + idList + "::" + (System.currentTimeMillis() - start) + "ms");
                    break;
                } else {
                    log.error("初始轮失败, 重试中");
                }
            } catch (Exception e) {
                log.error(e.getMessage());
                return;
            }
        }

        while (true) {
            try {
                if (!ipAddress.equals(Utils.getIpAddress(logLevel))) {
                    Long start = System.currentTimeMillis();
                    if (logLevel.equals("info")) log.info("IP改变：" + ipAddress + " -> " + Utils.getIpAddress(logLevel));
                    Boolean statusDelete = service.DeleteRecord(client, domain, logLevel);
                    if (!statusDelete) {
                        log.error("删除记录失败，重试中");
                        continue;
                    }
                    Boolean statusCreate = service.CreateRecord(client, domain, logLevel, subDomainList);
                    if (!statusCreate) {
                        log.error("添加记录失败，重试中");
                        continue;
                    }
                    List<Long> idList = service.GetRecordList(client, domain, logLevel);
                    if (idList.size() > 0) {
                        log.info("更新轮完成：" + idList + "::" + (System.currentTimeMillis() - start) + "ms");
                    } else {
                        log.error("更新轮失败, 重试中");
                        continue;
                    }
                } else {
                    if (logLevel.equals("info")) log.info("本轮IP未改变");
                }
                Thread.sleep(interval * 1000);
            } catch (Exception e) {
                log.error(e.getMessage());
                return;
            }
        }
    }
}
