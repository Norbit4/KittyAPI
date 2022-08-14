package pl.norbit.kittyapi.files;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadUtil {
    private static final Path uploadDir = Paths.get(System.getProperty("user.dir") + "/images");

    @Bean
    CommandLineRunner createDir(){
        return args -> {
            try {
                Files.createDirectories(uploadDir);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static String saveFile(String fileCode, MultipartFile multipartFile){

        try {
            InputStream inputStream = multipartFile.getInputStream();
            Path path = uploadDir.resolve(fileCode);
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
