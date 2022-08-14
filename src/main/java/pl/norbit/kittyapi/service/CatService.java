package pl.norbit.kittyapi.service;

import org.springframework.web.multipart.MultipartFile;
import pl.norbit.kittyapi.CatObject;

import java.util.List;

public interface CatService {

    CatObject getRandomCat();
    List<CatObject> getAll();
    CatObject addCat(CatObject cat, MultipartFile multipartFile);

    boolean removeCat(String id);
}
