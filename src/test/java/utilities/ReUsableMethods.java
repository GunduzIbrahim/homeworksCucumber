package utilities;

import java.sql.*;

public class ReUsableMethods {
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    public static void getTable(String sqlCode) throws SQLException {
        connection = DriverManager.getConnection(ConfigReader.getProperty("db_url"), ConfigReader.getProperty("db_username"), ConfigReader.getProperty("db_password"));
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        resultSet = statement.executeQuery(sqlCode);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println(resultSetMetaData.getColumnName(1) + " \t| " + resultSetMetaData.getColumnName(2)
                + " \t| " + resultSetMetaData.getColumnName(3) + " \t| " + resultSetMetaData.getColumnName(4));
        System.out.println("===============================================================");
        while (resultSet.next()){

            int productId = resultSet.getInt("product_id");
            String productName = resultSet.getString("product_name");
            int productPrice = resultSet.getInt("product_price");
            int productPiece = resultSet.getInt("product_piece");

            System.out.println(productId + " \t\t| "+ productName + " \t\t\t| " + productPrice + " \t\t\t| " + productPiece);
        }
        connection.close();
    }
}
