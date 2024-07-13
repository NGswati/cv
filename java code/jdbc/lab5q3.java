import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

public class lab5q3 {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute", "root", "admin123");
            statement = connection.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the name of the course: ");
            String course = sc.nextLine();

            String query = "select room,meets_at from class where name = ? ";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, course);

            ResultSet rs = pstmt.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();

            int columnCount = metaData.getColumnCount();

            for (int k = 1; k <= columnCount; k++) {
                String columnName = metaData.getColumnName(k);
                System.out.print(columnName + "    ");

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
