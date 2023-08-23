package com.example.writeagain.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class Download {

    public static void downloadFile(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // 本地文件地址，文件名称，我是在本机运行，如果是服务器的话，地址可能是 ../fileServer/file/deploy2.sh
        String filePath = "D:\\nginx\\pic\\Excel模板.xlsx";
        String fileName = "Excel模板.xlsx";


        // 获取浏览器的信息
        String agent = request.getHeader("USER-AGENT");
            //其他的浏览器
            response.setHeader("Content-Disposition",
                    "attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);

        byte[] fileByte = new byte[(int) file.length()];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        byteArrayOutputStream.close();
        fileByte = byteArrayOutputStream.toByteArray();

        OutputStream outputStream = null;
        outputStream = response.getOutputStream();
        outputStream.write(fileByte);
        outputStream.flush();
        outputStream.close();

    }
}
