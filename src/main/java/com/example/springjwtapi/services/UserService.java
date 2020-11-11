package com.example.springjwtapi.services;

import com.example.springjwtapi.exceptions.EtAuthException;
import com.example.springjwtapi.models.User;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastname, String email, String password) throws EtAuthException;
}
