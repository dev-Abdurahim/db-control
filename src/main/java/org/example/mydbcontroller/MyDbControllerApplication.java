package org.example.mydbcontroller;

import org.example.mydbcontroller.model.entity.AuthRole;
import org.example.mydbcontroller.model.entity.AuthUser;
import org.example.mydbcontroller.repository.AuthRoleRepository;
import org.example.mydbcontroller.repository.AuthUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@SpringBootApplication

public class MyDbControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyDbControllerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(
            AuthUserRepository authUserRepository,
            AuthRoleRepository authRoleRepository,
            PasswordEncoder encoder) {
        return args -> {

            AuthRole role = new AuthRole();
            role.setCode("ADMIN");
            role.setName("Mamur");
            role.setPermissions(Collections.emptyList());

            authRoleRepository.save(role);

            AuthUser authUser = new AuthUser();
            authUser.setUsername("admin");
            authUser.setPassword(encoder.encode("123"));
            authUser.setRole(role);
            authUserRepository.save(authUser);
        };
    }




}
