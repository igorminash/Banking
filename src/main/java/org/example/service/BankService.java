package org.example.service;

import org.example.model.Bank;
import org.example.model.User;
import org.example.view.Messages;

public class BankService {
    private Bank bank;
    private UserService userService;

    public BankService() {
        bank = new Bank();
        userService = new UserService();
    }
    public void saveDataBase(){
        bank.saveDataBase();
    }

    public boolean userId(int id){
        return bank.userId(id);
    }
    public User getUserById(int id){
        if (userId(id)){
            return bank.getUserById(id);
        }
        return null;
    }

    public int getNewUserId(){
        return bank.getSize();
    }
    public User addUser(String name) {
        User newUser = userService.createUser(bank.getSize(), name);
        bank.addUser(newUser);
        return newUser;
    }
    public User registerUser(){
        String newUserName = Console.AskString("Введите имя пользователя:");
        if(newUserName.isEmpty()) {
            Messages.wrongName("Имя не может быть пустым");
            return null;
        }
        return addUser(newUserName);
    }

    public int getBalance(User user){
        return user.getBalance();
    }
    public void deposit(User user, int summa){
        userService.changeBalance(user, summa);
    }
    public void withdraw(User user, int summa){
        if(getBalance(user) < summa){
            Messages.SayNoMoney();
        }
        else {
            userService.changeBalance(user, -summa);
        }

    }

    public void deleteUser(User user) {
        bank.removeUser(user);
    }
}
