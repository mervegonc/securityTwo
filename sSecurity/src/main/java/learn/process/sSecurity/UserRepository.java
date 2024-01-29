package learn.process.sSecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

	// Yeni bir kullanıcıyı kaydetmek için metot
	@Override
	User save(User user);

	// Kullanıcı adını kontrol etmek için metot
	boolean existsByUsername(String username);
}
