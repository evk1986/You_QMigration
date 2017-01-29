package ua.kravchenko.youq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.kravchenko.youq.entity.Country;
import ua.kravchenko.youq.entity.Ds;
import ua.kravchenko.youq.services.CountryService;
import ua.kravchenko.youq.services.DsService;

import javax.persistence.EntityManager;
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
        return "addNewDs";
    }

    @RequestMapping(value = "/save_ds", method = RequestMethod.PUT)
    public String saveMyDs(@ModelAttribute(value = "ds")
                                   Ds ds, BindingResult bindingResult,
                           Model model) {
        System.out.println(ds.toString());
        Ds dsDao = null;
        if (dsService.findByName(ds.getName()) != null) {
            dsDao = dsService.findByName(ds.getName());
        } else {
            dsDao = new Ds();
        }
        dsDao.setName(ds.getName());
        dsDao.setName(ds.getName());
        dsDao.setTitle(ds.getTitle());
        dsDao.setAbout(ds.getAbout());
        dsDao.setImg(ds.getImg());
        dsDao.setColorBg(ds.getColorBg());
        dsDao.setCodeFormat(ds.getCodeFormat());
        dsDao.setCountry(ds.getCountry());
        dsDao.setUrl(ds.getUrl());
        dsDao.setTelNumber(ds.getTelNumber());
        dsDao.setTelName(ds.getTelName());
        dsService.save(dsDao);
        return "redirect:/ds/succes_adding_ds";
    }
}

