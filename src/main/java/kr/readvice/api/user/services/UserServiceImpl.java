package kr.readvice.api.user.services;

import kr.readvice.api.auth.configs.AuthProvider;
import kr.readvice.api.auth.domains.Messenger;
import kr.readvice.api.auth.exception.SecurityRuntimeException;
import kr.readvice.api.user.domains.Role;
import kr.readvice.api.user.domains.User;
import kr.readvice.api.user.domains.UserDTO;
import kr.readvice.api.user.repositories.UserRepository;
import kr.readvice.api.common.dataStructure.Box;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kr.readvice.api.common.lambda.Lambda.longParse;
import static kr.readvice.api.common.lambda.Lambda.string;

@Service
@RequiredArgsConstructor // 레파지토리(부모)랑 서비스(자식)랑 연결
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final AuthProvider provider;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO login(User user) { // DB행 객체 user - 엔티티
        try {
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);// 같은 속성끼리 그대로 전달하는 것을 map
            User findUser = repository.findByUsername(user.getUsername()).orElse(null); //null허용
            String pw = repository.findByUsername(user.getUsername()).get().getPassword();
            boolean checkPassword = encoder.matches(user.getPassword(),pw);
            String username = user.getUsername();
            List<Role> roles = findUser.getRoles();
            String token = checkPassword ? provider.createToken(username, roles) : "Wrong Password";
            return userDTO; //
        }catch (Exception e){
            throw new SecurityRuntimeException("유효하지 않은 아이디/비밀번호", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Messenger count() {
        return Messenger.builder().message(string(repository.count())).build();
    }

    @Override
    public Messenger update(User user) {
        return Messenger.builder().build();
    }

    @Override
    public Messenger delete(User user) {
        repository.delete(user);
        return Messenger.builder().build();
    }

    @Override
    public Messenger save(User user) {
        String result = "";
        String tempId = user.getUsername();
        if (repository.findByUsername(tempId).isEmpty()){ // null이여야 넣을 수 있다. o == null ? true: false 원래 삼항으로 표현되지만 생략가능
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            repository.save(User.builder().password(encoder.encode(user.getPassword())).build());
            result = "SECCESs";
        }else {
            result = "FAIL";
        }
        return Messenger.builder().message(result).build();
    }

    @Override
    public Optional<User> findById(String userid) {
        return repository.findById(0L);
    }

    @Override
    public Messenger existsById(String userid) {
        return repository.existsById(longParse(userid))
                ? Messenger.builder().message("EXIST").build()
                : Messenger.builder().message("NOT_EXIST").build(); //userid 타입이 다름
    }

    @Override
    public List<User> findByUserName(String name) {
        List<User> ls = repository.findAll();
        Box<String, User> box = new Box<>();
        // box.findByUserName(ls, name)
        // ls.stream().filter()
        return null;
    }

    @Override
    public Messenger logout() {
        return null;
    }
}
