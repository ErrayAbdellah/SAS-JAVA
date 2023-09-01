import dao.DbConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");

        Connection connection = DbConnection.dbConnection();
        if(connection == null){
            System.out.println("error");
        }else {
            System.out.println("ndy");
        }

    }
}
