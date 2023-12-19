package com.egustore.eshop.config;

import com.egustore.eshop.filters.JwtTokenFilter;
import com.egustore.eshop.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpMethod.*;


@Configuration
//@EnableMethodSecurity
@EnableWebSecurity
@EnableWebMvc
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> {
                    requests
                            .requestMatchers(
                                    "/api/v0/customers/login",
                                    "/api/v0/customers/register",
                                    "/api/v0/customers/forgotPassword",
                                    "/api/v0/customers/resetPassword",


                                    "api/v0/specifications**",
                                    "/api/v0/products**",
                                    "api/v0/brands**",
                                    "api/v0/images**"
                            ).permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/rating-products").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/rating-products/**").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/rating-products/**").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/feedbacks/list/**").permitAll()
                            .requestMatchers(GET,
                                    "api/v0/specifications/products/**").permitAll()

                            .requestMatchers(GET,
                                    "/api/v0/images/products/**").permitAll()

                            .requestMatchers(GET,
                                    "/api/v0/roles").permitAll()


                            .requestMatchers(GET,
                                    "/api/v0/categories/active").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/categories/**").permitAll()
                            .requestMatchers(POST,
                                    "/api/v0/categories").hasAnyRole("ADMIN")
                            .requestMatchers(PUT,
                                    "/api/v0/categories").hasAnyRole("ADMIN")
                            .requestMatchers(DELETE,
                                    "/api/v0/categories").hasAnyRole("ADMIN")

                            .requestMatchers(GET,
                                    "/api/v0/products").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/products/**").permitAll()

                            .requestMatchers(GET,
                                    "/api/v0/home").permitAll()

                            .requestMatchers(PUT,
                                    "/api/v0/customers/change-password/**").hasAnyRole("ADMIN","CUSTOMER")

                            .requestMatchers(GET,
                                    "/api/v0/orders").hasAnyRole("ADMIN","CUSTOMER")

                            .requestMatchers(GET,
                                    "/api/v0/orders/list/**").hasAnyRole("ADMIN","CUSTOMER")
                            .requestMatchers(POST,
                                    "/api/v0/orders/**").hasAnyRole("ADMIN","CUSTOMER")

                            .requestMatchers(PUT,
                                    "/api/v0/orders/**").hasAnyRole("ADMIN")
                            .requestMatchers(POST,
                                    "/api/v0/order-details/create").hasAnyRole("ADMIN","CUSTOMER")
                            .requestMatchers(PUT,
                                    "/api/v0/order-details/**").hasAnyRole("ADMIN")
                            .requestMatchers(DELETE,
                                    "/api/v0/order-details/**").hasAnyRole("ADMIN")

                            .requestMatchers(POST,
                                    "/api/v0/specifications**").hasAnyRole("ADMIN")
                            .requestMatchers(PUT,
                                    "/api/v0/specifications/**").hasAnyRole("ADMIN")
                            .requestMatchers(DELETE,
                                    "/api/v0/specifications/**").hasAnyRole("ADMIN")
                            .requestMatchers(PUT,
                                    "/api/v0/customers/status/**").hasAnyRole("ADMIN")


                            .requestMatchers(POST,
                                    "/api/v0/rating-products").permitAll()

                            .requestMatchers(POST,
                                    "/api/v0/brands").hasAnyRole("ADMIN")
                            .requestMatchers(PUT,
                                    "/api/v0/brands/**").hasAnyRole("ADMIN")
                            .requestMatchers(DELETE,
                                    "/api/v0/brands/**").hasAnyRole("ADMIN")

                            .requestMatchers(POST,
                                    "/api/v0/origins").hasAnyRole("ADMIN")
                            .requestMatchers(PUT,
                                    "/api/v0/origins/**").hasAnyRole("ADMIN")
                            .requestMatchers(DELETE,
                                    "/api/v0/origins/**").hasAnyRole("ADMIN")


                            .requestMatchers(POST,
                                    "/api/v0/products").hasAnyRole("ADMIN")
                            .requestMatchers(PUT,
                                    "/api/v0/products/**").hasAnyRole("ADMIN")
                            .requestMatchers(DELETE,
                                    "/api/v0/products/**").hasAnyRole("ADMIN")

                            .requestMatchers(POST,
                                    "/api/v0/images/upload").hasAnyRole("ADMIN")
                            .requestMatchers(PUT,
                                    "/api/v0/images/update/**").hasAnyRole("ADMIN")
                            .requestMatchers(DELETE,
                                    "/api/v0/images/delete/**").hasAnyRole("ADMIN")

                            .requestMatchers(POST,
                                    "/api/v0/vouchers").hasAnyRole("ADMIN")
                            .requestMatchers(PUT,
                                    "/api/v0/vouchers/**").hasAnyRole("ADMIN")
                            .requestMatchers(DELETE,
                                    "/api/v0/vouchers/**").hasAnyRole("ADMIN")

//
                            .anyRequest().authenticated();


                })
                .csrf(AbstractHttpConfigurer::disable);
        http.cors(new Customizer<CorsConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CorsConfigurer<HttpSecurity> httpSecurityCorsConfigurer) {
                CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedOrigins(List.of("*"));
                configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
                configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
                configuration.setExposedHeaders(List.of("x-auth-token"));
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", configuration);
                httpSecurityCorsConfigurer.configurationSource(source);
            }
        });

        return http.build();
    }}