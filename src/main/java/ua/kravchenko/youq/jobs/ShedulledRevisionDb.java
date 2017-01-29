package ua.kravchenko.youq.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import ua.kravchenko.youq.services.UserService;

import java.text.SimpleDateFormat;

/**
 * Created by Egor on 28.01.2017.
 */

public class ShedulledRevisionDb {

//    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    UserService service;

   /* *//**
     * sheduling bean. run every 30 minutes.
     *//*
    @Scheduled(cron = "0 0/30 8-23 * * *")
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
        List<BigInteger> ids = service.findAllId();
        for (int i = 0; i < ids.size(); i++) {
            Revision revision = service.getlastObjectRevision(ids.get(i).longValue());
            *//*last modified object*//*
            User user = (User) revision.getEntity();
            DatabaseReference ref = database.getReference("mydb");
            DatabaseReference usersRef = ref.child("users");
            Map<String, User> users = new HashMap<String, User>();
            users.put(user.getLogin(), new User(user.getHomeAdress(), user.getTelNumber()));
            usersRef.setValue(users);
        }


    }*/
}
