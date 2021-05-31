package com.dao;

import com.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDAO  {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "Toilaai123!";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    public UserDAO() {
    }


    protected static Connection getConnection() {
        Connection connection = null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
            // nap chong phuong thuc
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("connect successfully!");
        } catch (SQLException e) {
            System.out.println("connect failure!");
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    private static final String SEARCH_USERS_SQL ="select * from users where country like  ? or name like  ? or email like ?;";
    public List<User> searchUsers(String keyword) throws SQLException {
        String keyWord = "%"+keyword+"%"; // cu phap cua mysql
        List<User> userList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_SQL);
        preparedStatement.setString(1, keyWord);
        preparedStatement.setString(2, keyWord);
        preparedStatement.setString(3, keyWord);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            userList.add(new User(id, name, email, country));
        }
        return userList ;
    }


    public void insertUser(User user) {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (
                Connection connection = getConnection();
                //preparedStatement duoc dung de truy van nhanh hon
                // Sử dụng để thực hiện các  câu truy vấn SQL động hoặc có tham số
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            //cuoi dong lenh la phai update lai
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }

    // đưa database vào một cái mảng List thôi
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        List<User> userList = userDAO.selectAllUsers();
        System.out.println(userList);
    }
    public  List<User> selectAllUsers() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return users;
    }


    public static List<User> testList(){
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return users;
    }
    private static final String SORT_USERS_SQL = "select * from users ORDER BY name";
    public List<User> sortByName() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User>userList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_SQL);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {

        }
        return userList;
    }



    public boolean deleteUser(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);)
        {
            statement.setInt(1, id);
            rowDeleted = true;
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }


    public   boolean updateUser(User user) {
        boolean rowUpdated = true;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }







    public  User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                //luu vao doi tuong user
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return user;
    }



}
