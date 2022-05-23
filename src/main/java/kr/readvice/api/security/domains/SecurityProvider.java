package kr.readvice.api.security.domains;

import kr.readvice.api.auth.domains.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.List;

@Log // cctv개념이다. 시큐리티는 log을 찍어놔야 한다.
@Component
@RequiredArgsConstructor
public class SecurityProvider implements AuthenticationProvider { //외부에서
    private final UserDetailsServiceImpl service;

    @Value("${security.jwt.token.security-key:secret-key}")
    private  String securityKey;

    @Value("${security.jwt.token.expiration-length:3600000}") // 컴파일없이
    private long validityInMs = 3600000; //1h

    @PostConstruct
    protected void init(){
        securityKey = Base64.getEncoder().encodeToString(securityKey.getBytes());
        log.info("securityKey: "+securityKey);
    }

    public String createToken(String username, List<Role> roles){
        return "";
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
