package med.vol.api.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenServie tokenServie;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = recoverToken(request);

        //var subject = tokenServie.getSubject(tokenJWT);
        System.out.println(tokenJWT);

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var autorizationHeader = request.getHeader("Authorization");

        if (autorizationHeader == null) {
            throw new RuntimeException("Token não enviado");
        }

        return autorizationHeader.replace("Bearer", "");
    }
}