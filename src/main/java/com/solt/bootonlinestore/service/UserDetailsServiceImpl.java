package com.solt.bootonlinestore.service;

import com.solt.bootonlinestore.domain.Role;
import com.solt.bootonlinestore.domain.User;
import com.solt.bootonlinestore.repository.RoleRepository;
import com.solt.bootonlinestore.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailsServiceImpl(UserRepository userRepository,
                                  RoleRepository roleRepository,
                                  BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }


    public User signup(User user){
        Role userRole=roleRepository.findByName("ROLE_USER");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.getRoles().add(userRole);
        return userRepository.save(user);

    }
}
