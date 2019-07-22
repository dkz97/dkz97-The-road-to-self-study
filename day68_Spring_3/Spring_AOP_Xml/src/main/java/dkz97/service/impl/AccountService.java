package dkz97.service.impl;

import dkz97.service.IAccountService;

public class AccountService implements IAccountService {



    public void saveAccount() {
        System.out.println("成功保存账户！");
    }

    public void updateAccount(int i) {

        System.out.println("成功更新账户" + i);
    }

    public int deleteAccount() {
        System.out.println("成功删除账户");
        return 0;
    }
}
