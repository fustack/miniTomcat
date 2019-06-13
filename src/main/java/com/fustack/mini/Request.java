package com.fustack.mini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yaoagcn on 2019/6/13.
 */
public class Request {

    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String uri;
    private InputStream inputStream;

    public Request(InputStream in) {
        this.inputStream = in;
    }

    /**
     * Read the http request infomation
     */
    public void parseRequest() {
        StringBuffer stringBuffer = new StringBuffer();
        int i;
        byte[] buffer = new byte[2048];

        try {
            i = inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }

        for (int j = 0; j < i; j++) {
            stringBuffer.append((char)buffer[j]);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("parse request:\n{}", stringBuffer.toString());
        }
        this.parseUri(stringBuffer.toString());
    }

    public void parseUri(final String reqStr) {
        // 例如 GET /index.html ABCD.....
        int firstSpace = reqStr.indexOf(" ");
        int secSpace = reqStr.indexOf(" ", firstSpace + 1);
        if (firstSpace == -1 || secSpace == -1) {
            logger.error("parse uri is empty");
            return;
        }
        uri = reqStr.substring(firstSpace + 1, secSpace);
        if (logger.isDebugEnabled()) {
            logger.debug("parse uri:{}", uri);
        }
    }

    public String getUri() {
        return uri;
    }


}
