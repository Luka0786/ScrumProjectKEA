package com.KEA.project.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{


    //add a referencer to our security data source
    @Autowired
    private DataSource securityDataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {

        auth.jdbcAuthentication().dataSource(securityDataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select login_username, login_password, enabled from Login_Table where login_username=?")
                .authoritiesByUsernameQuery("select login_username, login_roles_role from Login_Roles where login_username=?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {

        http.authorizeRequests()
                .antMatchers("/course", "/course/search", "/course/details").hasAnyRole("STUDENT", "ADMIN", "TEACHER")
                .antMatchers("/course/signUp").hasRole("STUDENT")
                .antMatchers("/course/signedUpCourses").hasRole("STUDENT")
                .antMatchers("/course/**").hasAnyRole("ADMIN", "TEACHER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and().formLogin().loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/course")
                .failureUrl("/loginError")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login");

    }


    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }




}