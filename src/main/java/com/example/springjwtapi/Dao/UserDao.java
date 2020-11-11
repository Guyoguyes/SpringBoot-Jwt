package com.example.springjwtapi.Dao;

import com.example.springjwtapi.exceptions.EtAuthException;
import com.example.springjwtapi.models.User;

public interface UserDao {

    Integer createUser(String firstName, String lastName, String email, String password) throws EtAuthException;

    User FindByEmailAndPassword(String email, String password) throws EtAuthException;

    User findById(Integer userId);


    Integer getEmailCount(String email);
}
