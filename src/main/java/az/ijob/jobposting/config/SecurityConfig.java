package az.ijob.jobposting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/dashboard/**").authenticated()
                                .anyRequest().permitAll())
                .formLogin(formConfigurer -> {
//                            formConfigurer.loginProcessingUrl("/login")
//                                    .defaultSuccessUrl("/dashboard")
//                                    .failureForwardUrl("/login")
//                                    .loginPage("/login").defaultSuccessUrl("/dashboard");
                            formConfigurer
                                    .loginPage("/login")
                                    .loginProcessingUrl("/login")
                                    .defaultSuccessUrl("/my-jobs").permitAll();
                        }


                )
//
//
//                .logout(logoutConfigurer -> {
//                    logoutConfigurer
//                            .invalidateHttpSession(true)
//                            .clearAuthentication(true)
//                            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                            .logoutSuccessUrl("/login?logout").permitAll();
//                })

                .build();
    }


}
