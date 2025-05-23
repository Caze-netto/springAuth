package spring.security.auth.spring.Auth.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="user_password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING) //POSICAO DA ENUM
    @Column(name="role", nullable = false)
    private Role role;
}
