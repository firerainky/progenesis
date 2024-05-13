package com.zky.progenesis.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // Add support for JDBC ... no more hard-coded users
    // @Bean
    // public UserDetailsManager userDetailsManager(DataSource dataSource) {
    //     JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
    //     return userDetailsManager;
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());
        return http.build();
    }

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeHttpRequests(configurer ->
    //             configurer
    //             .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
    //             .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
    //             .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
    //             .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
    //             .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
    //         );

    //     // Use HTTP Basic authentication
    //     http.httpBasic(Customizer.withDefaults());

    //     // Disable Cross Site Request Forgery (CSRF)
    //     // in general, not required for stateless REST APIs that use POST, PUT, DELETE and / or PATCH
    //     http.csrf(csrf -> csrf.disable());

    //     return http.build();
    // }

    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager() {

    //     UserDetails john = User.builder()
    //             .username("john")
    //             .password("{noop}test123")
    //             .roles("EMPLOYEE")
    //             .build();

    //     UserDetails mary = User.builder()
    //             .username("mary")
    //             .password("{noop}test123")
    //             .roles("EMPLOYEE", "MANAGER")
    //             .build();

    //     UserDetails susan = User.builder()
    //             .username("susan")
    //             .password("{noop}test123")
    //             .roles("EMPLOYEE", "MANAGER", "ADMIN")
    //             .build();

    //     return new InMemoryUserDetailsManager(john, mary, susan);
    // }
}
