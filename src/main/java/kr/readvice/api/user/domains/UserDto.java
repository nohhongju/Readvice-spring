package kr.readvice.api.user.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component @Data
public class UserDto {
    @ApiModelProperty(position = 1 ) private long userId;
    @ApiModelProperty(position = 2 ) String username;
    @ApiModelProperty(position = 3 ) String password;
    @ApiModelProperty(position = 4 ) String name;
    @ApiModelProperty(position = 5 ) String email;
    @ApiModelProperty(position = 6 ) private String regDate;
    @ApiModelProperty(position = 7 ) private String token;
    @ApiModelProperty(position = 8 ) private List<Role> roles;
}
