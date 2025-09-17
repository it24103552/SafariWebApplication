package com.safari.safarimanagement.config;

import com.safari.safarimanagement.domain.*;
import com.safari.safarimanagement.repository.*;
import com.safari.safarimanagement.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(RoleRepository roleRepo,
                               UserRepository userRepo,
                               VehicleRepository vehicleRepo,
                               GuideRepository guideRepo,
                               TripRepository tripRepo) {
        return args -> {
            Role admin = roleRepo.findByName("ADMIN");
            if (admin == null) {
                admin = roleRepo.save(Role.builder().name("ADMIN").build());
            }

            if (!userRepo.existsByUsername("admin")) {
                BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
                userRepo.save(
                        User.builder()
                                .username("admin")
                                .password(enc.encode("admin123"))
                                .email("admin@example.com")
                                .fullName("Administrator")
                                .roles(Set.of(admin))
                                .build()
                );
            }

            if (vehicleRepo.count() == 0) {
                vehicleRepo.save(Vehicle.builder()
                        .registrationNumber("ABC-1234")
                        .capacity(8)
                        .status(VehicleStatus.AVAILABLE)
                        .build());
            }

            if (guideRepo.count() == 0) {
                guideRepo.save(Guide.builder()
                        .name("John Doe")
                        .primaryLanguage("English")
                        .available(true)
                        .build());
            }

            if (tripRepo.count() == 0) {
                Trip t = Trip.builder()
                        .title("Morning Safari")
                        .startTime(LocalDateTime.now().plusDays(1).withHour(6).withMinute(0))
                        .endTime(LocalDateTime.now().plusDays(1).withHour(10).withMinute(0))
                        .status(TripStatus.SCHEDULED)
                        .build();
                tripRepo.save(t);
            }
        };
    }
}
