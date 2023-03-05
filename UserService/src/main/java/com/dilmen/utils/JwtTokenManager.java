package com.dilmen.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Date;
import java.util.Optional;

@ControllerAdvice
public class JwtTokenManager {
        private final Long exTime = 1000L*60*15;
        @Value(value = "${myJwt.passwordKey}")
        private String passwordKey ;
        public Optional<String> createToken(Long id){
                String token = "";
                try {
                        token= JWT.create().withAudience()
                                .withClaim("id",id)
                                .withClaim("authpage","AUTHPAGE")
                                .withClaim("priviledge","USER")
                                .withIssuer("Abdulkadir")
                                .withIssuedAt(new Date())
                                .withExpiresAt(new Date(System.currentTimeMillis()+exTime))
                                .sign(Algorithm.HMAC256(passwordKey));
                        return Optional.of(token);
                }catch (Exception exception){
                        return Optional.empty();
                }
        }

        public Boolean validateToken(String token ){
                try {
                        Algorithm algorithm = Algorithm.HMAC256(passwordKey);
                        JWTVerifier verifier = JWT.require(algorithm)
                                .withIssuer("Abdulkadir")
                                .build();
                        DecodedJWT decodedJWT = verifier.verify(token);
                        if (decodedJWT==null) return false;
                } catch (Exception exception){
                        return false;
                }
                return true;
        }
        public Optional<Long> getIdFromToken(String token){
                try {
                        Algorithm algorithm = Algorithm.HMAC256(passwordKey);
                        JWTVerifier verifier = JWT.require(algorithm)
                                .withIssuer("Abdulkadir")
                                .build();
                        DecodedJWT decodedJWT = verifier.verify(token);
                        if (decodedJWT==null) return Optional.empty();
                        return Optional.of(decodedJWT.getClaim("id").asLong());
                } catch (Exception exception){
                        return Optional.empty();
                }
        }

}
