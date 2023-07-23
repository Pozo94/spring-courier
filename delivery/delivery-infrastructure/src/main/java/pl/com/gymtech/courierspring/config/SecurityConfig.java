package pl.com.gymtech.courierspring.config;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.client.RestTemplate;
import pl.com.gymtech.courierspring.exception.CustomAccessDeniedHandler;
import pl.com.gymtech.courierspring.exception.CustomAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
class SecurityConfig {
    private final JwtAuthConverter jwtAuthConverter;
    private final KeycloakLogoutHandler keycloakLogoutHandler;

    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private CustomAccessDeniedHandler accessDeniedHandler;

    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET,"/api/orders/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/customers/").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/api/orders**").hasRole("ADMIN")
                .antMatchers("/api/orders/report*").hasAnyAuthority()
                .antMatchers("/api/db/create*").hasAnyAuthority()
                .antMatchers("/api/orders/download*").hasAnyAuthority()
                .antMatchers(HttpMethod.GET,"/api/customers**").hasRole("USER")
                .anyRequest()
                .permitAll();
        http.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());

        http.oauth2Login()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .addLogoutHandler(keycloakLogoutHandler)
                .logoutSuccessUrl("/")
                .permitAll();
        http.csrf().disable()
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthConverter);

        http.headers().frameOptions().disable();
        http
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(customAuthenticationEntryPoint);
        return http.build();
    }
}