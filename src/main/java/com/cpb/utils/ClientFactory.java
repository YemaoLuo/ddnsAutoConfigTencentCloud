package com.cpb.utils;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.dnspod.v20210323.DnspodClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientFactory {

    public static DnspodClient generate(String secretId, String secretKey, String region) {
        try {
            Credential credential = new Credential(secretId, secretKey);
            return new DnspodClient(credential, region);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
