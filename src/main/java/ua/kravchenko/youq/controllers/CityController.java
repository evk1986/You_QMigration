package ua.kravchenko.youq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.kravchenko.youq.entity.City;
import ua.kravchenko.youq.entity.Region;
import ua.kravchenko.youq.services.CityService;
import ua.kravchenko.youq.services.RegionService;

import java.util.List;

/**
 * Created by Егор on 03.03.2017.
 */
@Controller
@RequestMapping(value = "/city")
public class CityController {
    @Autowired
    CityService cityService;

    @Autowired
    RegionService regionService;

    @RequestMapping(value = "/viewall", method = RequestMethod.GET)
    public String viewAll(Model model) {
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "city_view_all";
    }

    @RequestMapping(value = "/create-city", method = RequestMethod.GET)
    public String createNewRegionView(Model model) {
        City city = new City();
        List<Region> regions = regionService.findAll();
        model.addAttribute("city", city);
        model.addAttribute("regions", regions);
        return "city_create";
    }

    @RequestMapping(value = "/create-city", method = RequestMethod.PUT)
    public String createNewRegion(@ModelAttribute(value = "city")
                                          City city, BindingResult bindingResult,
                                  Model model) {
        City cityModel = new City();
        cityModel.setNameRu(city.getNameRu());
        cityModel.setNameEn(city.getNameEn());
        cityModel.setRegion(city.getRegion());
        cityService.save(cityModel);
        System.out.println(cityModel);
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "redirect:/city/viewall";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteregion(@PathVariable(value = "id") Long id, Model model) {
        cityService.delete(id);
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "redirect:/city/viewall";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editRegionView(@PathVariable(value = "id") Long id, Model model) {
        City city = cityService.findOneById(id);
        System.out.println("GET region" + city.toString());
        List<City> countries = cityService.findAll();
        List<Region> regions = regionService.findAll();
        model.addAttribute("city", city);
        model.addAttribute("regions", regions);
        return "city_edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateRegion(@PathVariable(value = "id") Long id,
                               @ModelAttribute(value = "city") City city,
                               BindingResult bindingResult,
                               Model model) {
        City cityModel = cityService.findOneById(id);
        System.out.println("upcoming from model = " + city.toString());
        System.out.println("upcoming from DB = " + cityModel.toString());

        if (!cityModel.getNameRu().equals(city.getNameRu())) {
             cityModel.setNameRu(city.getNameRu());
        }
        if (!cityModel.getNameEn().equals(city.getNameEn())){
             cityModel.setNameEn(city.getNameEn());
        }
        if (!cityModel.getRegion().equals(city.getRegion())) {
             cityModel.setRegion(city.getRegion());
        }
        cityService.save(cityModel);
        System.out.println(cityModel);
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "city_view_all";

    }

}
