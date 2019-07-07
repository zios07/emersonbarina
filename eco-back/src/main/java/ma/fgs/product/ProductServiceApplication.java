package ma.fgs.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.fgs.product.domain.Role;
import ma.fgs.product.repository.RoleRepository;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		if (repository.count() == 0) {
			Role role = new Role("ADMIN", "Administrator");
			Role role2 = new Role("USER", "User");
			repository.save(role);
			repository.save(role2);
		}
	}

}
