package TransferAccount2.test;

import TransferAccount2.serviceimpl.Transferimpl;

import java.util.Date;

public class Test {

    @org.junit.Test
    public void test1(){

        Transferimpl tf=new Transferimpl();

         tf.transfer("lan","li",20);


    }

    @org.junit.Test
    public void test2(){
        System.out.println(new Date());
    }


}

