package org.xindus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.xindus.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

//	as HTTPBasic has Username, I am using email in turn for the username and using that for authentication purpose
	@Query("select u from User u where u.email=?1")
	Optional<User> findByName(String email);

}
