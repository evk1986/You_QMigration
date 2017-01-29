package ua.kravchenko.youq.services;

import org.springframework.data.history.Revision;
import org.springframework.transaction.annotation.Transactional;
import ua.kravchenko.youq.entity.User;

import java.math.BigInteger;
import java.util.List;

/**
 * интерфейс описывающий методы для работы с пользователями
 *
 * @author Egor
 */
public interface UserService {

    @Transactional
    User save(User user);


    @Transactional
    User findByLogin(String login);

    @Transactional
    List<BigInteger> findAllId();

    Revision getlastObjectRevision(Long id);


/*
    @Transactional
    List<User> getAll();

    @Transactional
    User findById(Long id);
*/


}
