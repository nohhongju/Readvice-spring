package kr.readvice.api.auth.repositories;

import kr.readvice.api.auth.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface UserCustomRepository{
    // 000. 사용자의 비밀번호와 이메일를 수정하시오.
    String login(User user);
     void update(User user);
}
@Repository
public interface UserRepository extends JpaRepository<User, Long>{


}
