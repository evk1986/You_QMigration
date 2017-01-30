package ua.kravchenko.youq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.kravchenko.youq.entity.Country;
import ua.kravchenko.youq.services.CountryService;

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
     * @param model
     * @param country
     * @return
     */
    @RequestMapping(value = "/add_new_country", method = RequestMethod.PUT)
    public String addNewCountry(Model model, @ModelAttribute(value = "country") Country country) {
        System.out.println(country.toString());
        Country countryDao = null;
        if (countryService.findByName(country.getCountryName()) != null) {
            countryDao = countryService.findByName(country.getCountryName());
        } else {
            countryDao = new Country();
        }
        countryDao.setCode(country.getCode());
        countryDao.setCountryName(country.getCountryName());

        countryService.save(countryDao);
        model.addAttribute("country", countryDao);
        return "succesAddingDs";
    }

    /**
     * Returns the list of the countrys. registred in system
     * @param model
     * @return String page
     */
    @RequestMapping(value = "/administrate_countries", method = RequestMethod.GET)
    public String deleteCountry(Model model) {
        List<Country> countrys = countryService.findAll();
        model.addAttribute("countrys", countrys);
        return "countrys_administrate";
    }


}
