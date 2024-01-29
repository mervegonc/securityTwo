package learn.process.sSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	private final UserDetailsServiceImpl userDetailsService;
	private final PasswordEncoder passwordEncoder;

	public SecurityConfig(UserDetailsServiceImpl userDetailsService, PasswordEncoder passwordEncoder) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	// BCryptPasswordEncoder bean'ini döndüren metot.
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();// salt-tuzlama
	}

	// Güvenlik filtresi zincirini yapılandıran metot.
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> {
			csrf.disable();
		}).cors(cors -> cors.disable()).authorizeHttpRequests(auth -> {
			auth.requestMatchers("/signup/**").permitAll();
			auth.requestMatchers("/login/**").permitAll(); // /login/** yolu herkese açıktır.
			auth.anyRequest().authenticated(); // Diğer tüm istekler için kimlik doğrulama gerekir.
		}).build();
	}

}
