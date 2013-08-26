

import java.net.MalformedURLException;

import org.springframework.security.core.userdetails.UserDetails;

import com.caucho.hessian.client.HessianProxyFactory;
import com.wonders.security.service.UserService;

public class UserServiceRemotingTest {

	public static void main(String[] args) {
		String url = "http://localhost:8080/security-webapp/userService";

		HessianProxyFactory factory = new HessianProxyFactory();
		try {
			UserService userService = (UserService) factory.create(UserService.class, url);
			UserDetails userDetails = userService.loadUserByUsername("wangqiang");
			userService.modifyPassword(1, "123456");
			System.out.println("userDetails ============ " + userDetails);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
