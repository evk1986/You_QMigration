package ua.kravchenko.youq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import ua.kravchenko.youq.entity.User;

import java.math.BigInteger;
import java.util.List;


public interface UserRepository extends  RevisionRepository<User, Long, Integer>,JpaRepository<User, Long> {

    /**
     * Returns user by login
     *
     * @param login
     * @return
     */
    User findOneByLogin(String login);


    /**
     * Select all IDs from schema. [for audit the entitys]
     * @return List<N> ids;
     * */
    @Query(value = "SELECT u.id FROM Users u", nativeQuery = true)
    List<BigInteger> findAllUsersId();



}
