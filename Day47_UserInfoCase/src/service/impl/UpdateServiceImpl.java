package service.impl;

import dao.impl.UserDoimpl;
import domain.User;
import service.UpdateService;

public class UpdateServiceImpl implements UpdateService {
    @Override
    public void updateService(User user) {
        // 调用dao的updateUser
        new UserDoimpl().updateUser(user);
    }
}
