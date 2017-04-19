package com.lorelib.hawk.infrastructure.helpers.utils;

import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author luomm
 *         2015年8月14日
 * @description 图片工具类
 */
public class ImageUtil {

    /**
     * @param src   原始图
     * @param dest  目标图
     * @param width 目标图width
     * @throws IOException
     * @description 将原始图裁剪后生成目标图
     */
    public static void cut(File src, File dest, int width, int height) throws IOException {
        BufferedImage srcImage = ImageIO.read(src);
        if (srcImage == null) return;
        BufferedImage destImage = makeThumbnail(srcImage, width, height);

        String fileName = dest.getName();
        String formatName = fileName.substring(fileName.lastIndexOf('.') + 1);
        ImageIO.write(destImage, formatName, dest);
    }

    /**
     * @param image
     * @param width 宽度
     * @return
     * @throws IOException
     * @description 图片缩放
     */
    public static BufferedImage makeThumbnail(BufferedImage image, int width, int height) throws IOException {
        int rawWidth = image.getWidth();
        int rawHeight = image.getHeight();
        if (height == 0) {
            height = (rawHeight * width) / rawWidth;
        }
        BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = buf.getGraphics();
        g.drawImage(image.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        g.dispose();
        return buf;
    }

    /**
     * @param file
     * @throws IOException
     * @description 给图片加边框
     */
    public static void border(File file) throws IOException {
        String fileName = file.getName();
        String formatName = fileName.substring(fileName.lastIndexOf('.') + 1);

        BufferedImage srcImage = ImageIO.read(file);
        if (srcImage == null) return;
        Graphics graphics = srcImage.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0, 0, srcImage.getWidth() - 1, srcImage.getHeight() - 1);
        graphics.dispose();
        ImageIO.write(srcImage, formatName, file);
    }

    /**
     * @param src
     * @param dest
     * @param markStr
     * @throws IOException
     * @description 加水印
     */
    public static void mark(File src, File dest, String markStr) throws IOException {
        String fileName = dest.getName();
        String formatName = fileName.substring(fileName.lastIndexOf('.') + 1);
        BufferedImage srcImage = ImageIO.read(src);
        if (srcImage == null) return;
        Graphics graphics = srcImage.getGraphics();
        graphics.setFont(new Font("Verdana", Font.PLAIN, 16));
        graphics.setColor(Color.ORANGE);
        graphics.drawString(markStr, srcImage.getWidth() - 100, srcImage.getHeight() - 10);
        graphics.dispose();
        ImageIO.write(srcImage, formatName, dest);
    }

    public static void markImageByIconText(String iconPath, String srcImgPath, String targerPath, String text) throws IOException {
        markImageByIconText(iconPath, srcImgPath, targerPath, text, null);
    }

    public static void markImageByIconText(String iconPath, String srcImgPath, String targerPath, String text, Integer degree) throws IOException {
        OutputStream os = null;
        try {
            String formatName = srcImgPath.substring(srcImgPath.lastIndexOf('.') + 1);
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
            // 1、得到画笔对象
            Graphics2D graphics = buffImg.createGraphics();
            // 2、设置对线段的锯齿状边缘处理
            graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            graphics.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
            // 3、设置水印旋转
            if (degree != null) {
                graphics.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
            }
            if (StringUtil.isNotBlank(text)) {
                graphics.setFont(new Font("Verdana", Font.PLAIN, 16));
                graphics.setColor(Color.ORANGE);
                // 6、水印文字的位置
                graphics.drawString(text, buffImg.getWidth() - 100, buffImg.getHeight() - 10);
            }
            if (StringUtil.isNotBlank(iconPath)) {
                // 4、水印图片的路径 水印图片一般为gif或者png的，这样可设置透明度
                ImageIcon imgIcon = new ImageIcon(iconPath);
                // 5、得到Image对象。
                Image img = imgIcon.getImage();
                // 水印透明度
                float alpha = 0.5f;
                graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
                // 6、水印图片的位置
                int iconHeight = img.getHeight(null);
                int iconWidth = img.getWidth(null);
                float scale = (float) iconHeight / iconWidth;
                int width = srcImg.getWidth(null);
                iconWidth = width / 4;
                iconHeight = (int)(iconWidth * scale);
                graphics.drawImage(img, 0, buffImg.getHeight() - iconHeight, iconWidth, iconHeight, null);
                graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            }
            // 7、释放资源
            graphics.dispose();
            // 8、生成图片
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, formatName, os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(os);
        }
    }

    /**
     * 给图片添加水印图片
     *
     * @param iconPath 水印图片路径
     * @param srcImgPath 源图片路径
     * @param targerPath 目标图片路径
     */
    public static void markImageByIcon(String iconPath, String srcImgPath, String targerPath) {
        markImageByIcon(iconPath, srcImgPath, targerPath, null);
    }

    /**
     * 给图片添加水印图片、可设置水印图片旋转角度
     *
     * @param iconPath 水印图片路径
     * @param srcImgPath 源图片路径
     * @param targerPath 目标图片路径
     * @param degree 水印图片旋转角度
     */
    public static void markImageByIcon(String iconPath, String srcImgPath, String targerPath, Integer degree) {
        OutputStream os = null;
        try {
            String formatName = srcImgPath.substring(srcImgPath.lastIndexOf('.') + 1);
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
            // 1、得到画笔对象
            Graphics2D g = buffImg.createGraphics();
            // 2、设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
            // 3、设置水印旋转
            if (degree != null) {
                g.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
            }
            // 4、水印图片的路径 水印图片一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(iconPath);
            // 5、得到Image对象。
            Image img = imgIcon.getImage();
            // 水印透明度
            float alpha = 0.5f;
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            // 6、水印图片的位置
            g.drawImage(img, 0, buffImg.getHeight() - 50, 50, 50, null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            // 7、释放资源
            g.dispose();
            // 8、生成图片
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, formatName, os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(os);
        }
    }

}
