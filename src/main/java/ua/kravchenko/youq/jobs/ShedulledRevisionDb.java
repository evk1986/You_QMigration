package ua.kravchenko.youq.jobs;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.scheduling.annotation.Scheduled;
import ua.kravchenko.youq.entity.Ds;
import ua.kravchenko.youq.services.DsService;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Egor on 28.01.2017.
 */

public class ShedulledRevisionDb {

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  /*  @Autowired
    UserService service;*/

    @Autowired
    DsService service;

    /**
     * sheduling bean. run every 30 minutes.
     */
    @Scheduled(cron = "0 0/1 8-23 * * *")
    public void backupFirebaseDb() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
        List<BigInteger> ids = service.findAllId();
        for (int i = 0; i < ids.size(); i++) {
            Revision revision = service.getlastObjectRevision(ids.get(i).longValue());
            /*last modified object*/
            Ds ds = (Ds) revision.getEntity();
            System.out.println(ds.toString());
            DatabaseReference ref = database.getReference("mydb");
            DatabaseReference usersRef = ref.child("ds");
            Map<String, Object> users = new HashMap<String, Object>();
            users.put(ds.getName(), new Ds(/*ds.getName(),*/
                    ds.getAbout(),
                    ds.getCodeFormat(),
                    ds.getColorBg(),
                    ds.getColorFont(),
                    /*ds.getCountry(),*/
                    ds.getId(),
                    ds.getImg(),
                    ds.getTelName(),
                    ds.getTelNumber(),
                    ds.getTitle(),
                    ds.getUrl()));
           usersRef.setValue(users);
        }
    }
}
