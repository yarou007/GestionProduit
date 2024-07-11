package com.gestion.g04.security.services;

import com.gestion.g04.security.entities.Role;
import com.gestion.g04.security.entities.User;
import com.gestion.g04.security.repositories.RoleRepository;
import com.gestion.g04.security.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@AllArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService{
   /*
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
*/
   private UserRepository userRepository;
    private RoleRepository roleRepository;


    PasswordEncoder passwordEncoder;



    @Override
    public User createUser(String username, String password, String email, String confirmPassword) {
//   1er facon de creé user     User  user = new User();
//        user.setUserId(UUID.randomUUID().toString());
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password));
//        user.setEmail(email);
//        return userRepository.save(user); // 1er façon
//

        // deuxieme façon :
        User user = userRepository.findByUsername(username);
        if (user!=null) throw new RuntimeException("Exist - username already found");
        if (!password.equals(confirmPassword))throw new RuntimeException("Password - password not confirmed");

             user = User.builder()
                    .userId(UUID.randomUUID().toString())
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .email(email)
                    .build();
            return userRepository.save(user);

    }

    @Override
    public Role createRole(String role) {
        Role role1 = roleRepository.findById(role).orElse(null);
        role1 = Role.builder()
              .role(role)
              .build();
      return roleRepository.save(role1);

    }

    @Override
    public void addRoleToUser(String username, String role) {
        User user = userRepository.findByUsername(username);
        Role role1 = roleRepository.findById(role).orElse(null);
        user.getRoles().add(role1);
    }

    @Override
    public void RemoveRoleFromUser(String username, String role) {
        User user = userRepository.findByUsername(username);
        Role role1 = roleRepository.findById(role).orElse(null);
        user.getRoles().remove(role1);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
