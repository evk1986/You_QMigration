package ua.kravchenko.youq.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Service;
import ua.kravchenko.youq.entity.Ds;
import ua.kravchenko.youq.repositories.DsRepository;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Created by Egor on 29.01.2017.
 */
@Service
public class DsServiceImpl implements DsService {
    @Autowired
    DsRepository repository;

    @Autowired
    Cloudinary cloudinary;
    /*CLOUDINARY_URL=cloudinary://{api_key}:{api_secret}@{cloud_name};*/

    /**
     * save  discount system to db;
     *
     * @param ds
     * @return Ds
     */
    @Override
    public Ds save(Ds ds) {
        return repository.save(ds);
    }

    /**
     * Find one discount system by Id;
     *
     * @param name
     * @return Ds
     */
    @Override
    public Ds findByName(String name) {
        return repository.findByName(name);
    }

    /**
     * find all discount systems
     *
     * @return Ds
     */
    @Override
    public List<Ds> findAll() {
        return repository.findAll();
    }

    /**
     * find all unique identificators of discount systems in bd
     *
     * @return List<BigInteger>
     */
    @Override
    public List<BigInteger> findAllId() {
        return null;
    }

    /**
     * Find the latest revision of the object
     * by spring jpa envers.
     *
     * @param id
     * @return Revision
     */
    @Override
    public Revision getlastObjectRevision(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public String uploadPhoto(byte[] photoBytes) throws IOException {
        Map<String, String> map = cloudinary.uploader().upload(photoBytes, ObjectUtils.emptyMap());
        String url = map.get("public_id");
        return url;
    }


}
