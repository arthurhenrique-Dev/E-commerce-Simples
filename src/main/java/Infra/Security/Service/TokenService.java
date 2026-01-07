package Infra.Security.Service;

import Domain.Entities.Users.Master;
import Domain.Entities.Users.Role;
import Domain.Entities.Users.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("Outro_valor_que_normalmente_não_pode_estar_aqui")
    private String secret;

    public String generateToken(User user) {
        return createJwt(
                user.getCpf().toString(),
                user.getName().toString(),
                user.getEmail().toString(),
                user.getRole().name()
        );
    }
    public String generateToken(Master master){
        return createJwt(
                master.getCpf().toString(),
                master.getName().toString(),
                master.getEmail().toString(),
                master.getRole().name()
                );
    }

    private String createJwt(String cpf, String name, String email, String role) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("tec-bom-api")
                    .withSubject(cpf)
                    .withClaim("name", name)
                    .withClaim("email", email)
                    .withClaim("role", role)
                    .withExpiresAt(LocalDateTime.now().plusDays(7).toInstant(ZoneOffset.of("-03:00")))
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("tec-bom-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }
}
