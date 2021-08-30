package org.alexandraavendano.printerstore.security;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        try {
            Credentials cred = objectMapper.readValue(request.getInputStream(), Credentials.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(cred.getUserName(), cred.getPassword(),new ArrayList<>()));
        } catch(IOException e) {
            throw new RuntimeException("Could not read request" + e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication) throws IOException {
        String token = Jwts.builder()
                .setSubject(((User) authentication.getPrincipal()).getUsername())
                .claim("role", ((User) authentication.getPrincipal()).getAuthorities().iterator().next().getAuthority())
                .setExpiration(new Date(System.currentTimeMillis() + 7_200_000))      //2 hours
                .signWith(SignatureAlgorithm.HS512, "SecretKeyToGenJWTs".getBytes())
                .compact();

        response.addHeader("Content-Type", "application/json");
        response.getWriter().write("{ \"authorization\": \"" + token + "\" }");
        response.addHeader("Authorization","Bearer " + token);
    }

}