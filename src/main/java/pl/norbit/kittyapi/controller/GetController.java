package pl.norbit.kittyapi.controller;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pl.norbit.kittyapi.CatObject;
import pl.norbit.kittyapi.files.FileDownloadUtil;
import pl.norbit.kittyapi.service.CatService;

import java.io.IOException;
import java.util.List;


@RestController @AllArgsConstructor @CrossOrigin
@RequestMapping(path = "api/cat")
public class GetController {

    private final CatService catService;

    @GetMapping(path = "all")
    public List<CatObject> getCats(){

        return catService.getAll();
    }

    @GetMapping(path = "random")
    public CatObject getRandomCat(){

        return catService.getRandomCat();
    }

    @GetMapping(path = "downloadfile/{filecode}")
    public ResponseEntity<?> downloadFile(@PathVariable("filecode")String fileCode){
        Resource file;

        FileDownloadUtil downloadUtil = new FileDownloadUtil();

        try {
            file = downloadUtil.getFile(fileCode);

        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }

        if(file == null){
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }
        String headerValue = "attachment; filename=/" + file.getFilename() +"/";

        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                    .body(new InputStreamResource(file.getInputStream()));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @SneakyThrows @ResponseBody
    @GetMapping (path = "getfile/{filecode}")
    public HttpEntity<byte[]> img(@PathVariable ("filecode")String fileCode){

        Resource file;

        FileDownloadUtil downloadUtil = new FileDownloadUtil();

        try {
            file = downloadUtil.getFile(fileCode);

        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }

        if(file == null){
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(file.contentLength());

        return new HttpEntity<>(file.getInputStream().readAllBytes(), headers);
    }
}
