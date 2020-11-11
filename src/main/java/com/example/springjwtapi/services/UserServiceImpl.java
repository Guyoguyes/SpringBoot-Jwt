package com.example.springjwtapi.services;

import com.example.springjwtapi.Dao.UserDto;
import com.example.springjwtapi.exceptions.EtAuthException;
import com.example.springjwtapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDto userDto;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        return null;
    }

    @Override
    public User registerUser(String firstName, String lastname, String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) email = email.toLowerCase();
        if(!pattern.matcher(email).matches()) throw new EtAuthException("Invalid email Format");

        Integer count = userDto.getEmailCount(email);
        if(count > 0) throw new EtAuthException("Email already exist");

        Integer userId = userDto.createUser(firstName, lastname, email, password);
        return userDto.findById(userId);
    }
}
