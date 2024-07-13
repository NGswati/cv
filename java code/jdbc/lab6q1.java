import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

public class lab6q1 {
    public static void main(String[] args) throws Exception {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute", "root", "admin123");

            Statement stmt = connection.createStatement();
            String sql;
            sql = "create table student1(snum int primary key,sname varchar(30),major varchar(30),standing varchar(2),age int);";
            stmt.executeUpdate(sql);
            
            for (int i = 0; i < 5; i++) {
                System.out.println("Enter student " + (i + 1) + " details:");
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the snum: ");
                int snum = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter the sname: ");
                String sname = sc.nextLine();
                System.out.print("Enter the major : ");
                String major = sc.nextLine();
                System.out.print("Enter the standing: ");
                String standing = sc.nextLine();
                System.out.print("Enter the age: ");
                int age = sc.nextInt();
                sc.nextLine();

                sql = "insert into student1 values(?,?,?,?,?);";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, snum);
                pstmt.setString(2, sname);
                pstmt.setString(3, major);
                pstmt.setString(4,standing);
                pstmt.setInt(5, age);
                pstmt.executeUpdate();
            }
            

            sql = "create table NewEnrolled(snum int ,cname varchar(40),primary key(snum,cname));";
            stmt.executeUpdate(sql);

            resultSet = stmt.executeQuery("show tables");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }

            stmt.close();
            connection.close();
            // System.out.println("Table created successfully");
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

// 051135593 Maria White English SR 21
// 060839453 Charles Harris  SR 22 
// 099354543 Susan Martin Law  JR 20 
// 112348546 Joseph Thompson Computer Science SO 19 
// 115987938 Christopher Garcia Computer Science JR 20
