package pl.norbit.kittyapi.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRemoveUtil {
    private static final Path downloadDir = Paths.get(System.getProperty("user.dir") + "/images");

    public static void remove(String fileCode) throws IOException {

        Files.list(downloadDir).forEach(file -> {
            if(file.getFileName().toString().equals(fileCode)){
                new File(file.toUri()).delete();
            }
        });
    }
}
