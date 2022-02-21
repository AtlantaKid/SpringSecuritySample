package com.accu.SpringSecuritySample.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * @author anoosh atari
 * @apiNote I need to have this with series of annotation so I can enforce
 *          security on any method I want using the ROLE of the user
 * @see the info came from here
 *      https://www.baeldung.com/spring-security-method-security
 *
 */
@Configuration
@EnableAspectJAutoProxy
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

}