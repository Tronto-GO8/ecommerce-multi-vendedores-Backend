package codifica.ecommerce.api.infrastructure.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final Algorithm algorithm;
    private final long jwtExpirationInMs;
    private final JWTVerifier verifier;
    private final String issuer = "EcommerceApp"; // Opcional: identificador da sua aplicação

    public JwtTokenProvider(@Value("${api.jwt.secret}") String secret,@Value("${api.jwt.expiration-ms}") long expirationMs) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.jwtExpirationInMs = expirationMs;
        this.verifier = JWT.require(this.algorithm).withIssuer(issuer).build();
    }


    public String generateToken(Authentication authentication) {
        OAuth2User userPrincipal = (OAuth2User) authentication.getPrincipal();
        String email = userPrincipal.getAttribute("email");
        String name = userPrincipal.getAttribute("name");


        Instant expiryDate = dateExpiration();
        return JWT.create()
                .withIssuer(issuer)
                .withSubject(email)
                .withClaim("name", name)
                .withIssuedAt(Date.from(Instant.now()))
                .withExpiresAt(expiryDate)
                .sign(algorithm);
    }


    public DecodedJWT validateToken(String token) {
        return verifier.verify(token);
    }

    public String getEmailFromJWT(DecodedJWT decodedJWT) {
        return decodedJWT.getSubject();
    }

    private Instant dateExpiration() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}