package az.ijob.jobposting.repository;

import az.ijob.jobposting.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
