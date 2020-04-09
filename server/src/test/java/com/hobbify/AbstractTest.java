package com.hobbify;

import com.hobbify.model.Authority;
import com.hobbify.model.CustomUser;
import com.hobbify.model.UserRoleName;
import com.hobbify.repository.UserRepository;
import com.hobbify.security.auth.AnonAuthentication;
import com.hobbify.security.auth.TokenBasedAuthentication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith( SpringRunner.class )
@SpringBootTest(classes = { Application.class })
public abstract class AbstractTest {

	@Autowired
	protected UserRepository userRepository;

	@Autowired
	protected ObjectMapper objectMapper;

	@Before
	public final void beforeAbstractTest() {
		securityContext = Mockito.mock( SecurityContext.class );
		SecurityContextHolder.setContext( securityContext );
		Mockito.when( securityContext.getAuthentication() ).thenReturn( new AnonAuthentication() );
	}

	@After
	public final void afterAbstractTest() {
		SecurityContextHolder.clearContext();
	}

	protected SecurityContext securityContext;

	protected void mockAuthenticatedUser( CustomUser customUser) {
		mockAuthentication( new TokenBasedAuthentication(customUser) );
	}

	private void mockAuthentication( TokenBasedAuthentication auth ) {
		auth.setAuthenticated( true );
		Mockito.when( securityContext.getAuthentication() ).thenReturn( auth );
	}

    protected CustomUser buildTestAnonUser() {
        CustomUser customUser = new CustomUser();
        customUser.setUsername("user");
        return customUser;
    }

	protected CustomUser buildTestUser() {

		CustomUser customUser = new CustomUser();
		Authority userAuthority = new Authority();
		userAuthority.setName( UserRoleName.ROLE_USER );
		List<Authority> userAuthorities = new ArrayList<>();
		userAuthorities.add(userAuthority);
		customUser.setUsername("user");
		customUser.setAuthorities(userAuthorities);
		return customUser;
	}


    protected CustomUser buildTestAdmin() {
        Authority userAuthority = new Authority();
        Authority adminAuthority = new Authority();
        userAuthority.setName( UserRoleName.ROLE_USER );
        adminAuthority.setName( UserRoleName.ROLE_ADMIN );
        List<Authority> adminAuthorities = new ArrayList<>();
        adminAuthorities.add(userAuthority);
        adminAuthorities.add(adminAuthority);
        CustomUser admin = new CustomUser();
        admin.setUsername("admin");
        admin.setAuthorities(adminAuthorities);
        return admin;
    }


}