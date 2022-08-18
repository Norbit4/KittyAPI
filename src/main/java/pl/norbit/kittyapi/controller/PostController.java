package pl.norbit.kittyapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.norbit.kittyapi.CatObject;
import pl.norbit.kittyapi.service.CatService;

@RestController @AllArgsConstructor
@RequestMapping(path = "api/cat")
public class PostController {

    private final CatService catService;

    @PostMapping("add")
    public ResponseEntity<CatObject> uploadCat(
            @RequestParam ("file") MultipartFile multipartFile,
            @Param("breed") String breed,
            @Param("desc") String desc ){

        CatObject cat = CatObject.builder()
                .breed(breed)
                .description(desc)
                .build();

        CatObject catObject = catService.addCat(cat, multipartFile);

        return new ResponseEntity<>(catObject, HttpStatus.ACCEPTED);
    }
}
