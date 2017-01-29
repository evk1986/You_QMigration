package ua.kravchenko.youq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import ua.kravchenko.youq.entity.Ds;

/**
 * Created by Egor on 29.01.2017.
 */
public interface DsRepository extends JpaRepository<Ds, Long>, RevisionRepository<Ds, Long, Integer> {

    Ds findByName(String name);

}
