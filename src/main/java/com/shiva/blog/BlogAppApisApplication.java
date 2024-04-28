package com.shiva.blog;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shiva.blog.config.AppConstants;
import com.shiva.blog.entities.Category;
import com.shiva.blog.entities.Role;
import com.shiva.blog.repositories.CategoryRepo;
import com.shiva.blog.repositories.RoleRepo;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.passwordEncoder.encode("xyz"));

		try {
			// Creating roles
			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_NORMAL");

			List<Role> roles = List.of(role, role1);

			List<Role> result = this.roleRepo.saveAll(roles);

			result.forEach(r -> {
				System.out.println(r.getName());
			});

			// Creating categories
			Category fashion = new Category("Fashion", "Articles related to the latest fashion trends.");
			Category technology = new Category("Technology",
					"Information about new gadgets, software, and tech trends.");
			Category programming = new Category("Programming",
					"Tutorials, tips, and discussions about programming languages.");
			Category spirituality = new Category("Spirituality",
					"Explore topics related to spiritual growth and practices.");
			Category politics = new Category("Politics", "Analysis and discussions on political events and policies.");

			List<Category> categories = List.of(fashion, technology, programming, spirituality, politics);

			List<Category> savedCategories = this.categoryRepo.saveAll(categories);

			savedCategories.forEach(c -> {
				System.out.println("Category saved: " + c.getCategoryTitle());
			});

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
