//package org.andestech.learning.rfb18;
//
//import java.sql.*;
//import java.util.Properties;
//
//public class SQL {
//    public void testConnect () throws ClassNotFoundException, SQLException {
//
//        Class.forName("org.postgresql.Driver");
//
//        String url = "jdbc:postgresql://localhost/postgres";
//        Properties props = new Properties();
//        props.setProperty("user","postgres");
//        props.setProperty("password","dbpass");
//        props.setProperty("ssl","false");
//        Connection conn = DriverManager.getConnection(url, props);
//
//
//        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//        String query = "select accountnum from public.data";
//        ResultSet rs = st.executeQuery(query);
//
//
//        rs.close();
//        conn.close();}
//
//    public void insertCustomer () {
//
//    }
//
//    public String readAccCount() {
//        String query = "select accountnum from public.data";
//        return query;
//
//    }
//
//    public String writeAccCount (){}
//
//    public String readCnum () {}
//
//    public String writeCnum () {}
//
//
//}
