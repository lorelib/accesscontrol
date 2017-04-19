package com.lorelib.hawk.infrastructure.helpers.utils;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author luomm
 *         2015年8月18日
 * @description 网络获取文件
 */
public class NetFileUtil {

    public static boolean getFile(String urlStr, File dest) {
        InputStream fis = null;
        OutputStream fos = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            fis = connection.getInputStream();
            fos = new FileOutputStream(dest);
            IOUtils.copy(fis, fos);
            return Boolean.TRUE;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fis);
            IOUtils.closeQuietly(fos);
        }
        return Boolean.FALSE;
    }

}
