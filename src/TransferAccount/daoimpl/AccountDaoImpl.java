package TransferAccount.daoimpl;

import TransferAccount.Utils.C3P0UTils;
import TransferAccount.dao.AccountDao;
import TransferAccount.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {


    private final Connection conn;

    public AccountDaoImpl(Connection connn) {
        this.conn=connn;
    }

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
            qr.update(conn,"update account set money=? where name=?",account.getMoney(),account.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Account findAccountByName(String name) throws Exception{

        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());


        return qr.query(conn,"select*from account where name=?",new BeanHandler<Account>(Account.class),name);


    }


}
