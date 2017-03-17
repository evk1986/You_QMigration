package ua.kravchenko.youq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import ua.kravchenko.youq.entity.ShopMall;
import ua.kravchenko.youq.entity.ShopNetwork;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Egor on 29.01.2017.
 */
public interface ShopNetworkRepository extends JpaRepository<ShopNetwork, Long>, RevisionRepository<ShopNetwork, Long, Integer> {

    ShopNetwork findByName(String name);
    ShopNetwork findById(Long id);

    @Query(value = "SELECT s.id FROM shop_network s", nativeQuery = true)
    List<BigInteger> findAllDsId();

}
