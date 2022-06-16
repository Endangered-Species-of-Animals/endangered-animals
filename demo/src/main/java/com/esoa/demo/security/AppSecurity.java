package com.esoa.demo.security;



import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.esoa.demo.service.UserService;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AppSecurity extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final BCryptPasswordEncoder encoder;
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder user) throws Exception {
        user.userDetailsService(userService).passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests()
                    .antMatchers("/signup", "/auth/register", "/css/*", "/js/*", "/img/*").permitAll()
                    .antMatchers("/**").permitAll()   ///authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                        .loginProcessingUrl("/logincheck")
                        .usernameParameter("email")
                        .passwordParameter("pwd")
                        .defaultSuccessUrl("/", false)
                        .failureUrl("/auth/login?error=true")
                        .permitAll()
                .and()
                    .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/auth/login?logout=true")
                        .permitAll()
                .and()
                    .csrf()
                    .disable();
        // @formatter:on
    }
    
}
