package kr.readvice.api.auth.domains;
import lombok.Builder;
import lombok.Getter;
@Getter @Builder
public class Messenger {
    private String message, code, token;
    private int status;
}