package msnafiahterbaik.testinterview.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "users")

public class UserModel {


        @Id
        private String id;
        private String username;
        private int accountNumber;
        private String emailAddress;
        private String identityNumber;

    }

