package ua.kravchenko.youq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import ua.kravchenko.youq.entity.Ds;
import ua.kravchenko.youq.entity.ShopMall;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Egor on 29.01.2017.
 */
public interface ShopMallRepository extends JpaRepository<ShopMall, Long>, RevisionRepository<ShopMall, Long, Integer> {

    ShopMall findByName(String name);
    ShopMall findById(Long id);

    @Query(value = "SELECT s.id FROM shop_mall s", nativeQuery = true)
    List<BigInteger> findAllDsId();

}
