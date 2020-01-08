package com.solt.bootonlinestore.config;

import com.solt.bootonlinestore.domain.Role;
import com.solt.bootonlinestore.domain.User;
import com.solt.bootonlinestore.repository.RoleRepository;
import com.solt.bootonlinestore.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DBLoadoader {

  /*  private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public DBLoadoader(RoleRepository roleRepository, UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    @Override @Transactional
    public void run(String... args) throws Exception {

        Role adminRole=new Role();
        adminRole.setName("ROLE_ADMIN");
        Role userRole=new Role();
        userRole.setName("ROLE_USER");


        User adminUser=new User();
        adminUser.setEmail("kyaw@gmail.com");
        adminUser.setPassword(bCryptPasswordEncoder.encode("kyaw"));
        adminUser.getRoles().add(adminRole);
        adminUser.getRoles().add(userRole);
        adminRole.getUserList().add(adminUser);
        userRole.getUserList().add(adminUser);

        User userUser=new User();
        userUser.setEmail("thaw@gmail.com");
        userUser.setPassword(bCryptPasswordEncoder.encode("thaw"));
        userUser.getRoles().add(userRole);
        userRole.getUserList().add(userUser);

       roleRepository.save(adminRole);
        roleRepository.save(userRole);
        userRepository.save(adminUser);
        userRepository.save(userUser);




    }

   */

}
