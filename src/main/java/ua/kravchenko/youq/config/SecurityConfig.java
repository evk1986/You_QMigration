package ua.kravchenko.youq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.kravchenko.youq.services.UserService;

/**
 * Created by Egor on 31.01.2017.
 */


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    UserService service;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/ds/**", "/country/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/shop/**").permitAll()/*access("hasRole('ROLE_USER')")*/
                .antMatchers("/resources/**", "/**").permitAll()
                .antMatchers("/static/**", "/**").permitAll()
                .antMatchers("/registration", "/").permitAll()
                .antMatchers("/media/**").permitAll()
                .antMatchers("/user/updatePassword*", "/user/savePassword*", "/updatePassword*").hasAuthority("CHANGE_PASSWORD_PRIVILEGE")
                .and()
                .formLogin().
                loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
        http.csrf().disable();
    }


}

/*
    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
        web.ignoring().antMatchers("/js/**");
    }

*/
