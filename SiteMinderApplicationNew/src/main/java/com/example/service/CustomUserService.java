/*ackage com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.model.CustomUser;
import com.example.model.Role;


public class CustomUserService implements UserDetailsService {

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Write your DB call code to get the user details(user and roles) from
		// DB ,But I am just hard coding it.
		System.out.println("USER_NAMEEEEEEEEEEEEE="+username);
		CustomUser user = new CustomUser();
		System.out.println("In CustomUserService:"+username);
		user.setFirstName("kb");
		user.setLastName("gc");
		user.setUsername("kb");
		user.setPassword("1234");
		Role r = new Role();
		r.setName("ROLE_USER");
		List<Role> roles = new ArrayList<Role>();
		System.out.println("User Roles:"+roles);
		roles.add(r);
		System.out.println("In CustomUserService:"+user.getUsername());
		user.setAuthorities(roles);
		return user;
	}


	
}
*/