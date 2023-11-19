package msnafiahterbaik.testinterview.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import msnafiahterbaik.testinterview.model.UserModel;
import msnafiahterbaik.testinterview.repository.UserModelRepository;
import msnafiahterbaik.testinterview.service.UserService;
import msnafiahterbaik.testinterview.service.UserServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

class UserControllerTest {

    @Test
    void testFindAll() {

        UserModelRepository userModelRepository = mock(UserModelRepository.class);
        when(userModelRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<List<UserModel>> actualFindAllResult = (new UserController(new UserServiceImpl(userModelRepository)))
                .findAll();
        assertTrue(actualFindAllResult.hasBody());
        assertEquals(200, actualFindAllResult.getStatusCodeValue());
        assertTrue(actualFindAllResult.getHeaders().isEmpty());
        verify(userModelRepository).findAll();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testFindAll2() {

        (new UserController(null)).findAll();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testSave() {

        UserController userController = new UserController(new UserServiceImpl(mock(UserModelRepository.class)));

        UserModel request = new UserModel();
        request.setAccountNumber(3);
        request.setEmailAddress("42 Main St");
        request.setId("42");
        request.setIdentityNumber("42");
        request.setUsername("janedoe");
        userController.save(request);
    }

    @Test
    void testSave2() {


        UserModel userModel = new UserModel();
        userModel.setAccountNumber(3);
        userModel.setEmailAddress("42 Main St");
        userModel.setId("42");
        userModel.setIdentityNumber("42");
        userModel.setUsername("janedoe");
        UserServiceImpl userService = mock(UserServiceImpl.class);
        when(userService.Save(Mockito.<UserModel>any())).thenReturn(userModel);
        UserController userController = new UserController(userService);

        UserModel request = new UserModel();
        request.setAccountNumber(3);
        request.setEmailAddress("42 Main St");
        request.setId("42");
        request.setIdentityNumber("42");
        request.setUsername("janedoe");
        ResponseEntity<UserModel> actualSaveResult = userController.save(request);
        assertEquals(request, actualSaveResult.getBody());
        assertTrue(actualSaveResult.getHeaders().isEmpty());
        assertEquals(200, actualSaveResult.getStatusCodeValue());
        verify(userService).Save(Mockito.<UserModel>any());
    }

    /**
     * Method under test: {@link UserController#update(UserModel)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate() {


        UserModel userModel = new UserModel();
        userModel.setAccountNumber(3);
        userModel.setEmailAddress("42 Main St");
        userModel.setId("42");
        userModel.setIdentityNumber("42");
        userModel.setUsername("janedoe");
        UserModelRepository userModelRepository = mock(UserModelRepository.class);
        when(userModelRepository.findById(Mockito.<String>any())).thenReturn(Optional.of(userModel));
        UserController userController = new UserController(new UserServiceImpl(userModelRepository));

        UserModel request = new UserModel();
        request.setAccountNumber(3);
        request.setEmailAddress("42 Main St");
        request.setId("42");
        request.setIdentityNumber("42");
        request.setUsername("janedoe");
        userController.update(request);
    }

    @Test
    void testUpdate2() {

        UserModel userModel = new UserModel();
        userModel.setAccountNumber(3);
        userModel.setEmailAddress("42 Main St");
        userModel.setId("42");
        userModel.setIdentityNumber("42");
        userModel.setUsername("janedoe");
        UserService userService = mock(UserService.class);
        when(userService.update(Mockito.<UserModel>any())).thenReturn(userModel);
        UserController userController = new UserController(userService);

        UserModel request = new UserModel();
        request.setAccountNumber(3);
        request.setEmailAddress("42 Main St");
        request.setId("42");
        request.setIdentityNumber("42");
        request.setUsername("janedoe");
        ResponseEntity<UserModel> actualUpdateResult = userController.update(request);
        assertEquals(request, actualUpdateResult.getBody());
        assertTrue(actualUpdateResult.getHeaders().isEmpty());
        assertEquals(200, actualUpdateResult.getStatusCodeValue());
        verify(userService).update(Mockito.<UserModel>any());
    }

    @Test
    void testDelete() {

        UserModelRepository userModelRepository = mock(UserModelRepository.class);
        doNothing().when(userModelRepository).deleteById(Mockito.<String>any());
        ResponseEntity<Void> actualDeleteResult = (new UserController(new UserServiceImpl(userModelRepository)))
                .delete("42");
        assertNull(actualDeleteResult.getBody());
        assertEquals(200, actualDeleteResult.getStatusCodeValue());
        assertTrue(actualDeleteResult.getHeaders().isEmpty());
        verify(userModelRepository).deleteById(Mockito.<String>any());
    }


    @Test
    @Disabled("TODO: Complete this test")
    void testDelete2() {

        (new UserController(null)).delete("42");
    }
}

