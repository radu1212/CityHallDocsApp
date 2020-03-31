package service;

import entity.User;
import repository.UserRepo;

import java.util.List;

public class UserService {

    private static UserRepo userRepo;

    public UserService() {
        userRepo = new UserRepo();
    }

    public static Boolean addValidatedUserToDB(String username, String email, String password){
        if (userRepo.getUserByUsername(username) != null) return Boolean.FALSE;
        else {
            userRepo.insertNewUser(username, email, password);
            return Boolean.TRUE;
        }
    }

    public static Boolean checkLoginCredentials(String username, String password){
        if (userRepo.getUserByUsername(username) == null) return Boolean.FALSE;
        if (userRepo.getUserByUsername(username).getPassword().equals(password)) return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    public static List<User> getAllUsers(){return userRepo.getUsers();}

    public UserRepo getUserRepo() {
        return userRepo;
    }
}
