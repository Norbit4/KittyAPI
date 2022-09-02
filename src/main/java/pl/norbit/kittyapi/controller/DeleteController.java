package pl.norbit.kittyapi.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.norbit.kittyapi.service.CatService;


@RestController @AllArgsConstructor @Log
@RequestMapping(path = "api/cat")
public class DeleteController {
    private final CatService catService;

    @DeleteMapping(path = "delete/{filecode}")
    public ResponseEntity<?> deleteCat(@PathVariable("filecode")String fileCode){
        boolean exited = catService.removeCat(fileCode);
        log.info(String.valueOf(exited));

        if(exited) return ResponseEntity.accepted().body("OK");

        return ResponseEntity.ok().body("NOT_FOUND");
    }
}
