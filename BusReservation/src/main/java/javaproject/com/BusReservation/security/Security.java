//package javaproject.com.BusReservation.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class Security {
//
//
////     add support for JDBC ... no more hardcoded users :-)
//
//    @Bean
//    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
//
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        // define query to retrieve a user by username
//        jdbcUserDetailsManager.setUsersByUsernameQuery(
//                "select u_id,username, password from user where user_id=?");
//
//        // define query to retrieve the authorities/roles by username
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
//                "select u_id, roles from role where user_id=?");
//
//        return jdbcUserDetailsManager;
//    }
//
//    @Bean
//    public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorize -> {
//                    authorize
//                            .requestMatchers(HttpMethod.GET, "/api/buss").hasRole("ADMIN")
//
//                            // Rules for passenger
//                            .requestMatchers(HttpMethod.GET, "/api/tripsl/**").hasRole("PASSENGER")
//                            .requestMatchers(HttpMethod.POST, "/api/tickets/**").hasRole("PASSENGER")
//                            // Rules for owner of agency
//                            .requestMatchers(HttpMethod.GET, "/api/agency/**").hasRole("OWNER")
//                            .requestMatchers(HttpMethod.POST, "/api/buss/**").hasRole("OWNER")
//                            .requestMatchers(HttpMethod.PUT, "/api/buss/**").hasRole("OWNER")
//                            .requestMatchers(HttpMethod.DELETE, "/api/buss/**").hasRole("OWNER");
//                })
//                .httpBasic(Customizer.withDefaults())
//                .csrf(csrf -> csrf.disable());
//
//        return http.build();
//    }
//
//}
//
//
//
//
//
//
//
//
//
