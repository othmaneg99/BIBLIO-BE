package dba.biblio.entities;

import dba.biblio.enums.UserRoles;
import lombok.*;


import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Abonne {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRoles userRoles = UserRoles.USER;
    private Boolean enabled;
    private Boolean locked;


}


