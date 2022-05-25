package kr.readvice.api.user.controllers;

import kr.readvice.api.auth.domains.Messenger;
import kr.readvice.api.user.domains.User;
import kr.readvice.api.user.domains.UserDTO;
import kr.readvice.api.user.repositories.UserRepository;
import kr.readvice.api.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController // 빈 컴포넌트(프로퍼티와 메소드를 갔는다.)
@RequestMapping("/users") // url
@RequiredArgsConstructor // 서비스(부모)랑 컨트롤러(자식)랑 연결
public class UserController {

    private final UserService service;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody User user){ // ResponseEntity(반납할 때)로 완전히 감싸서 보낸다.
        return ResponseEntity.ok(service.login(user));
    }
    @GetMapping("/logout")
    public ResponseEntity<Messenger> logout(){
        return ResponseEntity.ok(service.logout());
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/findAll/sort")
    public ResponseEntity<List<User>> findAll(Sort sort) {
        return ResponseEntity.ok(service.findAll(sort));
    }
    @GetMapping("/findAll/pageable")
    public ResponseEntity<Page<User>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }
    @GetMapping("/count")
    public ResponseEntity<Messenger> count() {
        return ResponseEntity.ok(service.count());
    }
    @PutMapping("/put")
    public ResponseEntity<Messenger> update(@RequestBody User user) {
        return ResponseEntity.ok(service.update(user));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> delete(@RequestBody User user) {
        return ResponseEntity.ok(service.delete(user));
    }
    @PostMapping("/join")
    public ResponseEntity<Messenger> save(@RequestBody User user) {
        return ResponseEntity.ok(service.save(user));
    }
    @GetMapping("/findById/{userid}")
    public Optional<User> findById(@PathVariable String userid) {
        return service.findById(userid);
    }
    @GetMapping("/existsById/{userid}")
    public Messenger existsById(@PathVariable String userid) {
        return service.existsById(userid);
    }

}
