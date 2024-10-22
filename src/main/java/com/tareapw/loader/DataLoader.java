package com.tareapw.loader;
import com.tareapw.entity.RolsEntity;
import com.tareapw.entity.UserEntity;
import com.tareapw.repository.RolsRepository;
import com.tareapw.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private UserRepository userRepository;
    private RolsRepository rolsRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        /* Roles */
        RolsEntity user = rolsRepository.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("role not found!"));

        RolsEntity editor = rolsRepository.findById(2L)
                .orElseThrow(() -> new EntityNotFoundException("role not found!"));

        RolsEntity creator = rolsRepository.findById(3L)
                .orElseThrow(() -> new EntityNotFoundException("role not found!"));

        RolsEntity admin = rolsRepository.findById(4L)
                .orElseThrow(() -> new EntityNotFoundException("role not found!"));

        /* Users */
        UserEntity luisUser = UserEntity.builder()
                .username("luis")
                .password(passwordEncoder.encode("luis"))
                .isEnabled(true)
                .roles(Set.of(admin))
                .build();

        UserEntity julianUser = UserEntity.builder()
                .username("julian")
                .password(passwordEncoder.encode("julian"))
                .isEnabled(true)
                .roles(Set.of(creator, editor, user))
                .build();

        UserEntity nathaliaUser = UserEntity.builder()
                .username("nathalia")
                .password(passwordEncoder.encode("nath"))
                .isEnabled(true)
                .roles(Set.of(creator, editor))
                .build();

        UserEntity yohanUser = UserEntity.builder()
                .username("yohan")
                .password(passwordEncoder.encode("yohan"))
                .isEnabled(true)
                .roles(Set.of(creator))
                .build();

        UserEntity liangUser = UserEntity.builder()
                .username("liang")
                .password(passwordEncoder.encode("liang"))
                .isEnabled(true)
                .roles(Set.of(editor))
                .build();

        UserEntity felipeUser = UserEntity.builder()
                .username("felipe")
                .password(passwordEncoder.encode("artun"))
                .isEnabled(true)
                .roles(Set.of(user))
                .build();

        userRepository.saveAll(List.of(luisUser,
                julianUser,
                nathaliaUser,
                yohanUser,
                liangUser,
                felipeUser));
    }
}