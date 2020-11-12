package com.techsharezone.bootifycrudm.repository;

/*
 * @created 12/11/2020 -13:43
 * @project bootify-crud-mongodb
 * @author  saurabhshcs
 */

import com.techsharezone.bootifycrudm.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
