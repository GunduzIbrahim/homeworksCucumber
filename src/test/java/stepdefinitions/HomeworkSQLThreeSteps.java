package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.ConfigReader;
import utilities.ReUsableMethods;

import java.sql.*;

public class HomeworkSQLThreeSteps {
    String url = ConfigReader.getProperty("db_urlEmployees");
    String username = ConfigReader.getProperty("db_username");
    String password = ConfigReader.getProperty("db_password");

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @Given("user connects to the employees database")
    public void userConnectsToTheEmployeesDatabase() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    @When("user connects to the employees table")
    public void userConnectsToTheEmployeesTable() throws SQLException {
        String allTable = "SELECT * FROM employees";
        resultSet = statement.executeQuery(allTable);


    }

    @And("print employees table with even id's last digit")
    public void printEmployeesTableWithEvenIdSLastDigit() throws SQLException {
        String sqlQuery = "SELECT * FROM employees WHERE MOD(id,2)=0 ";
        resultSet = statement.executeQuery(sqlQuery);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println(resultSetMetaData.getColumnName(1) + " \t\t\t| " + resultSetMetaData.getColumnName(2)
                + " \t\t\t| " + resultSetMetaData.getColumnName(3) + " \t\t| " + resultSetMetaData.getColumnName(4)+ " \t| " + resultSetMetaData.getColumnName(5));
        System.out.println("===============================================================");
        while (resultSet.next()){

            int employeeId = resultSet.getInt("id");
            String employeeName = resultSet.getString("name");
            String employeeState = resultSet.getString("state");
            int employeeSalary = resultSet.getInt("salary");
            String employeeCompany = resultSet.getString("company");

            System.out.println(employeeId + " \t| "+ employeeName + " \t| " + employeeState + " \t\t| " + employeeSalary + " \t| " + employeeCompany);
        }
        connection.close();
    }

    @And("total number of rows of employees table is found")
    public void totalNumberOfRowsOfEmployeesTableIsFound() throws SQLException {
        String allTable = "SELECT * FROM employees";
        resultSet = statement.executeQuery(allTable);

        int numberOfRows=0;
        while (resultSet.next()){
            numberOfRows++;
        }
        System.out.println("\nTotal number of rows : "+numberOfRows);
    }

    @And("maximum salary is found")
    public void maximumSalaryIsFound() throws SQLException {
        String allTable = "SELECT * FROM employees";
        resultSet = statement.executeQuery(allTable);
        String maxSalary = "SELECT max(salary) AS \"Max Salary\" FROM employees";
        resultSet = statement.executeQuery(maxSalary);
        resultSet.first();

        int highestSalary = resultSet.getInt("Max Salary");

        System.out.println("\nMax Salary = " + highestSalary);
    }

    @And("second maximum salary is found")
    public void secondMaximumSalaryIsFound() throws SQLException {
        String allTable = "SELECT * FROM employees";
        resultSet = statement.executeQuery(allTable);
        String secondMaxSalary = "SELECT max(salary) AS \"Second Max Salary\" FROM employees WHERE salary< (SELECT max (salary) FROM employees) ";
        resultSet = statement.executeQuery(secondMaxSalary);
        resultSet.first();

        int secondHighestSalary = resultSet.getInt("Second Max Salary");

        System.out.println("\nSecond Max Salary = " + secondHighestSalary);
    }

    @And("all the information of the row with the maximum salary is found")
    public void allTheInformationOfTheRowWithTheMaximumSalaryIsFound() throws SQLException {
        String sqlCode = "SELECT * FROM employees";
        resultSet = statement.executeQuery(sqlCode);
        String infoMaxSalary = "SELECT * FROM employees WHERE salary = (SELECT max (salary) FROM employees) ";
        resultSet = statement.executeQuery(infoMaxSalary);
        while (resultSet.next()){

            int employeeId = resultSet.getInt("id");
            String employeeName = resultSet.getString("name");
            String employeeState = resultSet.getString("state");
            int employeeSalary = resultSet.getInt("salary");
            String employeeCompany = resultSet.getString("company");

            System.out.println(employeeId + " \t| "+ employeeName + " \t| " + employeeState + " \t\t| " + employeeSalary + " \t| " + employeeCompany);
        }
    }

    @And("all the information of the row with the second maximum salary is found")
    public void allTheInformationOfTheRowWithTheSecondMaximumSalaryIsFound() throws SQLException {
        String sqlCode = "SELECT * FROM employees";
        resultSet = statement.executeQuery(sqlCode);
        String infoSecondMaxSalary = "SELECT * FROM employees WHERE salary = (SELECT max (salary) FROM employees WHERE salary< (SELECT max (salary) FROM employees)) ";
        resultSet = statement.executeQuery(infoSecondMaxSalary);
        while (resultSet.next()){

            int employeeId = resultSet.getInt("id");
            String employeeName = resultSet.getString("name");
            String employeeState = resultSet.getString("state");
            int employeeSalary = resultSet.getInt("salary");
            String employeeCompany = resultSet.getString("company");

            System.out.println(employeeId + " \t| "+ employeeName + " \t| " + employeeState + " \t\t| " + employeeSalary + " \t| " + employeeCompany);
        }
    }


}
