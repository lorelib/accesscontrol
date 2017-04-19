package com.lorelib.hawk.infrastructure.helpers.utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * ZIP压缩工具
 *
 * @author luomm
 *         2015年8月12日
 */
public class ZipUtil {

    private final static int BUFFER_SIZE = 1024;

    /**
     * @param folderPath 需打包的文件目录
     * @param zipPath    ZIP文件路径
     * @return
     * @description 创建ZIP
     */
    public static boolean createZip(String folderPath, String zipPath) {
        boolean flag = Boolean.FALSE;
        ZipOutputStream zos = null;
        try {
            if (!new File(zipPath).getParentFile().exists()) new File(zipPath).getParentFile().mkdirs();
            zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipPath)));
            writeZip(new File(folderPath), "", zos);
            flag = Boolean.TRUE;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(zos);
        }
        return flag;
    }

    public static void writeZip(File file, String parentPath, ZipOutputStream zipOut) {
        if (file.exists()) {
            if (StringUtils.isNotBlank(parentPath) && !parentPath.endsWith(File.separator)) parentPath += File.separator;
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    writeZip(f, parentPath + file.getName() + File.separator, zipOut);
                }
            } else {
                BufferedInputStream bin = null;
                try {
                    byte[] buf = new byte[BUFFER_SIZE];
                    ZipEntry entry = new ZipEntry(parentPath + file.getName());
                    zipOut.putNextEntry(entry);
                    bin = new BufferedInputStream(new FileInputStream(file));
                    int read = -1;
                    while ((read = bin.read(buf)) != -1) {
                        zipOut.write(buf, 0, read);
                        zipOut.flush();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    IOUtils.closeQuietly(bin);
                }
            }
        }
    }

    public static void addFile(File zip, File newFile) {
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zip)));
            byte[] buf = new byte[BUFFER_SIZE];
            ZipEntry entry = new ZipEntry(newFile.getName());
            zos.putNextEntry(entry);
            InputStream is = new BufferedInputStream(new FileInputStream(newFile));
            int read = -1;
            while ((read = is.read(buf, 0, 1024)) != -1) {
                zos.write(buf, 0, read);
            }
            zos.flush();
            is.close();
            zos.closeEntry();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(zos);
        }
    }
}
