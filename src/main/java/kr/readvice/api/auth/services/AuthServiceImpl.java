package kr.readvice.api.auth.services;

import kr.readvice.api.user.domains.User;
import kr.readvice.api.user.repositories.UserRepository;
import kr.readvice.api.auth.domains.Auth;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor //중간에 끼여있는 거라서
public class AuthServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException(username+"에 해당하는 객체가 존재하지 않습니다."));
        return Auth.build(user.get());
    }
}
