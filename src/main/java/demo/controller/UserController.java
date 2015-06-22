package demo.controller;

import demo.dao.UserDao;
import demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright 2015 Timothy Schimandle.  All Rights Reserved.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserDao _userDao;

    @RequestMapping(value="/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            User user = new User(id);
            _userDao.delete(user);
        }
        catch(Exception ex) {
            return ex.getMessage();
        }
        return "User succesfully deleted!";
    }

    @RequestMapping(value="/get-by-email")
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        try {
            User user = _userDao.getByEmail(email);
            userId = String.valueOf(user.getId());
        }
        catch(Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    @RequestMapping(value="/save")
    @ResponseBody
    public String create(String email, String name) {
        try {
            User user = new User(email, name);
            User user1 = new User("test", "tester");
            User user2 = new User("tes2t", "tester2");
            _userDao.save(user);
            _userDao.save(user1);
            _userDao.save(user2);
        }
        catch(Exception ex) {
            return ex.getMessage();
        }
        return "User succesfully saved!";
    }

} // class UserController
