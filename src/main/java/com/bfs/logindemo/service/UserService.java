package com.bfs.logindemo.service;

import com.bfs.logindemo.dao.UserDao;
import com.bfs.logindemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) { this.userDao = userDao; }

//    public void createNewUser(User user) {
//        userDao.createNewUser(user);
//    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(int id) {
        return userDao.getAllUsers().stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(new User(-1, "invalid username", "invalid password",
                        "firstName", "lastname"));
    }

    public Optional<User> validateLogin(String username, String password) {
        // check if a user with the given username and password exists
        return userDao.getAllUsers().stream()
                .filter(a -> a.getEmail().equals(username)
                        && a.getPassword().equals(password))
                .findAny();
    }


    public void createNewUser(String email, String password, String firstName, String lastName) {
        userDao.createNewUser(email, password, firstName, lastName);
    }
}
