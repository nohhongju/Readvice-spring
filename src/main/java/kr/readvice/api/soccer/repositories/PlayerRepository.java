package kr.readvice.api.soccer.repositories;

import kr.readvice.api.soccer.domains.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
interface PlayerCustomRepository{
    // 000. 선수들의 키와 몸무게를 변경하시오.
    @Query(value = "update player p set p.height = :height, p.weight :weight where p.playerNo", nativeQuery = true)
    int update(@Param("height") String height, @Param("weight") String weight);
}
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
