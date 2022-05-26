package kr.readvice.api.user.domains;

import com.sun.istack.NotNull;
import kr.readvice.api.board.domains.Article;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter //보안때문에 안쓴다.
@Entity

@Table(name="users")
public class User {
    @Id @Column(name = "user_id")
    @GeneratedValue private long userId;
    @Column private @NotNull String username;
    @Column private @NotNull String password;
    @Column private @NotNull String name;
    @Column private @NotNull String email;
    @Column(name = "reg_date") @NotNull private String regDate;

    @OneToMany(mappedBy = "u")
    List<Article> a = new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER) //
    public List<Role> roles;
}
