//package assignment.jpawithrelation.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http)
//            throws Exception {
//        http
//                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
//                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(auth->{
//                   auth
//                           .requestMatchers(HttpMethod.PUT,"/academy/update/**").hasRole("user")
//                           .requestMatchers(HttpMethod.GET,"/academy/get/department/**").hasRole("user")
//                           .requestMatchers(HttpMethod.POST,"/academy/delete/**").hasRole("admin")
//                           .anyRequest().permitAll();
//                })
////                .formLogin(login->{
////                    login.loginPage("/login");
////                })
//        ;
//        return http.build();
//    }
//
//}
