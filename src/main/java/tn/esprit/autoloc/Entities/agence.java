package tn.esprit.autoloc.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    @Column(nullable = false, length = 100)
    private String nom;
    @Column(nullable = false, length = 50)
    private String ville;
    @Column(nullable = false, length = 100)
    private String adresse;
    @Column(nullable = false, length = 20)
    private String telephone;
    @OneToMany(mappedBy = "agence")
    private Set<employe> employees;

    @OneToMany(mappedBy = "agence")
    private Set<Vehicule> vehicles;

}


