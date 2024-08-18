import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;

public class lab6q3 {

    public static void main(String[] args)throws Exception {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute", "root", "admin123");
            stmt = conn.createStatement();
            // String sql = "CREATE TABLE student_research (snum INTEGER NOT NULL,paper_id VARCHAR(30) NOT NULL,PRIMARY KEY (snum, paper_id))";
            // stmt.executeUpdate(sql);
            // System.out.println("Created table in given database...");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO student_research (snum,paper_id) VALUES (?,?)");
            // pstmt.setInt(1, 115987938 );
            // pstmt.setString(2, "codd1970");
            // pstmt.executeUpdate();
            // pstmt = conn.prepareStatement("INSERT INTO student_research (snum,paper_id) VALUES (?,?)");
            // pstmt.setInt(1, 1115987938);
            // pstmt.setString(2, "tods76chen");
            // pstmt.executeUpdate();
            // pstmt = conn.prepareStatement("INSERT INTO student_research (snum,paper_id) VALUES (?,?)");
            // pstmt.setInt(1, 320874981);
            // pstmt.setString(2, "cacm2019");
            // pstmt.executeUpdate();
            
            // System.out.println("Inserted tuples into table...\n");

            // sql = "CREATE TABLE paper " + "( paper_id varchar(30) not NULL  PRIMARY KEY, pdf LONGBLOB )";
            // stmt.executeUpdate(sql);
            
            // System.out.println("created table paper");
            // pstmt = conn.prepareStatement("INSERT INTO paper "+ "VALUES (?,?) ");
            // File pdfFile = new File("codd1970.pdf");
            // FileInputStream inputStream = new FileInputStream(pdfFile);
            // pstmt.setBinaryStream(2, inputStream, (int) pdfFile.length());
            // pstmt.setString(1, "codd1970");
            // pstmt.executeUpdate();

            pstmt = conn.prepareStatement("INSERT INTO paper  VALUES (?,?)");
            File pdfFile1 = new File("tods76chen.pdf");
            FileInputStream inputStream1 = new FileInputStream(pdfFile1);
            pstmt.setBinaryStream(2, inputStream1, (int) pdfFile1.length());
            pstmt.setString(1, "tods76chen");
            pstmt.executeUpdate();

            pstmt = conn.prepareStatement("INSERT INTO paper  VALUES (?,?)");
            File pdfFile2 = new File("cacm2019.pdf");
            FileInputStream inputStream2 = new FileInputStream(pdfFile2);
            pstmt.setBinaryStream(2, inputStream2, (int) pdfFile1.length());
            pstmt.setString(1, "cacm2019");
            pstmt.executeUpdate();
            

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            
            se.printStackTrace();
        } catch (Exception e) {
            
            e.printStackTrace();
        } finally {            
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            } 
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } 
        } 
        System.out.println("Goodbye!");
    }
}
    