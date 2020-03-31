package service;

import entity.Document;
import entity.Request;
import entity.User;
import repository.DocumentRepo;
import repository.RequestRepo;

import java.util.List;

public class RequestService {
    private static RequestRepo requestRepo = new RequestRepo();

    public static List<Request> getRequests(User user){
        if (!requestRepo.getRequests(user).isEmpty()) return requestRepo.getRequests(user);
        else {
            return null;
        }
    }

    public static Boolean checkIfAnyRequests(User user){
        if (requestRepo.getRequests(user).isEmpty()) return Boolean.TRUE;
        else {
            return Boolean.FALSE;
        }
    }

}
