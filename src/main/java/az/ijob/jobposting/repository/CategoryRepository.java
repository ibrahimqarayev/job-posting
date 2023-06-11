package az.ijob.jobposting.repository;

import az.ijob.jobposting.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
