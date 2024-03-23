package com.shamolima.locationservice.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    //@Value("${SECRET}")
    private String JWT_SECRET = "";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /*String token = extractToken(request);

        try {
            if(validateToken(JWT_SECRET.getBytes(StandardCharsets.UTF_8), token)){
                filterChain.doFilter(request, response);
            } else {
                throw new RuntimeException("Invalid token");
            }

        } catch (ParseException | JOSEException e) {
            throw new RuntimeException("Invalid token");
        }*/
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // Remove "Bearer " prefix
        } else {
            throw new RuntimeException("Bad request");
        }
    }

    private boolean validateToken(byte[] secret, String token) throws ParseException, JOSEException {
        SignedJWT receivedSignedJWT = SignedJWT.parse(token);
        JWSVerifier verifier = new MACVerifier(secret);
        boolean isValid = receivedSignedJWT.verify(verifier);
        return isValid;
    }

}
