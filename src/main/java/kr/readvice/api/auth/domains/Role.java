package kr.readvice.api.auth.domains;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.lang.reflect.Array;
import java.util.Arrays;

@Getter // 읽기만 가능하다.수정 불가능
@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    ADMIN("ROLE_ADMIN", "관리자권한"),
    USER("ROLE_USER", "사용자권한"),
    UNKNOWN_USER("ROLE_UNKNOWN_USER", "알수없는 사용자"),
    ;
    private final String code;
    private final String description;

    public static Role of(String code){
        return Arrays.stream(Role.values()).filter(i -> i.getCode().equals(code))
                .findAny().orElse(UNKNOWN_USER);
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
