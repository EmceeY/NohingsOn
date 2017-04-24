package com.github.EmceeY.models.data;

import com.github.EmceeY.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by User on 4/23/17.
 */
@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
}
