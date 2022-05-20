package kr.readvice.api.soccer.repositories;

import kr.readvice.api.soccer.domains.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
interface ScheduleCustomRepository{
    // 000. 스케쥴 날짜만 수정이 되도록 하시오.
}
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
