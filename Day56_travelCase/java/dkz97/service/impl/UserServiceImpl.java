package dkz97.service.impl;

import dkz97.dao.Impl.UserDaoImpl;
import dkz97.dao.UserDao;
import dkz97.domain.User;
import dkz97.service.UserService;
import dkz97.utils.MailUtils;
import dkz97.utils.UuidUtil;

import java.util.List;

public class UserServiceImpl implements UserService {


    UserDao dao = new UserDaoImpl();


    @Override
    public boolean register(User login_user) {

        // 调用dao中的查询所有用户名的方法
        List<String> usernames = dao.findByUsername();

        // 对用户名进行校验，如果用户名存在直接返回空对象，就是创建失败
        for (String username:usernames) {
            if (username.equals(login_user.getUsername())) {
                // 就是说明用户名已经存在，那就返回注册失败，返回false
                return false;
            }
        }

        // 如果用户名不存在，使用save方法，将数据保存在数据库中，并且返回user
        // 先获取激活码，以及给对象加激活码和设置激活状态，然后再保存对象
        String uuid = UuidUtil.getUuid();
        login_user.setCode(uuid);
        login_user.setStatus("N");

        System.out.println("用户注册...");
        int save = dao.save(login_user);
        if (save != 0) {
            //影响行数不等于0证明就成功

            //保存成功后就可以发邮件给用户进行激活,因为是给别人点击，到时候写的时候写绝对路径
            String email = "<a href='http://localhost:8080/user/checkCode?code=" + login_user.getCode()+"' >点击激活</a>";

            MailUtils.sendMail(login_user.getEmail(),email,"验证激活");

            return true;
        } else {
            return false;
        }
    }

    // 主要是用来验证激活码是否存在，存在就修改
    @Override
    public boolean checkCode(String code) {
        User user = dao.findByCode(code);

        // 判断user是否存在，如果不为空就是存在
        if (user != null) {
            // 调用修改的方法来修改激活状态
            dao.updateUserStatus(user);
            return true;
        } else {
            // 如果为空就是不存在，直接返回false
            return false;
        }

    }

    public User login(User login_user) {
        //1.调用dao方法
        User user = dao.findByUsername_Password(login_user);

        // 直接返回给servlet，让其进行判断
        return user;
    }
}
