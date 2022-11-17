package kodlama.io.Kodlama.io.Devs.repositories;

import kodlama.io.Kodlama.io.Devs.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {

    List<Technology> findByTechnologyName(String technologyName);

}