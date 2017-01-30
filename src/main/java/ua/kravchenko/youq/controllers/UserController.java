package ua.kravchenko.youq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.kravchenko.youq.entity.User;
import ua.kravchenko.youq.services.UserService;

import javax.persistence.EntityManager;

/**
 * Created by Egor on 27.01.2017.
 */
@Controller
public class UserController {

    @Autowired
        UserService service;

        @Autowired
        EntityManager em;


        @RequestMapping(value = "/user", method = RequestMethod.GET)
        public String getUserView(Model model) {
            User user = new User();
            model.addAttribute("user", user);
            return "user";
        }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getMainView(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }

        @RequestMapping(value = "/test", method = RequestMethod.POST)
        public String postUserView(@ModelAttribute(value = "user")
                User user,
                Model model) {
            System.out.println(user.toString());
            User cu = null;
            if (service.findByLogin(user.getLogin()) != null) {
                cu = service.findByLogin(user.getLogin());
            } else {
                cu = new User();
            }

            cu.setLogin(user.getLogin());
            cu.setHomeAdress(user.getHomeAdress());
            cu.setTelNumber(user.getTelNumber());

        /*Mysql*/
        service.save(cu);

       /*firebase*/
       /* final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("mydb");
        DatabaseReference usersRef = ref.child("users");
        Map<String, User> users = new HashMap<String, User>();
        users.put(user.getLogin(), new User(user.getHomeAdress(), user.getTelNumber()));
        usersRef.setValue(users);*/
/*
        AuditReader reader = AuditReaderFactory.get(em);
        User modifiedUser = reader.find(User.class, cu.getId(), 2);
        System.out.println(modifiedUser.toString());
        System.out.println(cu.getId() + "   ID");
        service.getlastObjectRevision(cu.getId());
        System.out.println("all ids ;" + service.findAllId());*/
        return "user";
    }
}
