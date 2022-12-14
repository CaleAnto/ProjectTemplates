package kz.narxoz.skara.config;

import kz.narxoz.skara.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, proxyTargetClass = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserService userService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/register","/books","/").permitAll()
            .antMatchers(HttpMethod.GET, "/books/new", "/books/delete/{id}", "/books/update/{id}").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/sss").hasRole("ADMIN")
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login").permitAll()
            .usernameParameter("user_email")
            .passwordParameter("user_password")
            .loginProcessingUrl("/auth").permitAll()
            .defaultSuccessUrl("/index");

        http.logout()
            .logoutUrl("/logout").permitAll()
            .logoutSuccessUrl("/login");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

}

