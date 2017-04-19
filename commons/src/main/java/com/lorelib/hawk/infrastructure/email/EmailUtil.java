package com.lorelib.hawk.infrastructure.email;

import com.lorelib.hawk.infrastructure.config.ConfigHolder;
import org.apache.commons.lang3.StringUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.ArrayList;
import java.util.List;
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
        sendEmail(emails, null, null, null, msg, title, null, null);
    }

    public static void sendEmail(String emails,
                                 String msg,
                                 String title,
                                 String attachFileUrl,
                                 String attachFileName)
            throws MessagingException {
        sendEmail(emails, null, null, null, msg, title, attachFileUrl, attachFileName);
    }

    public static void sendEmail(String emails,
                                 String copytouser,
                                 String receiver,
                                 String activateurl,
                                 String msg, String title,
                                 String attachFileUrl,
                                 String attachFileName)
            throws MessagingException {
        if (copytouser == null) copytouser = "";
        UserAuthenticator authenticator = null;
        if (needAuth) {
            authenticator = new UserAuthenticator(username, password);
        }
        Session session = Session.getDefaultInstance(props, authenticator); // 获得邮件会话对象
        //session.setDebug(true);
        MimeMessage mimeMsg = new MimeMessage(session); // 创建MIME邮件对象
        mimeMsg.setFrom(new InternetAddress(username)); // 设置发信人
        String[] emailList = emails.split(";");
        List<Address> addressList = new ArrayList<Address>();
        for (String email : emailList) {
            Address address = new InternetAddress(email);
            addressList.add(address);
        }
        mimeMsg.setRecipients(Message.RecipientType.TO, addressList.toArray(new Address[]{}));// 接受者
        if (StringUtils.isNotBlank(copytouser)) {
            mimeMsg.setRecipients(Message.RecipientType.CC, (Address[]) InternetAddress.parse(copytouser));// 抄送
        }
        mimeMsg.setSubject(title); // 设置标题
        Multipart mp = new MimeMultipart();
        BodyPart bp = new MimeBodyPart();
        bp.setContent("<meta http-equiv=Content-Type content=text/html; charset=utf-8>" + msg, "text/html;charset=UTF-8");
        mp.addBodyPart(bp);

        //发送附件
        if (StringUtils.isNoneBlank(attachFileUrl, attachFileName)) {
            BodyPart attachment = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(attachFileUrl);
            DataHandler dh = new DataHandler(fds);
            attachment.setFileName("=?GBK?B?" + new sun.misc.BASE64Encoder().encode(attachFileName.getBytes()) + "?=");
            attachment.setDataHandler(dh);
            mp.addBodyPart(attachment);
        }

        mimeMsg.setContent(mp);
        mimeMsg.saveChanges();

        Transport transport = session.getTransport(transportProtocol);
        transport.connect((String) props.get("mail.smtp.host"), port, username, password);
        transport.sendMessage(mimeMsg, mimeMsg.getRecipients(javax.mail.Message.RecipientType.TO));
        transport.close();
    }
}
