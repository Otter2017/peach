package cn.acrab.peach.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;

import java.io.*;
import java.net.Socket;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.concurrent.Executors;

public class SocketMessageProcessor implements Runnable {

    private Logger log = LoggerFactory.getLogger(SocketMessageProcessor.class);

    private static final int threadSleepInterval = 2000;

    private Socket acceptSocket;

    public SocketMessageProcessor(Socket acceptSocket) {
        this.acceptSocket = acceptSocket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = acceptSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String message = null;
            StringBuilder stringBuilder = new StringBuilder();
            do {
                message = reader.readLine();
                if (message != null && message.length() > 0) {
                    stringBuilder.append(message);
                }
            } while (message != null);
            if (stringBuilder.length() > 0){
                log.info("accept message : " + stringBuilder.toString());
                System.out.println();
            }


            reader.close();
            inputStream.close();
        } catch (Exception ex) {
            log.error("getInputStream Error " + ex.getMessage());
        } finally {
            try {
                acceptSocket.close();
            } catch (Exception ex) {
                log.error("Socket close error:" + ex.getMessage());
            }
        }
    }

//    public boolean writeSocketMessageToFile(InputStream inputStream){
//        try {
//            BufferedInputStream reader = new BufferedInputStream(inputStream);
//            if(reader.available()>0){
//                byte[] buffer=new byte[1024];
//                String savePath = SocketServiceConfig.class.getProtectionDomain().getCodeSource().getLocation().getPath();
//                File saveFile=new File()
//                while(reader.read(buffer)>0){
//
//                }
//            } else {
//                return  false;
//            }
//            reader.available()
//
//            reader.read()
//            reader.re
//        } catch (Exception ex){
//
//        }
//
//    }
}
