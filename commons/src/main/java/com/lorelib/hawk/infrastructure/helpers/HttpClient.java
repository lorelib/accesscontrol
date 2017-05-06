package com.lorelib.hawk.infrastructure.helpers;

import com.lorelib.hawk.infrastructure.helpers.utils.StringUtil;
import org.apache.commons.io.Charsets;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Http请求客户端.
 *
 * @author luomm 2015年4月30日
 */
public class HttpClient {

    public static String post(String uri) throws Exception {
        return post(uri, null, null, false);
    }

    public static String postByHttps(String uri) throws Exception {
        return post(uri, null, null, true);
    }

    public static String postJson(String uri, String json) throws Exception {
        return post(uri, json, "application/json", false);
    }

    public static String postJsonByHttps(String uri, String json) throws Exception {
        return post(uri, json, "application/json", true);
    }

    public static String post(String uri, String data, String contentType, boolean isSSL) throws Exception {
        String result = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = isSSL ? createSSLHttpClient() : HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(uri);
            if (StringUtil.isNotBlank(data)) {
                httpPost.setEntity(new StringEntity(data, Charsets.UTF_8));
            }
            if (StringUtil.isNotBlank(contentType)) {
                httpPost.setHeader("Content-Type", contentType + ";charset=utf-8");
            }
            httpPost.setHeader("charset", Charsets.UTF_8.displayName());
            response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) result = EntityUtils.toString(httpEntity);
        } finally {
            if (response != null) response.close();
            if (httpClient != null) httpClient.close();
        }
        return result;
    }

    public static String postFile(String uri, String data, InputStream in) throws Exception {
        return postFile(uri, data, in, false);
    }

    public static String postFileByHttps(String uri, String data, InputStream in) throws Exception {
        return postFile(uri, data, in, true);
    }

    /**
     * 发送文件.
     */
    public static String postFile(String uri, String data, InputStream in, boolean isSSL) throws Exception {
        String result = null;
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        try {
            httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(uri);
            MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
            entityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            entityBuilder.setCharset(Charsets.UTF_8);
            InputStreamBody inbody = new InputStreamBody(in, ContentType.APPLICATION_OCTET_STREAM);
            entityBuilder.addPart("files", inbody);
            entityBuilder.addTextBody("data", data, ContentType.create("text/plain", Charsets.UTF_8));
            httpPost.setEntity(entityBuilder.build());
            httpPost.setHeader("charset", Charsets.UTF_8.displayName());
            response = httpclient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) result = EntityUtils.toString(httpEntity);
        } finally {
            if (response != null) response.close();
            if (httpclient != null) httpclient.close();
        }
        return result;
    }

    public static String get(String uri) throws Exception {
        return get(uri, false);
    }

    public static String getByHttps(String uri) throws Exception {
        return get(uri, true);
    }

    public static String get(String uri, boolean isSSL) throws Exception {
        String result = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = isSSL ? createSSLHttpClient() : HttpClients.createDefault();
            HttpGet httpget = new HttpGet(uri);
            response = httpClient.execute(httpget);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                result = EntityUtils.toString(httpEntity);
            }
        } finally {
            if (response != null) response.close();
            if (httpClient != null) httpClient.close();
        }
        return result;
    }

    private static CloseableHttpClient createSSLHttpClient() throws Exception {
        CloseableHttpClient httpClient;
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }
        };
        SSLContext sc = SSLContext.getInstance(SSLConnectionSocketFactory.SSL);
        sc.init(null, new TrustManager[]{trustManager}, new SecureRandom());
        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sc, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        httpClient = HttpClients.custom().setSSLSocketFactory(factory).build();
        return httpClient;
    }
}
