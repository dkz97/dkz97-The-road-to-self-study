package Day23_Network_FunctionalInterface.TcpFileDemo01;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
* 文件的传输，服务端接收数据写入文件中
* 1.创建服务端对象，接收链接
* 2.读取网络输入流的数据
* 3.利用本读输入流把文件写入硬盘中
* 4.给客户端发送发送成功
* 5.关闭客户端关闭服务端*/
public class ServerDemo01 {

    public static void main(String[] args) throws IOException{
        // 创建服务端对象，接收客户端对象
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();

        // 创建客户端输入流输出流，创建本地文件输出流
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("服务端写的文件.txt");

        // 接收客户端发送的数据，并且利用本地输出流写入在硬盘中
        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes)) != -1) {
            fos.write(bytes,0,len);
        }

        os.write("文件写入完毕".getBytes());


        socket.close();
        serverSocket.close();
        fos.close();
    }

}
