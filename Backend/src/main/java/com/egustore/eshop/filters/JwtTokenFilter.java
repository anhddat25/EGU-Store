//package com.egustore.eshop.filters;
//
//import com.egustore.eshop.component.JwtTokenUtil;
//import com.egustore.eshop.model.Customer;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.validation.constraints.NotNull;
//import lombok.NonNull;
//import org.springframework.data.util.Pair;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.*;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class JwtTokenFilter extends OncePerRequestFilter {
//    private final UserDetailsService userDetailsService;
//
//    private final JwtTokenUtil jwtTokenUtil;
//
//    public JwtTokenFilter(UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil) {
//        this.userDetailsService = userDetailsService;
//        this.jwtTokenUtil = jwtTokenUtil;
//    }
//
//    @Override
//    protected void doFilterInternal(@NonNull HttpServletRequest request,
//                                    @NonNull HttpServletResponse response,
//                                    @NonNull FilterChain filterChain)
//            throws ServletException, IOException {
//        try {
//            if (isBypassToken(request)){
//                filterChain.doFilter(request,response);
//                return;
//            }
//            final String authHeader = request.getHeader("Authorization");
//            if(authHeader == null || !authHeader.startsWith("Bearer ")){
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//                return;
//            }
//                final String token = authHeader.substring(7);
//                final String email = jwtTokenUtil.extraEmail(token);
//                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                    Customer userDetails = (Customer) userDetailsService.loadUserByUsername(email);
//                    if (jwtTokenUtil.validateToken(token, userDetails)){
//                        UsernamePasswordAuthenticationToken authenticationToken =
//                                new UsernamePasswordAuthenticationToken(
//                                        userDetails,
//                                        null,
//                                        userDetails.getAuthorities()
//                                );
//                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                    }
//                }
//
//            filterChain.doFilter(request,response);
//        } catch (Exception e) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//        }
//
//    }
//    private  boolean isBypassToken(@NonNull HttpServletRequest request){
//        final List<Pair<String,String>> bypassTokens = Arrays.asList(
//                Pair.of("/api/v0/roles", "GET"),
//                Pair.of("/api/v0/products", "GET"),
//                Pair.of("/api/v0/categories", "GET"),
//                Pair.of("/api/v0/customers/login", "POST"),
//                Pair.of("/api/v0/customers/register", "POST"),
//                Pair.of("/api/v0/orders","GET"),
//                Pair.of("/api/v0/income-reports/default-list", "GET"),
//                Pair.of("/api/v0/income-reports/byTime", "GET"),
//                Pair.of("/api/v0/order-details","GET"),
//                Pair.of("/api/v0/customer-reports/all-list","GET"),
//                Pair.of("/api/v0/customer-reports/none-buying-list","GET"),
//                Pair.of("/api/v0/customer-reports/buying-list","GET"),
//                Pair.of("/api/v0/customer-reports/status","GET"),
//                Pair.of("api/v0/customers","GET")
//        );
//        for(Pair<String,String> bypassToken: bypassTokens ){
//            if (request.getServletPath().contains(bypassToken.getFirst()) &&
//                    request.getMethod().equals(bypassToken.getSecond())){
//                return true;
//            }
//        }
//        return false;
//    }
//}
//
