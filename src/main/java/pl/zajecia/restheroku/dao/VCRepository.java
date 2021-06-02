package pl.zajecia.restheroku.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zajecia.restheroku.dao.entity.VideoCassette;

@Repository
public interface VCRepository extends CrudRepository<VideoCassette, Long> {
}
