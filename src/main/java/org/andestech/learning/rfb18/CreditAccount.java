package org.andestech.learning.rfb18;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

//кредитные счета
public class CreditAccount {


    String accNum;
    String ownerId = "";//проверить, откуда он приходит
    double toPay;
    double monthlyPay;
    int period;

    ArrayList accounts = new ArrayList<CreditAccount>();

    public CreditAccount(String ownerId, double toPay, double monthlyPay, int period) {
        this.accNum = accNum;
        this.ownerId = ownerId;
        this.toPay = toPay;
        this.monthlyPay = monthlyPay;
        this.period = period;
    }


    public String setAccNum () throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost/postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","dbpass");
        props.setProperty("ssl","false");
        Connection conn = DriverManager.getConnection(url, props);

        String query = "select * from public.data";
        Statement st = conn.createStatement();
        //ResultSet results = st.executeQuery(query).getInt("accountnum");
        //ResultSetMetaData metaDt = results.getMetaData();

        int accNumCount = st.executeQuery(query).getInt("accountnum");
        String s = String.format("%07d", accNumCount);
        accNum = "4081781012000"+s;
        accNumCount++;
        System.out.println(accNumCount);
        String updQuery = "UPDATE public.data SET accountnum = "+accNumCount;
        st.executeQuery(updQuery);
        String log = "Создан счет № "+accNum;



        st.close();
        conn.close();
        return accNum;
        }

        public void closeCredit() {
        //описать и залогировать метод
        }

        public void makePayment () {
        //описать и залогировать метод
        }





//    public void addAcc(){
//        accounts.add(1,new CreditAccount());
//
//    }


}
