package ua.kravchenko.youq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import ua.kravchenko.youq.entity.Ds;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Egor on 29.01.2017.
 */
public interface DsRepository extends JpaRepository<Ds, Long>, RevisionRepository<Ds, Long, Integer> {

    Ds findByName(String name);

    @Query(value = "SELECT d.id FROM Discount_system d", nativeQuery = true)
    List<BigInteger> findAllDsId();

}
