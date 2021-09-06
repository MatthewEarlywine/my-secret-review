package com.liftoff.mysecretreview.data;


import com.liftoff.mysecretreview.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
