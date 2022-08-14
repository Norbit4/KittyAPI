package pl.norbit.kittyapi;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class CatObject {

    @Id
    private String id;
    private String breed;
    private String description;
    private String imgLink;
    private String imgId;
}
