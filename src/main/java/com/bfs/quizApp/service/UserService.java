package com.bfs.quizApp.service;

import com.bfs.quizApp.dao.UserDao;
import com.bfs.quizApp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                .orElse(null);
    }

    public List<User> getAllUsers(boolean isAdmin) {
        return userDao.getAllUsers().stream()
                .filter(a -> a.isAdmin() == isAdmin).collect(Collectors.toList());
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

    public void changeActiveStatus(String user_id, boolean is_active) {
        if(is_active){
            userDao.deactivateUser(user_id);
        } else {
            userDao.activateUser(user_id);
        }
    }
}
