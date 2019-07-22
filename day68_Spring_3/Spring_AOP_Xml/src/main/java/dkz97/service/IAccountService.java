package dkz97.service;

/**
 * 模拟账号保存的业务层接口
 */
public interface IAccountService {

    /**
     * 模拟保存账户
     */
    public void saveAccount();

    /**
     * 模拟根据id更新账户
     */
    public void updateAccount(int i);

    /**
     * 模拟删除账户
     */
    public int deleteAccount();
}
