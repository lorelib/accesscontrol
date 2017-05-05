package com.lorelib.hawk.infrastructure.email;

import com.lorelib.hawk.infrastructure.config.ConfigHolder;

import javax.mail.*;
import java.util.Properties;

public class EmailUtil {
    private static Properties props;

    /**
     * SMTP主机
     */
    private static String hostname = ConfigHolder.getString("email.smtp.hostname");

    /**
     * smtp是否需要认证
     */
    private static boolean needAuth = ConfigHolder.getBoolean("email.smtp.needAuth");

    /**
     * 端口
     */
    private static int port = ConfigHolder.getInteger("email.smtp.port", 25);

    /**
     * smtp认证用户名
     */
    private static String username = ConfigHolder.getString("email.smtp.username");
    /**
     * smtp认证密码
     */
    private static String password = ConfigHolder.getString("email.smtp.password");

    private static String transportProtocol = ConfigHolder.getString("email.smtp.transport.protocol");

    static {
        props = System.getProperties();
        props.put("mail.smtp.host", hostname); // 设置SMTP主机
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", needAuth);
        props.put("mail.transport.protocol", transportProtocol);
    }

    public static void sendEmail(String emails, String msg, String title) throws MessagingException {

    }

    public static void sendEmail(String emails, String msg, String title, String attachFileUrl, String attachFileName)
            throws MessagingException {

    }
}
