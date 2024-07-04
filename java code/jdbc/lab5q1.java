import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

public class lab5q1 {

    public static void main(String[] args) throws Exception {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute", "root", "admin123");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("show tables");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the table name: ");
            String tableName = sc.nextLine();

            String query = "SELECT * FROM " + tableName;
            PreparedStatement pstmt = connection.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();

            int columnCount = metaData.getColumnCount();

            for (int k = 1; k <= columnCount; k++) {
                String columnName = metaData.getColumnName(k);
                System.out.print(columnName + "       ");
            }
            System.out.println();
            while (rs.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    
                    Object columnData = rs.getObject(i);
                    
                    System.out.print(columnData + "   ");
                }
                System.out.println();

            }
        }

        catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error while connecting to database: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error while closing resources: " + e.getMessage());
            }
        }
    }
}