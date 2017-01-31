package ua.kravchenko.youq.services;

import org.springframework.data.history.Revision;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import ua.kravchenko.youq.entity.User;

import java.math.BigInteger;
import java.util.List;

/**
 * интерфейс описывающий методы для работы с пользователями
 *
 * @author Egor
 */

public interface UserService extends UserDetailsService {

    @Transactional
    User save(User user);


    @Transactional
    User findByLogin(String login);

    @Transactional
    List<BigInteger> findAllId();

    Revision getlastObjectRevision(Long id);


    @Transactional
    List<User> getAll();

    @Transactional
    User findById(Long id);


 /*   @Transactional
    void createPasswordResetTokenForUser(final User user, final String token);*/


    @Transactional
    void changeUserPassword(User user, String password);
}
/*
    @Transactional
    List<User> getAll();

    @Transactional
    User findById(Long id);
*/



