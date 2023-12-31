package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Cerveja;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long> {

}
