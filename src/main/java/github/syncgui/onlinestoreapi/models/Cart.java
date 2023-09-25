package github.syncgui.onlinestoreapi.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "carts")
        public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    private List<Product> products;

    private Double totalAmount;

    public Cart() {
    }

    public Cart(User user, List<Product> products, Double totalAmount) {
        this.user = user;
        this.products = products;
        this.totalAmount = totalAmount;
    }

    public Cart(Long id, User user, List<Product> products, Double totalAmount) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) && Objects.equals(user, cart.user) && Objects.equals(products, cart.products) && Objects.equals(totalAmount, cart.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, products, totalAmount);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
