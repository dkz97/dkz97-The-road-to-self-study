package dkz97.mybatis.io;


import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 */
public class Resources {


    /**
     * 根据传入的参数获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        //可以直接使用类加载器来返回
        InputStream rs = Resources.class.getClassLoader().getResourceAsStream(filePath);
        return rs;
    }

}
