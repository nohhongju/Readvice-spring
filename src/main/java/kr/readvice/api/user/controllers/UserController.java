package kr.readvice.api.user.controllers;

import io.swagger.annotations.*;
import kr.readvice.api.auth.domains.Messenger;
import kr.readvice.api.user.domains.User;
import kr.readvice.api.user.domains.UserDTO;
import kr.readvice.api.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", allowedHeaders = "*") // * - 전부 허용한다, 상대방의 출처정의 (나의 부모 자식도 아닌 그래서 크로스 관계가 된다)
@Api(tags = "users") // 외부에서 user만 허용한다.
@RestController // 빈 컴포넌트(프로퍼티와 메소드를 갔는다.)
@RequestMapping("/users") // url
@RequiredArgsConstructor // 서비스(부모)랑 컨트롤러(자식)랑 연결
public class UserController {

    private final UserService service;
    private final ModelMapper modelMapper;

    @PostMapping("/login")
    @ApiOperation(value ="${UserController.login")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something Wrong"),
            @ApiResponse(code = 422, message = "유효하지 않은 아이디 / 비밀번호")
    })
    public ResponseEntity<UserDTO> login(@ApiParam("Login User") @RequestBody UserDTO user) {
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
    @PutMapping("/update")
    public ResponseEntity<Messenger> update(@RequestBody User user) {
        return ResponseEntity.ok(service.update(user));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> delete(@RequestBody User user) {
        return ResponseEntity.ok(service.delete(user));
    }
    @PostMapping("/join")
    @ApiOperation(value = "${UserController.join}")
    @ApiResponses(value = {
            @ApiResponse(code=400, message = "Something Wrong"),
            @ApiResponse(code=403, message = "승인거절"),
            @ApiResponse(code=422, message = "중복된 ID")})
    public ResponseEntity<Messenger> save(@ApiParam("Join User") @RequestBody UserDTO user) {
        System.out.println("회원가입 정보: "+user.toString()); // 원래는 찍으면 안된다 보안요소에서는 어느곳에서도
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
