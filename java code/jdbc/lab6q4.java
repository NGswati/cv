// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.*;
// import java.sql.*;
// public class lab6q4 {

//     public static void main(String[] args) {
//         Connection conn = null;
//         Statement stmt = null;

//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute", "root", "admin123");
//             stmt = conn.createStatement();

//             String sql = "CREATE TABLE student_research " +
//                     "(snum INTEGER, " +
//                     " paper_id INTEGER, " +
//                     " FOREIGN KEY (snum) REFERENCES student(snum), " +
//                     " FOREIGN KEY (paper_id) REFERENCES paper(paper_id))";

//             stmt.executeUpdate(sql);

//             // Insert tuples into the student_research table
//             System.out.println("Inserting tuples into student_research...");
//             sql = "INSERT INTO student_research (snum, paper_id) VALUES " +
//                     "(1001, 1), " +
//                     "(1002, 2), " +
//                     "(1003, 1), " +
//                     "(1004, 3), " +
//                     "(1005, 4)";

//             stmt.executeUpdate(sql);

//             // Insert paper details into the paper table (if not already present)
//             System.out.println("Inserting papers into paper table...");
//             sql = "INSERT IGNORE INTO paper (paper_id, title, author, journal, year) VALUES " +
//                     "(1, 'A Study of Computer Networks', 'John Smith', 'IEEE Transactions on Networking', 2020), " +
//                     "(2, 'Artificial Intelligence and Machine Learning', 'Jane Doe', 'Journal of Artificial Intelligence Research', 2019), "
//                     +
//                     "(3, 'Advances in Data Science', 'Bob Johnson', 'Data Science Journal', 2021), " +
//                     "(4, 'Natural Language Processing Techniques', 'Alice Lee', 'ACL Anthology', 2020)";

//             stmt.executeUpdate(sql);

//             System.out.println("Records inserted successfully...");
//         } catch (SQLException se) {
//             // Handle errors for JDBC
//             se.printStackTrace();
//         } catch (Exception e) {
//             // Handle errors for Class.forName
//             e.printStackTrace();
//         } finally {
//             // Finally block to close resources
//             try {
//                 if (stmt != null)
//                     stmt.close();
//             } catch (SQLException se2) {
//             }
//             try {
//                 if (conn != null)
//                     conn.close();
//             } catch (SQLException se) {
//                 se.printStackTrace();
//             }
//         }
//     }
// }

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.*;

public class lab6q4{

    public static void main(String[] args) throws IOException, InterruptedException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute", "root", "admin123");

            Scanner sc = new Scanner(System.in);
            statement = connection.createStatement();
            System.out.println("enter the snum");
            BigInteger snum=sc.nextBigInteger();
            String query = "select paperid from student_research where snum=?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setObject(1, snum,java.sql.Types.BIGINT);
            ResultSet rs=pstmt.executeQuery();
        
            while(rs.next()){

                String paperid=rs.getString(1);
                
                String query1="SELECT actual FROM paper WHERE paperid = ?";
                PreparedStatement p1 = connection.prepareStatement(query1);
                p1.setString(1, paperid);
                ResultSet rs1 = p1.executeQuery();
                while(rs1.next()){
                    Blob blob = rs1.getBlob(1);

                    InputStream inputStream = blob.getBinaryStream();
                    System.out.println(paperid);
                    File tempFile = File.createTempFile("pdf_", ".pdf");
                    FileOutputStream outputStream = new FileOutputStream(tempFile);
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                
                    Process process = new ProcessBuilder("xdg-open", tempFile.getAbsolutePath()).start();
                    process.waitFor();

                    inputStream.close();
                    outputStream.close();
                }
            } 
        }

        catch (SQLException |NullPointerException| ClassNotFoundException e) {
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

// String insertPaperSql = "INSERT INTO papers (title, author, content) VALUES (?, ?, ?)";pstmt=conn.prepareStatement(insertPaperSql);
// File paper1File = new File("paper1.pdf");
// InputStream paper1Stream = new FileInputStream(
//         paper1File);pstmt.setString(1,"Paper 1");pstmt.setString(2,"John Doe");pstmt.setBinaryStream(3,paper1Stream,paper1File.length());pstmt.executeUpdate();paper1Stream.close();
// File paper2File = new File("paper2.pdf");
// InputStream paper2Stream = new FileInputStream(
//         paper2File);pstmt.setString(1,"Paper 2");pstmt.setString(2,"Jane Smith");pstmt.setBinaryStream(3,paper2Stream,paper2File.length());pstmt.executeUpdate();paper2Stream.close();

// // Retrieve all papers of a given student
// String retrieveSql = "SELECT papers.content FROM papers "
//         + "JOIN student_research ON papers.paper_id = student_research.paper_id "
//         + "WHERE student_research.snum = ?";pstmt=conn.prepareStatement(retrieveSql);pstmt.setLong(1,1234567890L);
// ResultSet rs = pstmt.executeQuery();while(rs.next())
// {
//                 InputStream contentStream = rs.getBinaryStream(1);