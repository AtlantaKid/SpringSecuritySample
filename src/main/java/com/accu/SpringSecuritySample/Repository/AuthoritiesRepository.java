package com.accu.SpringSecuritySample.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.accu.SpringSecuritySample.entity.Authorities;

@Repository
@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {

}
