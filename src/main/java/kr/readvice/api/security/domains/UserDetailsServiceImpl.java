package kr.readvice.api.security.domains;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class UserDetailsServiceImpl {
    private String message, code;
    private int status;
}
