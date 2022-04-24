package com.app.ELearning.DAO;

import com.app.ELearning.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer> {
    Optional<Admin> findAdminByUsername(String username);

    Optional<Admin> findAdminByUsernameAndPassword(String username, String password);
}
