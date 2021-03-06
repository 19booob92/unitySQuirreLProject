package demo.service.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

import demo.model.User;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepo extends MongoRepository<User, String> {

	List<User> findByName(@Param("name") String name);

}
