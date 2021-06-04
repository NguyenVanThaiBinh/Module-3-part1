package staffDAO;

import model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StaffDAO {
    public StaffDAO() {
    }
    private static String jdbcURL = "jdbc:mysql://localhost:3306/staff_manage";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "Toilaai123!";

    private static final String INSERT_USERS_SQL =
            "INSERT INTO `staff_manage`.`staff` (`groupby`, `name`, `dob`, `gender`, `phone`, `cmnd`, `email`, `address`)\n" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?);\n";

    private static final String SELECT_USER_BY_ID =
            "select id_staff, groupby,name,dob,gender,phone,cmnd,email,address from staff where id_staff =1;";
    private static final String SELECT_ALL_USERS = "select * from staff";
    private static final String DELETE_USERS_SQL = "delete from staff where id_staff = ?;";
    private static final String UPDATE_USERS_SQL =
            "update staff set groupby=? ,name = ?,dob= ?, gender =?, phone =?, cmnd =?, email =?,address=? where id_staff = ?;";

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

    public  List<Staff> selectAllUsers() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Staff> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id_staff");
                String groupby = rs.getString("groupby");
                String name = rs.getString("name");

                String gender = rs.getString("gender");
                int phone = rs.getInt("phone");

                users.add(new Staff(id,groupby, name, gender, phone));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        System.out.println("Load done!");
        return users;
    }

    public void insertUser(Staff user) {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (
                Connection connection = getConnection();
                //preparedStatement duoc dung de truy van nhanh hon
                // Sử dụng để thực hiện các  câu truy vấn SQL động hoặc có tham số
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getGroup());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getDob());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.setInt(5, user.getPhone());
            preparedStatement.setInt(6, user.getCmnd());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setString(8, user.getAddress());

            System.out.println(preparedStatement);
            //cuoi dong lenh la phai update lai
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        System.out.println("Insert Done!");
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
        System.out.println("Delete done!");
        return rowDeleted;
    }
    public   boolean updateUser(Staff user) {
        boolean rowUpdated = true;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getGroup());
            statement.setString(2, user.getName());
            statement.setString(3, user.getDob());
            statement.setString(4, user.getGender());
            statement.setInt(5, user.getPhone());
            statement.setInt(6, user.getCmnd());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getAddress());
            statement.setInt(9, user.getStaffID());
            System.out.println(statement);
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("update done!");
        return rowUpdated;
    }
    public  Staff selectUser(int id) {
        Staff user = null;
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

                String groupby = rs.getString("groupby");
                String name = rs.getString("name");
                String dob   = rs.getString("dob");
                String gender = rs.getString("gender");
                int phone = rs.getInt("phone");
                int cmnd = rs.getInt("cmnd");
                String email = rs.getString("email");
                String address = rs.getString("address");

                //luu vao doi tuong user
                user = new Staff(id,groupby ,name,dob, gender, phone,cmnd,email,address);
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return user;
    }

    private static final String SEARCH_USERS_SQL ="select * from staff where id_staff like  ? or name like  ? ;";
    public List<Staff> searchUsers(String keyword) throws SQLException {
        String keyWord = "%"+keyword+"%"; // cu phap cua mysql
        List<Staff> userList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_SQL);
        preparedStatement.setString(1, keyWord);
        preparedStatement.setString(2, keyWord);

        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id_staff");
            String groupby = rs.getString("groupby");
            String name = rs.getString("name");
            String dob   = rs.getString("dob");
            String gender = rs.getString("gender");
            int phone = rs.getInt("phone");
            int cmnd = rs.getInt("cmnd");
            String email = rs.getString("email");
            String address = rs.getString("address");

            //luu vao doi tuong user
            userList.add(new Staff(id,groupby ,name,dob, gender, phone,cmnd,email,address)) ;
        }
        return userList ;
    }




}
