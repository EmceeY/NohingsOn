package com.github.EmceeY.models.data;

import com.github.EmceeY.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by User on 4/23/17.
 */
public interface UserDao extends CrudRepository<User, Integer> {
}