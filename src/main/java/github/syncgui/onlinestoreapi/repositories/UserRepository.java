package github.syncgui.onlinestoreapi.repositories;

import github.syncgui.onlinestoreapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
