package org.example.service;

import org.example.model.User;
import org.example.view.Messages;

public class UserService {
    public User createUser(Integer id, String name){
        return new User(id,name);
    }
    public void changeBalance(User user, int amount){
        user.changeBalance(amount);
        Messages.ShowOperation(amount);
    }
}
