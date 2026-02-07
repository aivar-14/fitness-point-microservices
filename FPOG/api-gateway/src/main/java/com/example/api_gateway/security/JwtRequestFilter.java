package com.example.api_gateway.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Mono;

@Component
public class JwtRequestFilter implements GatewayFilter {

    @Value("${jwt.secret}") // Get the secret key from application.properties
    private String secret;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);
            try {
                Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt).getBody();
                // Add user ID or username to request headers for downstream services
                ServerHttpRequest modifiedRequest = request.mutate()
                        .header("X-Auth-User", claims.getSubject())
                        .build();
                return chain.filter(exchange.mutate().request(modifiedRequest).build());
            } catch (io.jsonwebtoken.SignatureException | io.jsonwebtoken.MalformedJwtException | io.jsonwebtoken.ExpiredJwtException e) {
                // Invalid token, do not add headers and continue the chain
            }
        }
        return chain.filter(exchange);
    }
}
