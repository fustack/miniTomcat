package com.fustack.mini;

import com.sun.deploy.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by yaoagcn on 2019/6/13.
 */
public class Response {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private OutputStream outputStream;

    private  Request request;

    public Response(Request req, OutputStream out) {
        this.request = req;
        this.outputStream = out;
    }

    /**
     * Process the static resource request.
     */
    public void processStaticResource() throws IOException {
        logger.info("process file:{}", HttpServer.WEB_ROOT + request.getUri());
        // 如果不加 file.separator 得到的不是绝对路径在 macos上
        File file = new File(File.separator + HttpServer.WEB_ROOT + request.getUri());
        if (file.exists() || file.isFile()) {
            outputStream.write(responseToByte("200", "OK"));

        } else {
            // 404
            logger.error("File {} is not exist or is a directory.", request.getUri());
            file = new File(File.separator + HttpServer.WEB_ROOT + "/404.html");
            outputStream.write(responseToByte("404", "Not found."));
        }
        writeFile(file);
    }

    /**
     * 将请求行 请求头转换为byte数组
     *
     * @return
     */
    private byte[] responseToByte(String httpStatus, final String statusDesc) {
        return new StringBuilder().append("HTTP/1.1").append(" ")
                .append(httpStatus).append(" ")
                .append(statusDesc).append("\r\n\r\n")
                .toString().getBytes();
    }

    /**
     * 将读取到的资源文件输出
     * @param file 读取到的文件
     * @throws IOException IOException
     */
    private void writeFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] cache = new byte[2048];
            int read;
            while ((read = fis.read(cache, 0, 2048)) != -1) {
                outputStream.write(cache, 0, read);
            }
        }
    }
}
