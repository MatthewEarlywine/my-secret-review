package com.liftoff.mysecretreview.data;


import com.liftoff.mysecretreview.auth.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends CrudRepository<ApplicationUser, Integer> {

    Optional<ApplicationUser> findByUsername(String username);

}
