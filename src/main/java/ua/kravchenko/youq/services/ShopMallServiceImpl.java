package ua.kravchenko.youq.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Service;
import ua.kravchenko.youq.entity.ShopMall;

import ua.kravchenko.youq.repositories.ShopMallRepository;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Egor on 29.01.2017.
 */
@Service
public class ShopMallServiceImpl implements ShopMallService {
    @Autowired
    ShopMallRepository repository;

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
    public ShopMall save(ShopMall ds) {
        return repository.save(ds);
    }

    /**
     * Find one discount system by Id;
     *
     * @param name
     * @return Ds
     */
    @Override
    public ShopMall findByName(String name) {
        return repository.findByName(name);
    }

    /**
     * find all discount systems
     *
     * @return Ds
     */
    @Override
    public List<ShopMall> findAll() {
        return repository.findAll();
    }

    /**
     * find all unique identificators of discount systems in bd
     *
     * @return List<BigInteger>
     */
    @Override
    public List<BigInteger> findAllId() {
        return repository.findAllDsId();
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
        System.out.println(id + "im in history");
        Revision last = repository.findLastChangeRevision(id);
        return last;
    }

    @Override
    public void delete(Long id) {
        ShopMall shopMall = repository.findOne(id);
        try {
            Map result = cloudinary.uploader().destroy(shopMall.getImg(), ObjectUtils.emptyMap());
            if (result.isEmpty()) {
                System.out.println("empty");
            } else {
                System.out.println("deleted");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        repository.delete(id);
    }

    @Override
    public String uploadPhoto(byte[] photoBytes) throws IOException {
        /*create properties to upload file*/
        Map options = ObjectUtils.asMap(
                "eager", Arrays.asList(
                        new Transformation().width(200).crop("scale").radius(20)));
        /*file upload*/
        Map<String, String> uploadResult = cloudinary.uploader().upload(photoBytes, options);
        /*get id from photo*/
        System.out.println(new JSONObject(uploadResult));
        String publicId = uploadResult.get("public_id");
        return publicId;
    }


}
