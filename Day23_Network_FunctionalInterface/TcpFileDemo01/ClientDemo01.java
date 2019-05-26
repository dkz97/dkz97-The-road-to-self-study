package Day23_Network_FunctionalInterface.TcpFileDemo01;


import java.io.*;
import java.net.Socket;

/*
 * 文件的传输，客户端给服务端
 * 1.先从本地硬盘读取文件
 * 2.把读取的文件通过网络字节流发送给服务器
 * 3.接收服务器读取情况
 * 4.关闭字节流*/
public class ClientDemo01 {

    public static void main(String[] args) throws IOException {
        // 创建本地输入流，读取硬盘的文件数据
        FileInputStream fis = new FileInputStream("a.txt");

        // 创建网络输出流，给服务器传输数据
        Socket socket = new Socket("127.0.0.1",8080);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();

        // 读取本地文件，并且通过网络输出流给服务端写出数据
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes,0,len);
        }

        socket.shutdownOutput(); // 关闭输出流，防止阻塞

        // 接收文件写入完毕
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
        }

        socket.close();
        fis.close();


    }

}