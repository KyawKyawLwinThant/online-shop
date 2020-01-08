package com.solt.bootonlinestore.repository;

import com.solt.bootonlinestore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
        User findByEmail(String email);
}
