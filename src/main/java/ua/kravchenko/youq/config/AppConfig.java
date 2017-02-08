package ua.kravchenko.youq.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import ua.kravchenko.youq.jobs.ShedulledRevisionDb;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Egor on 28.01.2017.
 */
@Configuration
@EnableScheduling
public class AppConfig implements SchedulingConfigurer {
    @Autowired
    private Environment env;

    @Bean(destroyMethod="shutdown")
    public Executor taskScheduler() {
        return Executors.newScheduledThreadPool(42);
    }

    @Bean
    public ShedulledRevisionDb myTask() {
        return new ShedulledRevisionDb();
    }

    @Bean
    public Cloudinary cloudinary(){
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name",env.getProperty("cloudinary.cloud_name"),
                "api_key", env.getProperty("cloudinary.api_key"),
                "api_secret",  env.getProperty("cloudinary.api_secret")));
        return cloudinary;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskScheduler());
        /* taskRegistrar.addTriggerTask(
                new Runnable() {
                    public void run() {
                        myTask().reportCurrentTime();
                    }
                },
                new
        );*/

    }
}

