package TransferAccount2.serviceimpl;

import TransferAccount2.Utils.ManagerThreadLocal;
import TransferAccount2.daoimpl.AccountDaoImpl;
import TransferAccount2.domain.Account;
import TransferAccount2.service.Transfer;

public class Transferimpl implements Transfer {

    AccountDaoImpl acc=new AccountDaoImpl();

    @Override
    public void transfer(String outname, String inname, double money) {


        //acc.update(outname,inname,money);

        try {
            ManagerThreadLocal.startTransaction();
            //找到账号
            Account outacc=acc.findAccountByName(outname);
            Account inacc=acc.findAccountByName(inname);

            //设置转账
            outacc.setMoney(outacc.getMoney()-money);
            inacc.setMoney(inacc.getMoney()+money);

            //更新对象
            acc.update(outacc);

            //int i=10/0;

            acc.update(inacc);

            ManagerThreadLocal.commit();
        } catch (Exception e) {

                ManagerThreadLocal.rollback();

        }finally {

                ManagerThreadLocal.release();

        }


    }
}
