package kr.readvice.api.board.repositories;

import kr.readvice.api.board.domains.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
interface BoardCustomRepository{
    // 000. 게시판 이름 boardName 을 변경하시오.
}
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
