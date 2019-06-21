package service.impl;

import dao.impl.UserDoimpl;
import service.DeleteSelectService;

public class DeleteSelectServiceimpl implements DeleteSelectService {
    @Override
    public void delSelectService(String[] uids) {
        UserDoimpl userdo = new UserDoimpl();

        for (String uid : uids) {
            int id = Integer.parseInt(uid);
            userdo.deleteUser(id);
        }
    }
}
