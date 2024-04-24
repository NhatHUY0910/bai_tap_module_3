package org.example.demo;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectJDBC.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from student_management.TablePoint";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int pointID = rs.getInt("PointID");
                int courseID = rs.getInt("CourseID");
                int studentID = rs.getInt("StudentID");
                double studyPoint = rs.getDouble("StudyPoint");

                System.out.println("pointID: " + pointID + ", courseID: " + courseID + ", studentID: " + studentID + ", studyPoint: " + studyPoint);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void destroy() {
    }
}