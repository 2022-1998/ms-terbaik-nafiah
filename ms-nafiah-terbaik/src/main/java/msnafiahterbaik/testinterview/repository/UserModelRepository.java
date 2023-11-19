package msnafiahterbaik.testinterview.repository;

import msnafiahterbaik.testinterview.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserModelRepository extends MongoRepository<UserModel, String> {
    UserModel findBy(String identityNumber);
}
