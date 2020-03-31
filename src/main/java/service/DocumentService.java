package service;

import entity.Document;
import repository.DocumentRepo;

import java.util.List;

public class DocumentService {

    private static DocumentRepo documentRepo = new DocumentRepo();

    public static List<Document> getDocuments(){
        if (!documentRepo.getDocuments().isEmpty()) return documentRepo.getDocuments();
        else {
            return null;
        }
    }
}
