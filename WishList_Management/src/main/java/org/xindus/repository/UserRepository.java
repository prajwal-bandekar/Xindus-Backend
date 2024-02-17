package org.xindus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xindus.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByName(String username);

}
