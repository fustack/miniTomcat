package com.fustack.mini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Optional;

/**
 * Created by yaoagcn on 2019/6/13.
 */
public class HttpServer {

    private Logger logger  = LoggerFactory.getLogger(this.getClass());

    public static  String WEB_ROOT;
    static {
        URL url = HttpServer.class.getClassLoader().getResource("webroot");
        WEB_ROOT = Optional.ofNullable(url)
                .orElseThrow(() -> new IllegalStateException("can't not find user web root file."))
                .getFile().substring(1);
        System.out.println("web root:" + WEB_ROOT);
    }

    //private ServerSocket serverSocket = null;


    public static void main(String[] args) {
        new HttpServer().await();
    }

    public void await() {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000, 1, InetAddress.getByName("127.0.0.1"));
            logger.info("server is starting, port is {}", 8000);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (

            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){

            Request request = new Request(inputStream);
            request.parseRequest();

            new Response(request, outputStream).processStaticResource();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public HttpServer closeQuitely(Closeable c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (IOException e) {
            // e.printStackTrace();
        }
        return this;
    }
}
