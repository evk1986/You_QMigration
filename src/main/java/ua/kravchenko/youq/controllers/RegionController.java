package ua.kravchenko.youq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.kravchenko.youq.entity.Country;
import ua.kravchenko.youq.entity.Region;
import ua.kravchenko.youq.services.CountryService;
import ua.kravchenko.youq.services.RegionService;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

/**
 * Created by Егор on 03.03.2017.
 */
@Controller
@RequestMapping(value = "/region")
public class RegionController {

    @Autowired
    RegionService regionService;
    @Autowired
    CountryService countryService;

    @RequestMapping(value = "/viewall", method = RequestMethod.GET)
    public String viewAll(Model model) {
        List<Region> regions = regionService.findAll();
        model.addAttribute("regions", regions);
        return "region_view_all";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createNewRegionView(Model model) {
        Region region = new Region();
        List<Country> countries = countryService.findAll();
        model.addAttribute("region", region);
        model.addAttribute("countrys", countries);
        return "region_create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createNewRegion(@ModelAttribute(value = "region")
                                          Region region, BindingResult bindingResult,
                                  Model model) {
        Region regionModel = null;
        if (regionService.findOneById(region.getId()) != null) {
            regionModel = regionService.findOneById(region.getId());
        } else {
            regionModel = this.convertingModel(region);
        }
       /* Region regionModel = regionService.findOneById(region.getId());*/
        if (!regionModel.getNameRu().equals(region.getNameRu())) {
            regionModel.setNameRu(region.getNameRu());
        }
        if (!regionModel.getNameEn().equals(region.getNameEn())) {
            regionModel.setNameEn(region.getNameEn());
        }
        if (!regionModel.getCountry().equals(region.getCountry())) {
            regionModel.setCountry(region.getCountry());
        }
        regionService.save(regionModel);
        System.out.println(regionModel);
        List<Region> regions = regionService.findAll();
        model.addAttribute("regions", regions);
        return "redirect:/region/viewall";

    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editRegionView(@PathParam(value = "id") Long id, Model model) {
        Region region = regionService.findOneById(id);
        List<Country> countries = countryService.findAll();
        model.addAttribute("region", region);
        model.addAttribute("countrys", countries);
        return "region_edit";
    }

    /*@RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateRegion(@ModelAttribute(value = "region") Region region, Model model) {
        Region regionModel = this.convertingModel(region);
        regionService.save(regionModel);
        List<Region> regions = regionService.findAll();
        model.addAttribute("regions", regions);
        return "region_edit";
    }*/

    private Region convertingModel(Region region) {
        Region model = new Region();
        model.setNameEn(region.getNameEn());
        model.setNameRu(region.getNameRu());
        model.setCountry(region.getCountry());
        return model;
    }

    private void convertToDate(long timestamp, Region region) {
        Date date = new Date();
        date.setTime((long) timestamp * 1000);
        region.setCreatedDate(Long.getLong(date.toString()));
        System.out.println(date);
    }


}
