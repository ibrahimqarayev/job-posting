package az.ijob.jobposting.repository;

import az.ijob.jobposting.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface JobRepository extends JpaRepository<Job, Long> {


}
