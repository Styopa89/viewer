package com.vstepura.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


public class ServiseLayer extends HttpServlet {
        private static final String DB_DRIVER = "org.h2.Driver";
        private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
        private static final String DB_USER = "";
        private static final String DB_PASSWORD = "";
        private Statement stmt = null;
        private ResultSet rs = null;
        private Connection connection = null;

    public ServiseLayer() throws SQLException {
       connection = getDBConnection();
    }

    public void addPerson(Person p) throws SQLException {
        try {
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String sex = request.getParameter("sex");
        String sqlQuery = "INSERT INTO  infotable (name, lastName, sex) "
                + "VALUES ('"+ firstName+"','"+ lastName+"','"+ sex+"')";

        connection = getDBConnection();
        sqlExecute(connection, sqlQuery);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/hello.jsp");
        dispatcher.forward(request, response);

    }

    public String getServletInfo() {
        return "H2 - h2_viewer";
    }

    private void sqlExecute(Connection connection, String sql) {
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {

        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }


    public void createTable() throws SQLException {
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
//            stmt.execute("CREATE TABLE PERSON(id int primary key, firstname varchar(255))");
            stmt.execute("CREATE TABLE PERSON(id int primary key, firstname varchar(50), secondname varchar(50), sex varchar(50))");
            stmt.execute("INSERT INTO PERSON(id, firstname, secondname, sex) VALUES(1, 'Anju', 'Anju', 'Anju')");
            stmt.execute("INSERT INTO PERSON(id, firstname, secondname, sex) VALUES(2, 'Sonia', 'Anju', 'Anju')");
            stmt.execute("INSERT INTO PERSON(id, firstname, secondname, sex) VALUES(3, 'Asha', 'Anju', 'Anju')");

            ResultSet rs = stmt.executeQuery("select * from PERSON");
            System.out.println("H2 In-Memory Database inserted through Statement");
            while (rs.next()) {
                System.out.println("Id " + rs.getInt("id") + " Name " + rs.getString("firstname")
                        + " SecondName " + rs.getString("secondname") + " Sex " + rs.getString("sex"));
            }

            stmt.execute("DROP TABLE PERSON");
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    private static Connection getDBConnection() {
            Connection dbConnection = null;
            try {
                Class.forName(DB_DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            try {
                dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                return dbConnection;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return dbConnection;
        }

}
