package com.alibou.security1.auth;

import com.alibou.security1.config.JwtService;
import com.alibou.security1.user.Role;
import com.alibou.security1.user.User;
import com.alibou.security1.user.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Builder
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    public AuthenticationReponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFistname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)  // dong nay khong tuong thich
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationReponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationReponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()

                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationReponse.builder()
                .token(jwtToken)
                .build();
    }
}
