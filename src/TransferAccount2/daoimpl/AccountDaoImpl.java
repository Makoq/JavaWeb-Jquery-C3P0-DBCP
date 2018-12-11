package TransferAccount2.daoimpl;

import TransferAccount2.Utils.C3P0UTils;
import TransferAccount2.Utils.ManagerThreadLocal;
import TransferAccount2.dao.AccountDao;
import TransferAccount2.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {




    @Override
    public void update(String outaccount, String inaccount, double transfermoney) {
        //创建QueryRunner对象
        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());


        try {


            Object outaccmon=qr.query("select money from account where name=?",new ScalarHandler(1),outaccount);
            Object inaccmon=qr.query("select money from account where name=?",new ScalarHandler(1),inaccount);


            int i=qr.update("update account set money=? where name=?",(double)outaccmon-transfermoney,outaccount);
            int j=qr.update("update account set money=? where name=?",(double)inaccmon+transfermoney,inaccount);


            if(i>0&&j>0) {
                System.out.println("operate successful!");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




    @Override
    public void update(Account account)  {

        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());

        try {
            qr.update(ManagerThreadLocal.getConnection(),"update account set money=? where name=?",account.getMoney(),account.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Account findAccountByName(String name) throws Exception{

        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());


        return qr.query(ManagerThreadLocal.getConnection(),"select*from account where name=?",new BeanHandler<Account>(Account.class),name);


    }


}
