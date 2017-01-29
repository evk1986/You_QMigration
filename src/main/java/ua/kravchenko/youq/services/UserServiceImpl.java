package ua.kravchenko.youq.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Service;
import ua.kravchenko.youq.entity.User;
import ua.kravchenko.youq.repositories.UserRepository;

import java.math.BigInteger;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private static final String HISTORY_ENTRY_TEMPLATE = "No: %s, at: %s, User modified in: %s<br />";

    public User save(User user) {
        userRepository.save(user);
        return user;
    }


    @Override
    public User findByLogin(String login) {
        return userRepository.findOneByLogin(login);
    }

    /**
     * Get the latest revision of the modified object, by required id
     *
     * @param id
     * @return Revision obj
     */
    @Override
    public Revision getlastObjectRevision(Long id) {
        System.out.println(id + "im in history");
        Revision last = userRepository.findLastChangeRevision(id);
        return last;
    }


    public void changeUserPassword(User user, String password) {
        // user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    /**
     * Select all IDs from schema. [for audit the entitys]
     *
     * @return List<N> ids;
     */
    @Override
    public List<BigInteger> findAllId() {
        System.out.println(userRepository.findAllUsersId());
        return userRepository.findAllUsersId();
    }
}