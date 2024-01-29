package learn.process.sSecurity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	private final UserDetailsServiceImpl userDetailsService;
	private final PasswordEncoder passwordEncoder;
	private UserRepository userRepository;

	public AuthController(UserDetailsServiceImpl userDetailsService, PasswordEncoder passwordEncoder,
			UserRepository userRepository) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
	}

	@PostMapping("/signup")
	public String signUp(@RequestBody SignupRequest signupRequest) {
		// Kullanıcı adının veritabanında mevcut olup olmadığını kontrol et
		// logic
		if (userRepository.existsByUsername(signupRequest.getUsername())) {
			return "Kullanıcı adı zaten kullanımda!";
		}

		// Yeni kullanıcı oluştur
		User user = new User();
		user.setUsername(signupRequest.getUsername());
		user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

		// Kullanıcıyı veritabanına kaydet
		userRepository.save(user);

		return "Kullanıcı kaydı başarılı!";
	}

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		UserDetails user = userDetailsService.loadUserByUsername(loginRequest.getUsername());

		if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
			return "Login successful!";
		} else {
			return "Invalid username or password";
		}
	}
}
