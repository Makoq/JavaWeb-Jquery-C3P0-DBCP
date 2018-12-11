package TransferAccount.test;

import TransferAccount.serviceimpl.Transferimpl;

public class Test {

    @org.junit.Test
    public void test1(){

        Transferimpl tf=new Transferimpl();

         tf.transfer("lan","li",20);


    }
}
