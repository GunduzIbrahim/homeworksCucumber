package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.ReUsableMethods;

import java.sql.*;

public class HomeworkSQLTwoSteps {

    String url = ConfigReader.getProperty("db_url");
    String username = ConfigReader.getProperty("db_username");
    String password = ConfigReader.getProperty("db_password");

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("user connects to the database")
    public void userConnectsToTheDatabase() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

    }

    @When("user connects to the market table")
    public void userConnectsToTheMarketTable() throws SQLException {
        String allTable = "SELECT * FROM products";
        resultSet = statement.executeQuery(allTable);
    }

    @Then("the total number of products verify")
    public void theTotalNumberOfProductsVerify() throws SQLException {
        String sqlCode = "SELECT * FROM products";
        ReUsableMethods.getTable(sqlCode);
        int numberOfProduct=0;
        while (resultSet.next()){
            numberOfProduct++;
        }
        System.out.println("\nTotal number of products : "+numberOfProduct);
        Assert.assertEquals(numberOfProduct, 5);
        connection.close();
    }

    @Then("the price is verified by the highest product")
    public void thePriceIsVerifiedByTheHighestProduct() throws SQLException {
        String sqlCode = "SELECT * FROM products";
        ReUsableMethods.getTable(sqlCode);
        String maxPrice = "SELECT max(product_price) FROM products";
        resultSet = statement.executeQuery(maxPrice);
        resultSet.first();

        int highestPrice = resultSet.getInt("max");

        System.out.println("\nHighest Price = " + highestPrice);
        Assert.assertEquals(highestPrice, 50);
        connection.close();
    }

    @And("one of the product name has changed")
    public void oneOfTheProductNameHasChanged() throws SQLException {
        String changedName = "UPDATE products SET product_name = 'Pencil' WHERE product_id = 1000";
        statement.executeUpdate(changedName);
        String sqlCode = "SELECT * FROM products";
        ReUsableMethods.getTable(sqlCode);
    }

    @And("print average price of products")
    public void printAveragePriceOfProducts() throws SQLException {
        String avgPrice = "SELECT avg(product_price) FROM products";
        resultSet = statement.executeQuery(avgPrice);
        resultSet.first();

        double averagePrice = resultSet.getDouble("AVG");

        System.out.println("\nAverage Price = " + averagePrice);
        connection.close();
    }

    @And("print market table change column names")
    public void printMarketTableChangeColumnNames() throws SQLException {
        String allTable = "SELECT product_id AS id, product_name AS name, product_price AS price, product_piece AS piece FROM products";
        resultSet = statement.executeQuery(allTable);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println(resultSetMetaData.getColumnName(1) + " \t\t\t| " + resultSetMetaData.getColumnName(2)
                + " \t\t\t| " + resultSetMetaData.getColumnName(3) + " \t\t\t| " + resultSetMetaData.getColumnName(4));
        System.out.println("=============================================================");
        while (resultSet.next()){

            int productId = resultSet.getInt("id");
            String productName = resultSet.getString("name");
            int productPrice = resultSet.getInt("price");
            int productPiece = resultSet.getInt("piece");

            System.out.println(productId + " \t\t| "+ productName + " \t\t\t| " + productPrice + " \t\t\t\t| " + productPiece);
        }
        connection.close();
    }

    @And("print market table with product names to uppercase")
    public void printMarketTableWithProductNamesToUppercase() throws SQLException {
       String sqlCode =  "SELECT product_id, UPPER (product_name) AS product_name, product_price, product_piece FROM products";
        ReUsableMethods.getTable(sqlCode);
    }

    @And("print market table with product names to lowercase")
    public void printMarketTableWithProductNamesToLowercase() throws SQLException {
        String sqlCode = "SELECT product_id, LOWER (product_name) AS product_name, product_price, product_piece FROM products";
        ReUsableMethods.getTable(sqlCode);
    }

    @And("print market table with first letter of product names to uppercase")
    public void printMarketTableWithFirstLetterOfProductNamesToUppercase() throws SQLException {
        String sqlCode = "SELECT product_id, INITCAP (product_name) AS product_name, product_price, product_piece FROM products";
        ReUsableMethods.getTable(sqlCode);
    }

    @And("print market table with sort products below a certain price by name and price in descending order")
    public void printMarketTableWithSortProductsBelowACertainPriceByNameAndPriceInDescendingOrder() throws SQLException {
        String sqlCode = "SELECT * FROM products WHERE product_price<20 ORDER BY product_name ASC";
        ReUsableMethods.getTable(sqlCode);
    }
}
