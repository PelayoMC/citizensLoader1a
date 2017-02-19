package dbupdate;

import org.springframework.data.jpa.repository.JpaRepository;

import model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail (String email);
	User findByDni (String dni);
}
