package com.ynmio.Thimeleaf.dao;

import com.ynmio.Thimeleaf.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User ,Integer> {
}
