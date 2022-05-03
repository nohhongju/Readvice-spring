package kr.readvice.api.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private String userid;
    private String password;
    private String email;
    private String name;
    private String phone;
    private String birth;
    private String address;
}
