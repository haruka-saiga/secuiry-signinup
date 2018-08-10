package com.javasampleapproach.springsecurity.jdbcauthentication;

//import javax.swing.tree.RowMapper;
//import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

public class UsersMapper implements RowMapper<List<Users>> {
    public List<Users> mapRow(ResultSet rs, int rowNum)
            throws SQLException {
        List<Users> list = new ArrayList<>();
        Users tmp_users = new Users();
        tmp_users.setUsername(rs.getString("username"));
        tmp_users.setPassword(rs.getString("password"));
        list.add(tmp_users);

        while (rs.next()) {
            Users users = new Users();
            users.setUsername(rs.getString("username"));
            users.setPassword(rs.getString("password"));
            list.add(users);

        }
        return list;
    }


}