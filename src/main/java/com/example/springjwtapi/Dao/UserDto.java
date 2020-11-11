package com.example.springjwtapi.Dao;

import com.example.springjwtapi.exceptions.EtAuthException;
import com.example.springjwtapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UserDto implements UserDao{

    //Sql statement
    private static final String SQL_CREATE = "INSERT INTO et_users (user_id, first_name, last_name, email, password) VALUES (NEXTVAL('et_users_seq'), ?, ?, ?, ?)";
    private static final String SQL_COUNT_EMAIL =  "SELECT COUNT(*) FROM et_users WHERE email = ?";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM et_users WHERE user_id = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer createUser(String firstName, String lastName, String email, String password) throws EtAuthException {
        try {
            KeyHolder keyHolder  = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement statement = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, firstName);
                statement.setString(2,  lastName);
                statement.setString(3, email);
                statement.setString(4, password);
                return statement;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("user_id");
        }catch(Exception e){
            throw new EtAuthException("Failed to register user");
        }
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public User FindByEmailAndPassword(String email, String password) throws EtAuthException {
        return null;
    }

    @Override
    public Integer getEmailCount(String email) {
        return 0;
    }
}
