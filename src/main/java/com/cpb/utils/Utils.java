package com.cpb.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 工具类
 *
 * @author LuoYemao
 * @since 2022/9/4 21:57
 */
public class Utils {

    /**
     * 获取最新IP
     *
     * @author LuoYemao
     * @since 2022/9/4 22:06
     */
    public static String getIpAddress(String logLevel) {
        String ipAddress = "";
        String targetUrl = "https://www.8684.cn/ip";
        try {
            URL url = new URL(targetUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.102 Safari/537.36 Edg/104.0.1293.70");
            InputStream inputStream = connection.getInputStream();
            String html = new BufferedReader(new InputStreamReader(inputStream, "utf-8")).lines().collect(Collectors.joining());
            Pattern pattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
            Matcher matcher = pattern.matcher(html);
            if (matcher.find()) {
                ipAddress = matcher.group();
            } else {
                System.out.println("[ERROR:" + new Date() + "]" + "未匹配到合法IP");
            }
            inputStream.close();
        } catch (Exception e) {
            System.out.println("[ERROR:" + new Date() + "]" + e.getMessage());
        }
        if (logLevel.equals("info")) System.out.println("[INFO:" + new Date() + "]" + "查询IP成功：" + ipAddress);
        return ipAddress;
    }
}
