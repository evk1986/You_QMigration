package ua.kravchenko.youq.controllers;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.kravchenko.youq.entity.Country;
import ua.kravchenko.youq.entity.ShopNetwork;
import ua.kravchenko.youq.services.CountryService;
import ua.kravchenko.youq.services.ShopNetworkService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Egor on 29.01.2017.
 */
@Controller
@RequestMapping(value = "/shop-network")
public class ShopNetworkController {

    @Autowired
    ShopNetworkService service;
    @Autowired
    CountryService countryService;

    @Autowired
    Cloudinary cloudinary;


    @RequestMapping(value = "/add-new-network", method = RequestMethod.GET)
    public String getMyDs(Model model) {
        ShopNetwork shopNetwork = new ShopNetwork();
        List<Country> countrys = countryService.findAll();
        model.addAttribute("shopNetwork", shopNetwork);
        model.addAttribute("countrys", countrys);
        return "network_add_new";
    }

    /*дает сбой!*/
    @RequestMapping(value = "/edit/{name}", method = RequestMethod.GET)
    public String getMyDs(@PathVariable("name") String name, Model model) {
        ShopNetwork shopNetwork = service.findByName(name);
        System.out.println(shopNetwork.toString());
        List<Country> countrys = countryService.findAll();
        model.addAttribute("sm", shopNetwork);
        model.addAttribute("countrys", countrys);
        return "network_add_new";
    }

    @RequestMapping(value = "/save-network", method = RequestMethod.PUT)
    public String saveMyDs(@ModelAttribute(value = "shopNetwork")
                                   ShopNetwork shopNetwork, BindingResult bindingResult,
                           Model model,
                           HttpServletRequest req,
                           @RequestPart("image") MultipartFile file,
                           @RequestPart("backImage") MultipartFile secondImage) throws IOException {
        ShopNetwork shopNetworkModel;
        if (service.findByName(shopNetwork.getName()) != null) {
            shopNetworkModel = service.findByName(shopNetwork.getName());
        } else {
            shopNetworkModel = new ShopNetwork();
        }
        shopNetworkModel.setName(shopNetwork.getName());
               /*logo*/
        if (!file.isEmpty()) {
            byte[] img = file.getBytes();
            shopNetworkModel.setLogo(service.uploadPhoto(img));
        }
         /*background image*/
        if (!secondImage.isEmpty()) {
            byte[] img = secondImage.getBytes();
            shopNetworkModel.setBackImage(service.uploadPhoto(img));
        }
        shopNetworkModel.setUrl(shopNetwork.getUrl());
        shopNetworkModel.setPhone(shopNetwork.getPhone());
        shopNetworkModel.setPhoneTitle(shopNetwork.getPhoneTitle());
        shopNetworkModel.setEmail(shopNetwork.getEmail());
        shopNetworkModel.setStatus(shopNetwork.getStatus());
        shopNetworkModel.setSubName(shopNetwork.getSubName());
        shopNetworkModel.setCountry(shopNetwork.getCountry());
        shopNetworkModel.setColor(shopNetwork.getColor());
        service.save(shopNetworkModel);
        return "redirect:" + req.getContextPath() + "/shop-network/viewall";
    }

    @RequestMapping(value = "/viewall", method = RequestMethod.GET)
    public String deleteCountry(Model model) {
        List<ShopNetwork> shopNetworks = service.findAll();
        model.addAttribute("shopNetworks", shopNetworks);
        return "sm_view_all";
    }


    @RequestMapping(value = "/viewall/delete/{id}", method = RequestMethod.DELETE)
    public String deleteDs(Model model, @PathVariable("id") Long id, HttpServletRequest req) {
        service.delete(id);
        return "redirect:" + req.getContextPath() + "/shop-mall/viewall";
    }

}
