package hu.unideb.inf.crud.repository;

import hu.unideb.inf.crud.dto.DeveloperDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<DeveloperDTO, Long> {
    DeveloperDTO findByName(String name);
}
