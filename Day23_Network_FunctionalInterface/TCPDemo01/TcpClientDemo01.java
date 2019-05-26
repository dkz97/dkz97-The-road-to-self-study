package Day23_Network_FunctionalInterface.TCPDemo01;

/*
* 基于tcp链接的客户端
* 1.先创建自身客户socket对象
* 2.创建输出流
* 3.写东西到服务端
* 4.接收服务端的东西
* 5.关闭流*/

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClientDemo01 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);//写入ip地址和端口号
        //  获取输出流，让可以给服务端传输数据
        OutputStream os = socket.getOutputStream();
        os.write("给客户端发送数据".getBytes());

        // 获取输入流，接收服务端发送回来的数据
        InputStream is = socket.getInputStream();

        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
        }

        // 关闭释放资源
        socket.close();
    }

}
