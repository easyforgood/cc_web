package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class MyConnection {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String user = "root";
    private static String password = "1234";
    private static Connection con = null;
    private static Statement st = null;

//    public MyConnection() {
//        getCon();
//    }

    public Connection getCon() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("failed!!!!!!!!!");
        }
        return con;
    }

    public boolean createTables(String sql) {
        boolean flag = false;
        try {
            st = con.createStatement();
            flag = st.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            close();
        }
        return flag;
    }

    public void close() {
        try {
            if (st != null) {
                st.close();
            }
            if(con != null) {
                con.close();
            }
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
    }
}

