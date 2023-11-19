package msnafiahterbaik.testinterview.service;

import msnafiahterbaik.testinterview.model.UserModel;

import java.util.List;

public interface UserService {

    void By(String identityNumber);

    List<UserModel> findAll();

    UserModel Save(UserModel userModel);

    UserModel update (UserModel userModel);

    void delete(String id);




}
