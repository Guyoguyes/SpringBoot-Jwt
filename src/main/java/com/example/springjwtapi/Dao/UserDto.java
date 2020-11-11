package com.example.springjwtapi.Dao;

import com.example.springjwtapi.exceptions.EtAuthException;
import com.example.springjwtapi.models.User;

public class UserDto implements UserDao{
    @Override
    public Integer createUser(String firstName, String lastName, String email, String password) throws EtAuthException {
        return null;
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
    public int getEmailCount(String email) {
        return 0;
    }
}
