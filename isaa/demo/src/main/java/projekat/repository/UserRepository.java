package projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projekat.model.Role;
import projekat.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findAllByRole(Role staff);

}
