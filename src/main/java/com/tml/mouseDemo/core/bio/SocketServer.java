package com.tml.mouseDemo.core.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("等待连接-----------");
            Socket socket = serverSocket.accept();
            System.out.println("有客户端连接了--------");
            handler(socket);
        }

    }

    private static void handler(Socket clientSocket) throws IOException {
        byte[] contents = new byte[1024];
        System.out.println("准备read~");
        int read = clientSocket.getInputStream().read(contents);
        System.out.println("read end~");

        if (read != -1) {
            System.out.println("接收到客户端的数据：" + new String(contents, 0, read));
        }

    }
}
