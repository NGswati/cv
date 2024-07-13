import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;
public class lab6q2 {
    public static void main(String[] args)throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute", "root", "admin123");
            stmt = conn.createStatement();

            System.out.print("Enter student id: ");
            int snum = Integer.parseInt(System.console().readLine());

            String query = "SELECT * FROM Student1 WHERE snum = " + snum;
            rs = stmt.executeQuery(query);
            if (!rs.next()) {
                System.out.println("Error: student id not found");
            } else {
                String sname = rs.getString("sname");
                String major = rs.getString("major");
                String level = rs.getString("standing");
                int age = rs.getInt("age");
                System.out.println("Student info:");
                System.out.println("\tID/snum: " + snum);
                System.out.println("\tName: " + sname);
                System.out.println("\tMajor: " + major);
                System.out.println("\tLevel: " + level);
                System.out.println("\tAge: " + age);
                System.out.println();

                query = "SELECT * FROM Enrolled WHERE snum = " + snum;
                rs = stmt.executeQuery(query);
                if (!rs.next()) {
                    System.out.println("This student has not enrolled for any classes.");
                    System.out.println();
                    query = "SELECT name FROM Class";
                    rs = stmt.executeQuery(query);
                    System.out.println("Available classes:");
                    while (rs.next()) {
                        System.out.println("\t"+rs.getString("name"));
                    }
                    System.out.print("Enter a class name to enroll: ");
                    String cname = System.console().readLine();
                    query = "INSERT INTO NewEnrolled VALUES (" + snum + ", '" + cname + "')";
                    int result = stmt.executeUpdate(query);
                    System.out.println("Enrolled " + sname + " in " + cname);
                } else {
                    System.out.println("Classes enrolled:");
                    do {
                        String cname = rs.getString("cname");
                        System.out.println("\t"+cname);
                    } while (rs.next());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

