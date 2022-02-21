package com.accu.SpringSecuritySample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.accu.SpringSecuritySample.Repository.AuthoritiesRepository;
import com.accu.SpringSecuritySample.Repository.UsersRepository;
import com.accu.SpringSecuritySample.entity.Authorities;
import com.accu.SpringSecuritySample.entity.Users;

@SpringBootApplication
public class SpringSecuritySampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritySampleApplication.class, args);
	}

	/*
	 * to run this app do ./mvnw spring-boot:run this app created a database in h2
	 * inserts data and shows you how to implement custom search to look for
	 * records.
	 */

	@Bean
	public CommandLineRunner run(UsersRepository usersRepository, AuthoritiesRepository authoritiesRepository) {
		return (args -> {
			AddRecords(usersRepository, authoritiesRepository);

			System.out.println("--- FindAll() ---");
			System.out.println(usersRepository.findAll());

			System.out.println("--- findByLastname() ---");
			System.out.println(usersRepository.findByLastname("Atari"));
		});

	}

	/*
	 * this private method is used to insert data into the H2 database using JPA
	 */

	private void AddRecords(UsersRepository usersRepository, AuthoritiesRepository authoritiesRepository) {
		
		/*
		 * Userid to login is: jon1
		 * password: test123@
		 */
		
		Users users = new Users("Jon", "Smith", "jon1",
				"$2a$10$k4.ilzDlkE2PIqSBuF3jv.u4GWmt2AmpzAUQSd8FoPenFGNBRb.yG", "javaApp", "test123@");
		usersRepository.save(users);
		
		Authorities authorities = new Authorities();
		authorities.setAuthority("ROLE_ADMIN");
		authorities.setUsers(users);
		authoritiesRepository.save(authorities);

		authorities = new Authorities();
		authorities.setAuthority("ROLE_EDITOR");
		authorities.setUsers(users);
		authoritiesRepository.save(authorities);

		authorities = new Authorities();
		authorities.setAuthority("ROLE_CALLCENTER");
		authorities.setUsers(users);
		authoritiesRepository.save(authorities);
		
		authorities = new Authorities();
		authorities.setAuthority("ROLE_USER");
		authorities.setUsers(users);
		authoritiesRepository.save(authorities);
	}

}
