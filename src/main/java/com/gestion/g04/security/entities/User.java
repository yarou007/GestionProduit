package com.gestion.g04.security.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder //
public class User {

    @Id
    private String userId;

    @Column(unique = true)
    private String username;


    private String password;

    private String email;


    @ManyToMany(fetch = FetchType.EAGER) // lazy -> importer user , n'importer pas les roles avec , ama eager
    private List<Role> roles;
}
