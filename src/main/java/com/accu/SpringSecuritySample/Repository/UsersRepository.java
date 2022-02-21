package com.accu.SpringSecuritySample.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.accu.SpringSecuritySample.entity.Users;

@Repository
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UsersRepository extends CrudRepository<Users, Long> {

	List<Users> findByFirstname(String firstname);

	List<Users> findByLastname(String lastname);

	List<Users> findByLastnameContaining(String lastname);

	List<Users> findByLastnameIsContaining(String lastname);

	List<Users> findByLastnameLike(String lastname);

	// say we want to find all the employees with space in their last name
	List<Users> findEmployeeByLastnameContaining(String str);

}
