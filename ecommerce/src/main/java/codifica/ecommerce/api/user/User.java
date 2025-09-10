package codifica.ecommerce.api.user;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "User") // Define que esta classe é uma entidade JPA
@Table(name = "users") // Mapeia para a tabela "users" no banco de dados
@Getter // Lombok: gera os getters para todos os campos
@Setter
@NoArgsConstructor // Lombok: gera um construtor sem argumentos (requerido pelo JPA)
@AllArgsConstructor // Lombok: gera um construtor com todos os argumentos
@EqualsAndHashCode(of = "id") // Lombok: gera equals() e hashCode() baseados apenas no ID
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "provider_id")
    private String providerId;

    private String provider;

    private String role;

    public User(String name, String email, String provider, String providerId) {
        this.name = name;
        this.email = email;
        this.provider = provider;
        this.providerId = providerId;
        this.role = "ROLE_USER";
    }
}