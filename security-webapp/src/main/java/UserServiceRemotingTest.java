import java.net.MalformedURLException;

import org.springframework.security.core.userdetails.UserDetails;

import com.caucho.hessian.client.HessianProxyFactory;
import com.wonders.security.entity.User;
import com.wonders.security.service.UserService;

public class UserServiceRemotingTest {

	public static void main(String[] args) {
		String url = "http://localhost:8080/security-webapp/userService";

		HessianProxyFactory factory = new HessianProxyFactory();
		try {
			UserService userService = (UserService) factory.create(UserService.class, url);
			UserDetails userDetails = userService.loadUserByUsername("wangqiang");
			System.out.println("userDetails ============ " + userDetails);
			
			userService.modifyPassword(1, "123456");
			
			User user = userService.removeRolesFromUser(1, 1, 2, 4);
			System.out.println("user ============ " + user);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
