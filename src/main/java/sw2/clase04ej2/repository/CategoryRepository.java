package sw2.clase04ej2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sw2.clase04ej2.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

