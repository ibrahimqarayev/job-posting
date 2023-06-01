package az.ijob.jobposting.repository;

import az.ijob.jobposting.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByPositionAndCategoryAndCity(String position, String category, String city);

    List<Job> findByPositionAndCategory(String position, String category);

    List<Job> findByPositionAndCity(String position, String city);

    List<Job> findByCategoryAndCity(String category, String city);

    List<Job> findByCategory(String category);

    List<Job> findByCity(String city);
}
