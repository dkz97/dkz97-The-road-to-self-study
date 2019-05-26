package Day23_Network_FunctionalInterface.TCPDemo01;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 创建服务端
/*
* 1.首先创建服务端对象ServerSocket传入端口号
* 2.利用对象接收客户端的链接，进行三次握手，获取Socket对象
* 3.read接收客户端发送的数据
* 4.write可以返回数据
* 5.关闭客户端，关闭服务端*/
public class TcpServerDemo01 {

    public static void main(String[] args) throws IOException {
        // 创建服务端端口
        ServerSocket serverSocket = new ServerSocket(8080);

        // 接收客户端的链接
        Socket socket = serverSocket.accept();

        InputStream is = socket.getInputStream();
        // 接收客户端发送的信息
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));

        
        OutputStream os = socket.getOutputStream();
        os.write("接收到了谢谢".getBytes());

        socket.close();
        serverSocket.close();

    }

}
