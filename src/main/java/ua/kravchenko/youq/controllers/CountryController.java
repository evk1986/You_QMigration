package ua.kravchenko.youq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.kravchenko.youq.entity.Country;
import ua.kravchenko.youq.services.CountryService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Egor on 29.01.2017.
 */
@Controller
@RequestMapping(value = "/country")
public class CountryController {
    @Autowired
    CountryService countryService;

    /**
     * Gets the view "add new country"
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add_new_country", method = RequestMethod.GET)
    public String getViewAddNewCountry(Model model) {
        Country country = new Country();
        model.addAttribute("country", country);
        return "country_add_new";
    }

    /**
     * Add new country [Post method]
     *
     * @param model
     * @param country
     * @return
     */
    @RequestMapping(value = "/add_new_country", method = RequestMethod.PUT)
    public String addNewCountry(Model model,
                                @ModelAttribute(value = "country") Country country,
                                HttpServletRequest req) {
        System.out.println(country.toString());
        Country countryDao = null;
        if (countryService.findByName(country.getNameRu()) != null) {
            countryDao = countryService.findByName(country.getNameRu());
        } else {
            countryDao = new Country();
        }
        countryDao.setCode(country.getCode());
        countryDao.setNameRu(country.getNameRu());
        countryDao.setNameEn(country.getNameEn());
        countryDao.setCodeIso2(country.getCodeIso2());
        countryDao.setCodeIso3(country.getCodeIso3());
        countryService.save(countryDao);
        model.addAttribute("country", countryDao);
        return "redirect:" + req.getContextPath() + "/country/administrate_countries";
    }

    /**
     * Returns the list of the countrys. registred in system
     *
     * @param model
     * @return String page
     */
    @RequestMapping(value = "/administrate_countries", method = RequestMethod.GET)
    public String administrateView(Model model) {
        List<Country> countrys = countryService.findAll();
        model.addAttribute("countrys", countrys);
        return "countrys_adminisrate";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteCountry(@PathVariable(name = "id") Integer id, Model model) {
        countryService.delete(id);
        List<Country> countrys = countryService.findAll();
        model.addAttribute("countrys", countrys);
        return "countrys_adminisrate";
    }


}
