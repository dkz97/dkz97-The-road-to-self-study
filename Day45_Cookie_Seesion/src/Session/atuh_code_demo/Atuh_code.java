package Session.atuh_code_demo;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


// 设置验证码的servlet，可以将验证码使用session，发送到session中
@WebServlet("/code")
public class Atuh_code extends HttpServlet {

    public Color getRandomColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }

        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);

        return new Color(r, g, b);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("auth_code....执行");
//        //设置页面不缓存
//        response.setHeader("Pragma", "No-cache");
//        response.setHeader("Cache-Control", "No-cache");
//        //设置有效期
//        response.setDateHeader("Expires", 0);

        //创建随机对象
        Random random = new Random();

        //设置图片的宽度和高度,创建图片对象之前设置的
        int width = 60, height = 20;
        //创建一个图像对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


        //获取画笔对象
            //  fillRect 填充方法
            //  draw 画的方法
        Graphics g = image.createGraphics();

        //设置图像的背景颜色
        g.setColor(new Color(255, 255, 255));
        //填充一个矩形，一样的大小
        g.fillRect(0, 0, width, height);

        //设置字体
        g.setFont(new Font("Tahoma", Font.PLAIN, 20));

        //随机数字符串
        String sRand = "";

        for (int i = 0; i < 4; i++) {
            //生成四个数字字符
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            //生成随机颜色
            g.setColor(new Color(100 + random.nextInt(155), random.nextInt(100), 100 + random.nextInt(155)));
            //将随机数字画在图像上
            g.drawString(rand, (12 + random.nextInt(2)) * i + 6, 18);
        }

        //生成干扰线
        for (int k = 0; k < 24; k++) {
            g.setColor(getRandomColor(0, 255));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(6);
            int y1 = random.nextInt(6);
            g.drawLine(x, y, x + x1, y + y1);
        }

        //生成干扰像素点
        for (int i = 0; i < 10; i++) {
            g.setColor(getRandomColor(50, 180));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            g.drawOval(x, y, 1, 1);
        }

        //输出图片到页面
        ImageIO.write(image, "JPEG", response.getOutputStream());


        // 获取session对象，并且发送验证码
        HttpSession session = req.getSession();
        session.setAttribute("authCode",sRand);

    }

}

