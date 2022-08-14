package pl.norbit.kittyapi.files;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownloadUtil {
    private Path foundFile;
    private static final Path downloadDir = Paths.get(System.getProperty("user.dir") + "/images");

    public Resource getFile(String fileCode) throws IOException {

        Files.list(downloadDir).forEach(file -> {

            if(file.getFileName().toString().equals(fileCode)){

                foundFile = file;
            }
        });

        if(foundFile != null){
            return new UrlResource(foundFile.toUri());
        }

        return null;
    }
}
