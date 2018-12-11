package TransferAccount.dao;

import TransferAccount.domain.Account;

public interface AccountDao {

    /**
     * 转入账户outaccount
     * 转出账户inaccount
     * 转账金额transfermoney
     */
    @Deprecated
    public void update(String outaccount,String inaccount,double transfermoney)throws Exception;

    /**
     * 根据账户信息修改
     */
    public void update(Account account)throws Exception;

    /**
     * 根据用户名查找账户信息
     * @return
     * @throws Exception
     */

    public Account findAccountByName(String name)throws Exception;

}
