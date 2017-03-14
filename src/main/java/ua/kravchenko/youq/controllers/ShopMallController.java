package ua.kravchenko.youq.controllers;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.kravchenko.youq.entity.*;
import ua.kravchenko.youq.services.CityService;
import ua.kravchenko.youq.services.CountryService;
import ua.kravchenko.youq.services.RegionService;
import ua.kravchenko.youq.services.ShopMallService;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 29.01.2017.
 */
@Controller
@RequestMapping(value = "/shop-mall")
public class ShopMallController {

    @Autowired
    EntityManager em;

    @Autowired
    ShopMallService shopMallService;
    @Autowired
    CountryService countryService;
    @Autowired
    RegionService regionService;
    @Autowired
    CityService cityService;

    @Autowired
    Cloudinary cloudinary;


    @RequestMapping(value = "/succes_adding_ds", method = RequestMethod.GET)
    public String getViewSuccesAddDs(Model model) {
        return "succesAddingDs";
    }

    @RequestMapping(value = "/add-new-mall", method = RequestMethod.GET)
    public String getMyDs(Model model) {
        ShopMall sm = new ShopMall();
        List<Country> countrys = countryService.findAll();
        List<Region> regions = regionService.findAll();
        List<City> cities = cityService.findAll();
        model.addAttribute("sm", sm);
        model.addAttribute("cities", cities);
        model.addAttribute("regions", regions);
        model.addAttribute("countrys", countrys);
        return "sm_add_new";
    }

    @RequestMapping(value = "/save-mall", method = RequestMethod.PUT)
    public String saveMyDs(@ModelAttribute(value = "sm")
                                   ShopMall sm, BindingResult bindingResult,
                           Model model,
                           HttpServletRequest req,
                           @RequestPart("image") MultipartFile file,
                           @RequestPart("backImage") MultipartFile secondImage) throws IOException {
        ShopMall smModel = null;
        if (shopMallService.findByName(sm.getName()) != null) {
            smModel = shopMallService.findByName(sm.getName());
        } else {
            smModel = new ShopMall();
        }
        smModel.setName(sm.getName());
        smModel.setTitle(sm.getTitle());
        smModel.setAbout(sm.getAbout());
        /*logo*/
        if (!file.isEmpty()) {
            byte[] img = file.getBytes();
            smModel.setImg(shopMallService.uploadPhoto(img));
        }
         /*background image*/
        if (!secondImage.isEmpty()) {
            byte[] img = secondImage.getBytes();
            smModel.setBackImage(shopMallService.uploadPhoto(img));
        }
        smModel.setColorBg(sm.getColorBg());
        smModel.setUrl(sm.getUrl());
        smModel.setTelNumber(sm.getTelNumber());
        smModel.setTelName(sm.getTelName());
        smModel.setAddAdress(sm.getAddAdress());
        smModel.setEmail(sm.getEmail());
        smModel.setLatitude(sm.getLatitude());
        smModel.setLongtitude(sm.getLongtitude());
        smModel.setPostCode(sm.getPostCode());
        smModel.setStatus(sm.getStatus());
        smModel.setStreet(sm.getStreet());
        smModel.setRegion(sm.getRegion());
        smModel.setCountry(sm.getCountry());
        smModel.setCity(sm.getCity());
        smModel.setSubName(sm.getSubName());
        List<WorkDay> wd = new ArrayList<>(7);
        System.out.println(wd.size());
        System.out.println(sm.getWorkDays().size());
        for (int i = 0; i < sm.getWorkDays().size(); i++) {
            System.out.println(sm.getWorkDays().get(i));
            wd.add(sm.getWorkDays().get(i));
        }
        smModel.setWorkDays(wd);
        System.out.println(smModel.getWorkDays().toString());
        shopMallService.save(smModel);
        return "redirect:" + req.getContextPath() + "/shop-mall/viewall";
    }

    @RequestMapping(value = "/viewall", method = RequestMethod.GET)
    public String deleteCountry(Model model) {
        List<ShopMall> sm = shopMallService.findAll();
        model.addAttribute("sm", sm);
        return "sm_view_all";
    }

    @RequestMapping(value = "/testing", method = RequestMethod.GET)
    public String test(Model model) {
        List<ShopMall> sm = shopMallService.findAll();

        for (int i = 0; i < sm.size(); i++) {
            System.out.println(sm.get(i).toString());
        }

        return "sm_view_all";
    }


/*

    @RequestMapping(value = "/administrate_ds/info_ds/{name}", method = RequestMethod.GET)
    public String infoViewDs(Model model, @PathVariable("name") String name, HttpServletRequest req) {
        Ds ds = shopMallService.findByName(name);
        List<Country> countrys = countryService.findAll();
        System.out.println(countrys);
        model.addAttribute("ds", ds);
        model.addAttribute("countrys", countrys);
        System.out.println("date " + ds.dateFormating(ds.getCreatedDate()));
        return "ds_info";
    }

    @RequestMapping(value = "/administrate_ds/edit/{name}", method = RequestMethod.GET)
    public String editDsView(Model model, @PathVariable("name") String name, HttpServletRequest req) {
        Ds ds = shopMallService.findByName(name);
        List<Country> countrys = countryService.findAll();
        System.out.println(countrys);
        model.addAttribute("ds", ds);
        model.addAttribute("countrys", countrys);
        return "ds_edit";
    }

    @RequestMapping(value = "/administrate_ds/ds_edit", method = RequestMethod.GET)
    public String fetEditViewDs(Model model) {
        Ds ds = new Ds();
        List<Country> countries = countryService.findAll();
        System.out.println(countries);
        model.addAttribute("ds", ds);
        model.addAttribute("countrys", countries);
        return "ds_edit";
    }

    @RequestMapping(value = "/administrate_ds/delete/{id}", method = RequestMethod.POST)
    public String deleteDs(Model model, @PathVariable("id") Long id, HttpServletRequest req) {
        shopMallService.delete(id);
        return "redirect:" + req.getContextPath() + "/ds/administrate_ds";
    }
*/


}

