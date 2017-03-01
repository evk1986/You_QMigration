package ua.kravchenko.youq.controllers;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.kravchenko.youq.entity.Country;
import ua.kravchenko.youq.entity.Ds;
import ua.kravchenko.youq.services.CountryService;
import ua.kravchenko.youq.services.DsService;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Egor on 29.01.2017.
 */
@Controller
@RequestMapping(value = "/ds")
public class DsController {

    @Autowired
    EntityManager em;

    @Autowired
    DsService dsService;

    @Autowired
    CountryService countryService;

    @Autowired
    Cloudinary cloudinary;


    @RequestMapping(value = "/succes_adding_ds", method = RequestMethod.GET)
    public String getViewSuccesAddDs(Model model) {
        return "succesAddingDs";
    }

    @RequestMapping(value = "/add_new_ds", method = RequestMethod.GET)
    public String getMyDs(Model model) {
        Ds ds = new Ds();
        List<Country> countrys = countryService.findAll();
        System.out.println(countrys);
        model.addAttribute("ds", ds);
        model.addAttribute("countrys", countrys);
        return "ds_add_new";
    }

    @RequestMapping(value = "/save_ds", method = RequestMethod.PUT)
    public String saveMyDs(@ModelAttribute(value = "ds")
                                   Ds ds, BindingResult bindingResult,
                           Model model,
                           HttpServletRequest req,
                           @RequestPart("image") MultipartFile file) throws IOException {
        System.out.println(ds.toString());
        Ds dsModel = null;
        if (dsService.findByName(ds.getName()) != null) {
            dsModel = dsService.findByName(ds.getName());
        } else {
            dsModel = new Ds();
        }
        dsModel.setName(ds.getName());
        dsModel.setName(ds.getName());
        dsModel.setTitle(ds.getTitle());
        dsModel.setAbout(ds.getAbout());
        // dsModel.setImg(ds.getImg());
        if (!file.isEmpty()) {
            byte[] img = file.getBytes();
            dsModel.setImg(dsService.uploadPhoto(img));
        }


        dsModel.setColorBg(ds.getColorBg());
        dsModel.setColorFont(ds.getColorFont());
        dsModel.setCodeFormat(ds.getCodeFormat());
        dsModel.setCountry(ds.getCountry());
        dsModel.setUrl(ds.getUrl());
        dsModel.setTelNumber(ds.getTelNumber());
        dsModel.setTelName(ds.getTelName());
        dsService.save(dsModel);
        return "redirect:" + req.getContextPath() + "/ds/administrate_ds";
    }

    @RequestMapping(value = "/administrate_ds", method = RequestMethod.GET)
    public String deleteCountry(Model model) {
        List<Ds> ds = dsService.findAll();
        model.addAttribute("ds", ds);
        return "ds_administrate";
    }

    @RequestMapping(value = "/administrate_ds/info_ds/{name}", method = RequestMethod.GET)
    public String infoViewDs(Model model, @PathVariable("name") String name, HttpServletRequest req) {
        Ds ds = dsService.findByName(name);
        List<Country> countrys = countryService.findAll();
        System.out.println(countrys);
        model.addAttribute("ds", ds);
        model.addAttribute("countrys", countrys);
        return "ds_info";
    }

    @RequestMapping(value = "/administrate_ds/edit/{name}", method = RequestMethod.GET)
    public String editDsView(Model model, @PathVariable("name") String name, HttpServletRequest req) {
        Ds ds = dsService.findByName(name);
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
        dsService.delete(id);
        return "redirect:" + req.getContextPath() + "/ds/administrate_ds";
    }


}

