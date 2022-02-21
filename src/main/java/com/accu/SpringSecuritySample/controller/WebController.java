package com.accu.SpringSecuritySample.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accu.SpringSecuritySample.Repository.AuthoritiesRepository;
import com.accu.SpringSecuritySample.entity.Authorities;

// I need this annotation to make this get picked up by spring for webpage
// request
// also the session stuff so I can use it in other pages
@Controller
public class WebController {
	private static final Logger log = LoggerFactory.getLogger(WebController.class);

	@Autowired
	AuthoritiesRepository authoritiesRepository;

	/**
	 * @param model
	 * @return
	 * @implNote I had to use isFullyAuthenticated() in PreAuthorize so the login
	 *           Credentials are all gone and new login is required
	 */
	@PreAuthorize("isFullyAuthenticated() and hasAuthority('ADMIN') or hasAuthority('EDITOR')")
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String userlist(ModelMap model) {
		log.debug("In userList method");

		String username = "none";
		String userrole = "none";
		SecurityContext securityContext = SecurityContextHolder.getContext();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// when Anonymous Authentication is enabled
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			username = securityContext.getAuthentication().getName();
			userrole = auth.getAuthorities().toString();
			log.debug("Already logged in Name: " + username);
			log.debug("Already logged in Role: " + userrole);
		} else {
			log.debug("Not logged in!");
		}
		model.addAttribute("username", username + "/" + userrole);

		Iterable<Authorities> authorities = authoritiesRepository.findAll();
		model.addAttribute("authoritiesTable1", authorities);

		return "userList";
	}

	/**
	 * @param model
	 * @return
	 * 
	 * @implNote I had to use isFullyAuthenticated() in PreAuthorize so the login
	 *           Credentials are all gone and new login is required
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String weclome(ModelMap model) {
		log.debug("In welcome method");

		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		String username = authentication.getName();
		Object principal = authentication.getPrincipal();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		String userrole = authorities.toString();

		// when Anonymous Authentication is enabled
		if (username != null) {
			log.debug("Already logged in Name: " + username);
			log.debug("Already logged in Role: " + userrole);
		} else {
			log.debug("Not logged in!");
		}
		model.addAttribute("username", username + "/" + userrole);

		String tmp1 = "Welcome " + username;
		model.addAttribute("dynamicPageTitle", tmp1);

		return "welcome";
	}
}
