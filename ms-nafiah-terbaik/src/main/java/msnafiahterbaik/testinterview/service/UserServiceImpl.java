package msnafiahterbaik.testinterview.service;


import lombok.AllArgsConstructor;
import msnafiahterbaik.testinterview.model.UserModel;
import msnafiahterbaik.testinterview.repository.UserModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserModelRepository userModelRepository;
    @Override
    public UserModel Save(UserModel userModel) {
        validate (userModel);
        return userModelRepository.save(userModel);
    }
    public UserModel getUserByIdentityNumber(String identityNumber){
        return userModelRepository.findBy(identityNumber);
    }

    @Override
    public void By(String identityNumber) {

    }

    @Override
    public List<UserModel> findAll() {
        return userModelRepository.findAll();
    }

    private void validate(UserModel userModel) {
        if (userModel.getUsername() == null || userModel.getUsername().isEmpty()) {
            throw new IllegalArgumentException("identity is null");
        }

        if(userModel.getAccountNumber()<6){
            throw new IllegalArgumentException("account Number should be greater that five");
        }
    }

    @Override
    public UserModel update(UserModel userModel) {
        userModelRepository.findById(userModel.getId()).orElseThrow(() -> new IllegalArgumentException("model doesn't exist"));
        validate(userModel);
        return userModelRepository.save(userModel);
    }

    @Override
    public void delete(String id) {
        userModelRepository.deleteById(id);

    }
}
