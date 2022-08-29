package pl.norbit.kittyapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.norbit.kittyapi.CatObject;
import pl.norbit.kittyapi.files.FileRemoveUtil;
import pl.norbit.kittyapi.repo.CatRepo;
import pl.norbit.kittyapi.files.FileUploadUtil;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@AllArgsConstructor @Service
public class CatServiceImp implements CatService{
    private final static String API_PATH = "https://kittyapi.herokuapp.com/api/cat/getfile/";
    private final CatRepo catRepo;

    public List<CatObject> getAll(){
        return catRepo.findAll();
    }

    @Override
    public CatObject addCat(CatObject cat, MultipartFile multipartFile) {

        UUID uuid = UUID.randomUUID();

        String fileApiPath = API_PATH + uuid;

        cat.setImgLink(fileApiPath);
        cat.setImgId(uuid.toString());

        FileUploadUtil.saveFile(uuid.toString(), multipartFile);
        catRepo.insert(cat);

        return cat;
    }

    @Override
    public boolean removeCat(String id) {

        Optional<CatObject> byId = catRepo.findById(id);

        if(byId.isPresent()){
            String imgID = byId.get().getImgId();

            try {
                FileRemoveUtil.remove(imgID);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            catRepo.deleteById(id);
        }

        return false;
    }

    public CatObject getRandomCat(){

        Random random = new Random();
        List<CatObject> all = catRepo.findAll();

        int rInt = random.nextInt(all.size());

        return all.get(rInt);
    }
}

