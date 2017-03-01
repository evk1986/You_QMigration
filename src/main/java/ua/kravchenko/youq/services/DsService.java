package ua.kravchenko.youq.services;

import org.springframework.data.history.Revision;
import org.springframework.transaction.annotation.Transactional;
import ua.kravchenko.youq.entity.Ds;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Egor on 29.01.2017.
 */
public interface DsService {

    @Transactional
    Ds save(Ds ds);

    @Transactional
    Ds findByName(String name);

    @Transactional
    List<BigInteger> findAllId();

    List<Ds> findAll();

    Revision getlastObjectRevision(Long id);

    void delete(Long id);

    String uploadPhoto(byte[] photoBytes) throws IOException;




}
