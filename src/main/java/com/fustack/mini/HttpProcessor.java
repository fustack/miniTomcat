package com.fustack.mini;

import com.fustack.mini.connector.HttpConnector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by yaoagcn on 2019/6/17.
 */
public class HttpProcessor {

    private HttpConnector httpConnector;

    public HttpProcessor(final HttpConnector conn) {
        this.httpConnector = conn;
    }

    public void process(final Socket clientSocket) {

        try (

                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream()){

            Request request = new Request(inputStream);
            request.parseRequest();

            new Response(request, outputStream).processStaticResource();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
