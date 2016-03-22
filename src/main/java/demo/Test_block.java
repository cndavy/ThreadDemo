package demo;

import java.util.ArrayList;

/**
 * Created by han on 2016/3/21.
 */
public class Test_block {

    public static void main(String[] args)  {
        final InsertData insertData = new InsertData();

        new Thread() {
            public void run() {
                insertData.insert();
            };
        }.start();


        new Thread() {
            public void run() {
                insertData.insert1();
            };
        }.start();
    }
}

class InsertData {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public synchronized void insert(){
        System.out.println("执行insert");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行insert完毕");
    }

    public synchronized static void insert1() {
        System.out.println("执行insert1");
        System.out.println("执行insert1完毕");
    }
}