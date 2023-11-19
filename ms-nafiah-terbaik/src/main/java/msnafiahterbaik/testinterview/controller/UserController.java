package msnafiahterbaik.testinterview.controller;

import lombok.AllArgsConstructor;
import msnafiahterbaik.testinterview.model.UserModel;
import msnafiahterbaik.testinterview.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity<List<UserModel>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<UserModel> save(@RequestBody UserModel request){
        return ResponseEntity.ok(userService.Save(request));
    }

    @PutMapping("/update")
    public ResponseEntity<UserModel> update(@RequestBody UserModel request){
        return ResponseEntity.ok(userService.update(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void>delete(@RequestParam String id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
