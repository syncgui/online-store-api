package github.syncgui.onlinestoreapi.repositories;

import github.syncgui.onlinestoreapi.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
