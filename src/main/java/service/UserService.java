package service;

import Model.User;
import dbConnection.DBConnection;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserService {

    public boolean insertUser(User user) {

        boolean flag = false;

        String query = "insert into user(username, email, address, password)" + "values(?,?,?,?)";

        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        int res = 0;
        try {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getPassword());
            res = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return (res > 0) ? true : false;
    }

    public User loginCheck(String username, String password){

        User user=null;
        ResultSet rs=null;

        String query = "select * from user where username=? and password=?";

        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try{
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPassword(rs.getString("password"));
            }

        }
        catch (SQLException e){

        }
        return user;

    }
    public void deleteUser(int id){

        String query = "delete from user where id = ?";

        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try{
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }
        catch(SQLException e){
            e.printStackTrace();

        }


    }
}
