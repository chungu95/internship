package project_management.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import project_management.api.WebURL;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/").hasRole("USER")
                .and()
                .formLogin()
                .loginPage(WebURL.USER.LOGIN_PAGE)
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");

        http
                .authorizeRequests()
                .antMatchers("/get").hasRole("USER")
                .antMatchers(WebURL.EMPLOYEE.CREATE_NEW_EMPLOYEE).hasRole("HR")
                .antMatchers(WebURL.EMPLOYEE.CREATE_NEW_EMPLOYEE_PAGE).hasRole("HR")
                .antMatchers(WebURL.EMPLOYEE.ALL_EMPLOYEE_PAGE).hasRole("HR")
                .antMatchers(WebURL.EMPLOYEE.UPDATE_EMPLOYEE).hasRole("HR")
                .antMatchers(WebURL.EMPLOYEE.EDIT_EMPLOYEE_PAGE).hasRole("HR")
                .antMatchers(WebURL.EMPLOYEE.DELETE_EMPLOYEE).hasRole("HR");
    }
}
