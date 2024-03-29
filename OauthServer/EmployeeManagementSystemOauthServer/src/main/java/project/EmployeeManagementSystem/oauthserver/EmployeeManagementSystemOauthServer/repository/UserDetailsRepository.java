package project.EmployeeManagementSystem.oauthserver.EmployeeManagementSystemOauthServer.repository;

import project.EmployeeManagementSystem.oauthserver.EmployeeManagementSystemOauthServer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String name);
}
