package com.fustack.mini.connector;

import com.fustack.mini.HttpProcessor;
import com.fustack.mini.Request;
import com.fustack.mini.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Optional;

/**
 * Created by yaoagcn on 2019/6/17.
 */
public class HttpConnector implements Runnable {

    private Logger logger  = LoggerFactory.getLogger(this.getClass());

    public boolean isStop = false;

    public static  String WEB_ROOT;
    static {
        URL url = HttpConnector.class.getClassLoader().getResource("webroot");
        WEB_ROOT = Optional.ofNullable(url)
                .orElseThrow(() -> new IllegalStateException("can't not find user web root file."))
                .getFile().substring(1);
        System.out.println("web root:" + WEB_ROOT);
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000, 1, InetAddress.getByName("127.0.0.1"));
            logger.info("server is starting, port is {}", 8000);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (! isStop) {
            try (
                    Socket socket = serverSocket.accept()) {
                    new HttpProcessor(this).process(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        new Thread(this).start();
    }
}
