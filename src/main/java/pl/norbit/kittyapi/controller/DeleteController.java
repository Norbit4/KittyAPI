package pl.norbit.kittyapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.norbit.kittyapi.service.CatService;


@RestController @AllArgsConstructor
@RequestMapping(path = "api/cat")
public class DeleteController {

    private final CatService catService;

    @DeleteMapping(path = "delete/{filecode}")
    public ResponseEntity<?> deleteCat(@PathVariable("filecode")String fileCode){

        catService.removeCat(fileCode);

        return ResponseEntity.ok().build();
    }
}
