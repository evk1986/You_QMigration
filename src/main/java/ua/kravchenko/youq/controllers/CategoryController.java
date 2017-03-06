package ua.kravchenko.youq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.kravchenko.youq.entity.Category;
import ua.kravchenko.youq.services.CategoryService;

import java.util.List;

/**
 * Created by Егор on 03.03.2017.
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

   /* @Autowired
    RegionService regionService;*/

    @RequestMapping(value = "/viewall", method = RequestMethod.GET)
    public String viewAll(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("cat", categories);
        return "category_view_all";
    }

    @RequestMapping(value = "/create-cat", method = RequestMethod.GET)
    public String createNewCategory(Model model) {
        Category cat = new Category();
        model.addAttribute("cat", cat);
        return "cat_create";
    }

    @RequestMapping(value = "/create-cat", method = RequestMethod.POST)
    public String createNewRegion(@ModelAttribute(value = "category")
                                          Category cat, BindingResult bindingResult,
                                  Model model) {
        Category category = new Category();
        category.setName(cat.getName());
        category.setStatus(cat.getStatus());
        categoryService.save(category);
        System.out.println(category);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "redirect:/category/viewall";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteregion(@PathVariable(value = "id") Long id, Model model) {
        categoryService.delete(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "redirect:/category/viewall";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editRegionView(@PathVariable(value = "id") Long id, Model model) {
        Category category = categoryService.findOneById(id);
        System.out.println("GET region" + category.toString());
       /*List<Ca> countries = categoryService.findAll();*/
        /*List<Region> regions = regionService.findAll();*/
        model.addAttribute("cat", category);
       /* model.addAttribute("regions", regions);*/
        return "cat_edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateRegion(@PathVariable(value = "id") Long id,
                               @ModelAttribute(value = "cat") Category cat,
                               BindingResult bindingResult,
                               Model model) {
        Category category = categoryService.findOneById(id);
        System.out.println("upcoming from model = " + cat.toString());
        System.out.println("upcoming from DB = " + category.toString());
        if (!category.getName().equals(cat.getName())) {
            category.setName(cat.getName());
        }
        if (!category.getStatus().equals(cat.getStatus())) {
            category.setStatus(cat.getStatus());
        }
        categoryService.save(category);
        System.out.println(category);
        List<Category> categories = categoryService.findAll();
        System.out.println(categories.toString());
        model.addAttribute("categories", categories);
        return "redirect:/category/viewall";

    }
}
