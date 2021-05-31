package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class studentDAO {
        private  static String url = "jdbc:mysql://localhost:3306/studentmanagement";
        private  static String user = "root";
        private  static String password = "Toilaai123!";

    public studentDAO() {
    }

    private final  static String   SELECT_ALL_USERS = "select * from student";



        public      Connection getConnection(String url,String user,String password) throws SQLException {
            Connection connection = null;
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connect successfully!");
            return  connection;
        }




        public  List<Student> selectAllStudent() throws SQLException {
            List<Student> studentList = new ArrayList<>();
            Connection connection = getConnection(url,user,password);
            Statement statement = connection.createStatement();
            System.out.println(statement);
            ResultSet  resultSet= statement.executeQuery(SELECT_ALL_USERS);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String name = resultSet.getString("fullname");
                String address = resultSet.getString("address");

                studentList.add(new Student(id,age,name,address));
            }
            return  studentList;
        }
}
