package com.cpb;

import com.cpb.utils.Utils;
import lombok.extern.slf4j.Slf4j;

/**
 * 主程序
 *
 * @author LuoYemao
 * @since 2022/9/4 22:57
 */
@Slf4j
public class Kernal {

    public static void main(String[] args) {
        log.info(Utils.getIpAddress("info"));
    }
}
