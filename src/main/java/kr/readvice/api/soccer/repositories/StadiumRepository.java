package kr.readvice.api.soccer.repositories;

import kr.readvice.api.soccer.domains.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface StadiumCustomRepository{
    // 000. 스타디움 전화번호 tel 을 변경하도록 하시오.
}
@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}
