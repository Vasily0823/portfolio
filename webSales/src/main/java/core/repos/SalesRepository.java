package core.repos;

import core.domain.Sales;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SalesRepository extends CrudRepository<Sales, Integer> {
    List<Sales> findByTotalGreaterThan(Integer total);

}
