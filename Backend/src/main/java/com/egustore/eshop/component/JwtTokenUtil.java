package com.egustore.eshop.component;

import com.egustore.eshop.model.Customer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtTokenUtil {
    @Value("${jwt.expiration}")
    private int expiration;
    @Value("${jwt.secretKey}")
    private String secretKey;

    public JwtTokenUtil(int expiration, String secretKey) {
        this.expiration = expiration;
        this.secretKey = secretKey;
    }

    public String generateToken(Customer customer) throws Exception{
        Map<String,Object> claims = new HashMap<>();
//        this.genarateSecretKey();
        claims.put("email", customer.getEmail());
        claims.put("id", customer.getId());
        try {
            String token = Jwts.builder()
                    .setClaims(claims)
                    .setSubject(customer.getEmail())
                    .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000L)) //Đổi giây
                    .signWith(getSignKey(), SignatureAlgorithm.HS256)
                    .compact();
            return token;
        }catch (Exception e) {
            throw new InvalidParameterException("Can't create token!" + e.getMessage());
        }
    }


    private  String genarateSecretKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[32];
        secureRandom.nextBytes(keyBytes);
        String secretKey = Encoders.BASE64.encode(keyBytes);
        return secretKey;
    }

    private Key getSignKey(){
        byte[] bytes = Decoders.BASE64.decode(secretKey); //Decoders.BASE64.decode("TBhqQps4YkrQTQ6jJJy5V6+zIbzCtGNSnBAuaIlOmME=")
        return Keys.hmacShaKeyFor(bytes); //Keys.hmacShaKeyFor(Decoders.BASE64.decode("TBhqQps4YkrQTQ6jJJy5V6+zIbzCtGNSnBAuaIlOmME="))
    }

    private Claims extraAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public  <T> T extraClaim(String token, Function<Claims,T> claimsTFunction) {
        final Claims claims = this.extraAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    public  boolean isTokenExpired(String token) {
        Date expiraDate = this.extraClaim(token, Claims::getExpiration);
        return expiraDate.before(new Date());
    }

    public String extraEmail(String token){
        return extraClaim(token, Claims:: getSubject);
    }

    public boolean validateToken(String token, UserDetails userDetails){
        String email = extraEmail(token);
        return (email.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
}