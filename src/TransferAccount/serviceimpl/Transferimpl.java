package TransferAccount.serviceimpl;

import TransferAccount.Utils.C3P0UTils;
import TransferAccount.daoimpl.AccountDaoImpl;
import TransferAccount.domain.Account;

import java.sql.Connection;
import java.sql.SQLException;

public class Transferimpl implements TransferAccount.service.Transfer {

    @Override
    public void transfer(String outname, String inname, double money) {
        Connection connn=C3P0UTils.getConnection();
        AccountDaoImpl acc=new AccountDaoImpl(connn);

        //acc.update(outname,inname,money);

        try {
            connn.setAutoCommit(false);
            //找到账号
            Account outacc=acc.findAccountByName(outname);
            Account inacc=acc.findAccountByName(inname);

            //设置转账
            outacc.setMoney(outacc.getMoney()-money);
            inacc.setMoney(inacc.getMoney()+money);

            //更新对象
            acc.update(outacc);



            acc.update(inacc);

            connn.commit();
        } catch (Exception e) {
            try {
                connn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                connn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
