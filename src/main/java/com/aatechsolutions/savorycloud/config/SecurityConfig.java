package com.aatechsolutions.savorycloud.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        public SecurityConfig() {

        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Habilitar CORS
                                .csrf(csrf -> csrf.disable())
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers(
                                                                // Rutas públicas
                                                                "/auth/**",
                                                                // Archivos HTML accesibles sin autenticación
                                                                "/register.html",
                                                                // Archivos estáticos (HTML, CSS, JS, imágenes, etc.)
                                                                "/css/**", "/js/**", "/icons/**", "/images/**")
                                                .permitAll() // Acceso público, no requiere usuario autenticado
                                                .anyRequest().authenticated() // Todo lo demás requiere autenticación
                                )
                                .exceptionHandling(exceptions -> exceptions
                                                .authenticationEntryPoint((request, response, authException) -> {
                                                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
                                                        response.getWriter()
                                                                        .write("Unauthorized: Authentication required");
                                                }));
                return http.build();
        }

        @Bean
        public CorsConfigurationSource corsConfigurationSource() {
                CorsConfiguration configuration = new CorsConfiguration();

                // Permitir orígenes específicos (ajusta según tu frontend)
                configuration.setAllowedOriginPatterns(Arrays.asList(
                                "http://localhost:8080", // Para desarrollo local
                                "http://127.0.0.1:*", // Para desarrollo local
                                "https://tu-dominio.com" // Para producción
                ));

                // Métodos HTTP permitidos
                configuration.setAllowedMethods(Arrays.asList(
                                "GET", "POST", "PUT", "DELETE", "OPTIONS"));

                // Headers permitidos
                configuration.setAllowedHeaders(Arrays.asList(
                                "Authorization", "Content-Type", "X-Requested-With"));

                // Permitir credenciales (cookies)
                configuration.setAllowCredentials(true);

                // Headers expuestos al frontend
                configuration.setExposedHeaders(Arrays.asList(
                                "Authorization"));

                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", configuration);
                return source;
        }
}
