package ua.kravchenko.youq.controllers;

import com.cloudinary.Api;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.cloudinary.json.JSONArray;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.kravchenko.youq.entity.Ds;
import ua.kravchenko.youq.entity.GenericResponse;
import ua.kravchenko.youq.entity.ShopMall;
import ua.kravchenko.youq.services.DsService;
import ua.kravchenko.youq.services.ShopMallService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Date;

/**
 * Created by Egor on 10.02.2017.
 */
@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    DsService dsService;
    @Autowired
    Cloudinary cloudinary;

    @Autowired
    ShopMallService smService;

    @ResponseBody()
    @RequestMapping(value = "/image/small/{name}", method = RequestMethod.GET)
    public byte[] getImage(@PathVariable("name") String name,
                           Model model,
                           HttpServletResponse response) throws Exception {
        Api api = cloudinary.api();
        Ds ds = dsService.findByName(name);
        System.out.println("api resource: " + api.resource(ds.getImg(), ObjectUtils.emptyMap()));
        JSONObject object = new JSONObject(api.resource(ds.getImg(), ObjectUtils.emptyMap()));
        JSONArray s = object.getJSONArray("derived");
        String format = null;
        String secure_url = null;
        String url = null;
        for (int i = 0; i < s.length(); i++) {
            JSONObject jBuffer = s.getJSONObject(i);
      /*      format = object3.getString("format");
            secure_url = object3.getString("secure_url");*/
            url = jBuffer.getString("url");
        }
     /*   System.out.println(url);
        System.out.println("object.toString:  " + object.toString());
        System.out.println(s.toString());*/
        URL myTransformedUrlImage = new URL(url);
        return downloadDataFromUrl(myTransformedUrlImage);
    }

    @ResponseBody()
    @RequestMapping(value = "/image/small/mall/{name}", method = RequestMethod.GET)
    public byte[] getImage(@PathVariable("name") String name,
                           Model model) throws Exception {
        Api api = cloudinary.api();
        ShopMall ds = smService.findByName(name);
        System.out.println("api resource: " + api.resource(ds.getImg(), ObjectUtils.emptyMap()));
        JSONObject object = new JSONObject(api.resource(ds.getImg(), ObjectUtils.emptyMap()));
        JSONArray s = object.getJSONArray("derived");
        String url = null;
        for (int i = 0; i < s.length(); i++) {
            JSONObject jBuffer = s.getJSONObject(i);
            url = jBuffer.getString("url");
        }
        URL myTransformedUrlImage = new URL(url);
        return downloadDataFromUrl(myTransformedUrlImage);
    }

    @ResponseBody()
    @RequestMapping(value = "/gettime/{name}", method = RequestMethod.GET)
    public GenericResponse getTime(@PathVariable("name") String name, Model model, HttpServletResponse response) throws Exception {
        System.out.println("im here");
        Ds currentDs = dsService.findByName(name);
        GenericResponse data = new GenericResponse();
        data.setDate(Date.valueOf(String.valueOf(currentDs.getCreatedDate())));
        System.out.println(data.toString());
        return data;
    }

    /**
     * Download data from url
     *
     * @param toDownload
     * @return byte[] data
     */
    private byte[] downloadDataFromUrl(URL toDownload) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            byte[] chunk = new byte[4096];
            int bytesRead;
            InputStream stream = toDownload.openStream();
            while ((bytesRead = stream.read(chunk)) > 0) {
                outputStream.write(chunk, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return outputStream.toByteArray();
    }

}
