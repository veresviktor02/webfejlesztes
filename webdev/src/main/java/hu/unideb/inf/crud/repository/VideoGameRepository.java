package hu.unideb.inf.crud.repository;

import hu.unideb.inf.crud.dto.VideoGameDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGameDTO, Long> {
    //VideoGameDTO findByTitle(String title);
}
