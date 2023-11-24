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
                                    "/api/v0/customers/login", "/api/v0/customers/register"
                            )
                            .permitAll()
                            .requestMatchers(POST,
                                    "api/v0/products/create"
                            ).permitAll()
                            .requestMatchers(GET,
                                    "api/v0/products/**"
                            ).permitAll()
                            .requestMatchers(GET,
                                    "api/v0/products/top"
                            ).permitAll()
                            .requestMatchers(PUT,
                                    "/api/v0/products**", "/api/v0/products/**"
                            ).permitAll()
                            .requestMatchers(DELETE,
                                    "/api/v0/products**","/api/v0/products/**"
                            ).permitAll()
                            .requestMatchers(PUT,
                                    "api/v0/products/image/**","/api/v0/products/image**"
                            ).permitAll()
                            .requestMatchers(GET,
                                    "api/v0/income-reports/default-list"
                            ).permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/income-reports/byTime**"
                            ).permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/roles"
                            ).permitAll()
                            .requestMatchers(POST,
                                    "/api/v0/roles"
                            ).permitAll()
                            .requestMatchers(DELETE,
                                    "/api/v0/roles/**","/api/v0/roles**"
                            ).permitAll()
                            .requestMatchers(PUT,
                                    "/api/v0/roles/**","/api/v0/roles**"
                            ).permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/customer-reports/all-list"
                                    , "/api/v0/customer-reports/buying-list"
                                    , "/api/v0/customer-reports/none-buying-list"
                                    ,"/api/v0/customer-reports/status"
                            ).permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/customers"
                            ).permitAll()
                            .requestMatchers(PUT,
                                    "/api/v0/customers/status/**","/api/v0/customers/status**"
                            ).permitAll()
                            .requestMatchers(GET,
                                     "/api/v0/categories/**","/api/v0/categories**").permitAll()
                            .requestMatchers(POST,
                                    "/api/v0/categories").permitAll()
                            .requestMatchers(PUT,
                                    "/api/v0/categories/**", "/api/v0/categories**").permitAll()
                            .requestMatchers(DELETE,
                                    "/api/v0/categories/**", "/api/v0/categories**").permitAll()
                        //     .requestMatchers(GET,
                        //             "/api/v0/products**").permitAll()
                        //     .requestMatchers(POST,
                        //             "/api/v0/categories").hasAnyRole("ADMIN")
                        //     .requestMatchers(PUT,
                        //             "/api/v0/categories").hasAnyRole(Role.ADMIN)
                        //     .requestMatchers(GET,
                        //             "/api/v0/roles/").permitAll()
//                            .requestMatchers(GET,
//                                    "/api/v0/roles/").hasRole("MANAGER")
//                            .requestMatchers(GET,
//                                    "/api/v0/products/").hasRole("MANAGER")
//                            .requestMatchers(GET,
//                                    "/api/v0/categories/").hasRole("MANAGER")
//                            .requestMatchers(GET,
//                                    "/api/v0/orders/list").hasRole("MANAGER")
                            .requestMatchers(GET,
                                    "/api/v0/orders**", "/api/v0/orders/**").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/brands/**","/api/v0/brands**").permitAll()
                            .requestMatchers(POST,
                                    "/api/v0/brands").permitAll()
                            .requestMatchers(PUT,
                                    "/api/v0/brands/**","/api/v0/brands**").permitAll()
                            .requestMatchers(DELETE,
                                    "/api/v0/brands/**","/api/v0/brands**").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/order-details").permitAll()
                            .requestMatchers(DELETE,
                                    "/api/v0/order-detail/delete/**","/api/v0/order-detail/delete**").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/feedbacks/list/**","/api/v0/feedbacks/list**").permitAll()
                            .requestMatchers(POST,
                                    "/api/v0/feedbacks/create").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/origins/**","/api/v0/origins**").permitAll()
                            .requestMatchers(POST,
                                    "/api/v0/origins").permitAll()
                            .requestMatchers(PUT,
                                    "/api/v0/origins/**","/api/v0/origins**").permitAll()
                            .requestMatchers(DELETE,
                                    "/api/v0/origins/**","/api/v0/origins**").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/images/list").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/images/**","/api/v0/images**").permitAll()
                            .requestMatchers(POST,
                                    "/api/v0/images/upload").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/specifications").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/specifications/**","/api/v0/specifications**").permitAll()
                            .requestMatchers(PUT,
                                    "/api/v0/specifications/**","/api/v0/specifications**").permitAll()
                            .requestMatchers(DELETE,
                                    "/api/v0/specifications/**","/api/v0/specifications**").permitAll()
                            .requestMatchers(POST,
                                    "/api/v0/specifications").permitAll()
                            .requestMatchers(PUT,
                                    "/api/v0/images/update/**","/api/v0/images/update**").permitAll()
                            .requestMatchers(PUT,
                                    "/api/v0/images/**","/api/v0/images**").permitAll()
                            .requestMatchers(DELETE,
                                    "/api/v0/images/delete/**","/api/v0/images/delete**").permitAll()
                            .requestMatchers(PUT,
                                    "/api/v0/orders/status/**","/api/v0/orders/status**").permitAll()
//                            .requestMatchers("**").permitAll();
                             .requestMatchers(GET,
                                     "/api/v0/orders/list/**","/api/v0/orders/list**").permitAll()
                            .requestMatchers(GET,
                                    "/api/v0/order-detail/getByOrder/**","/api/v0/order-detail/getByOrder**").permitAll()
                            .requestMatchers(PUT,
                                    "/api/v0/order-detail/quantity/**","/api/v0/order-detail/quantity**").permitAll()
                        //     .requestMatchers(POST,
                        //             "/api/v0/orders/create").hasRole("ADMIN")
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
