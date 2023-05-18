package az.ijob.jobposting.repository;

import az.ijob.jobposting.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Long, Vacancy>{
}
