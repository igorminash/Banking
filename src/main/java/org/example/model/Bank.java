package org.example.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<User> clients;

    public Bank() {
        readDatabase();
    }

    public int getSize(){
        return clients.size();
    }

    public void addUser(User user){
        clients.add(user);
    }

    public boolean userId(int id){
        return id < getSize();
    }
    public User getUserById(int id){
        return clients.get(id);
    }

    public void readDatabase(){
        clients = new ArrayList<User>();
        File file = new File("database.txt");
        if(!file.exists()){
            return;
        }
        try (BufferedReader hm = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = hm.readLine()) != null) {
                String[] param = line.split(";");
                addUser(new User(Integer.parseInt(param[0]),param[1],Integer.parseInt(param[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDataBase(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("database.txt",false);
            for(User user:clients){
                String userString = "" + user.getId() + ";" + user.getName() + ";" + user.getBalance()+ "\n";
                fileWriter.write(userString);
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUser(User user) {
        clients.remove(user);
    }
}
