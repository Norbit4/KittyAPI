package pl.norbit.kittyapi.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.norbit.kittyapi.CatObject;

public interface CatRepo extends MongoRepository<CatObject, String> {

}
