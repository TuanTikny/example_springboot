package com.javazero.demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.javazero.demo.category.Category;
import com.javazero.demo.category.CategoryRepository;
import com.javazero.demo.consts.AppConst.CategoryConst;
import com.javazero.demo.consts.AppConst.GenderConst;
import com.javazero.demo.consts.AppConst.PostConst;
import com.javazero.demo.consts.AppConst.RoleConst;
import com.javazero.demo.post.Post;
import com.javazero.demo.post.PostRepository;
import com.javazero.demo.role.Role;
import com.javazero.demo.role.RoleRepository;
import com.javazero.demo.user.User;
import com.javazero.demo.user.UserRepository;
import com.javazero.demo.userprofile.UserProfile;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class SeedData {

	private Logger logger = LoggerFactory.getLogger(SeedData.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	CategoryRepository categoryRepository;

//	@Autowired
//	PasswordEncoder passwordEncoder;
	
	private final static String USER_BUIANHTUAN = "buianhtuan";
	private final static String USER_NGUYENVANBINH = "nguyenvanbinh";
	private final static String USER_VOTHIANH = "vothianh";

	/*
	 * the fuction created 3 data seed Role when table is empty
	 * run 1
	 */
	public void seedRole() throws HibernateException {

		if (roleRepository.findAll().size() <= 0) {
			List<Role> roles = Arrays.asList(
					Role.builder().name(RoleConst.ROOT).build(),
					Role.builder().name(RoleConst.READ).build(), 
					Role.builder().name(RoleConst.WRITE).build());

			roleRepository.saveAll(roles);

		} else {
			List<Role> roles = roleRepository.findAll();
			logger.info("The table role have data! :",roles);
		}

	}

	/*
	 * the fuction created 3 data seed User when table is empty
	 * run 3
	 */
	public void seedUser() throws HibernateException {

		if (userRepository.findAll().size() <= 0) {

			List<Role> fullRoles = Arrays.asList(
					roleRepository.findByName(RoleConst.ROOT),
					roleRepository.findByName(RoleConst.READ), 
					roleRepository.findByName(RoleConst.WRITE));

			List<Role> readAndWriteRoles = Arrays.asList(
					roleRepository.findByName(RoleConst.READ),
					roleRepository.findByName(RoleConst.WRITE));

			List<Role> readRoles = Arrays.asList(
					roleRepository.findByName(RoleConst.READ));

			List<User> users = Arrays.asList(
					User.builder().fullname("Bui Anh Tuan")
					.username(USER_BUIANHTUAN)
					.password("123456")
					.createdAt(DateTime.now().toDate())
					.userProfile(UserProfile.builder().address("Da Nang City").gender(GenderConst.MALE).build())
					.roles(fullRoles)
					.build(),
					User.builder().fullname("Nguyen Van Binh")
					.username(USER_NGUYENVANBINH)
					.password("123456")
					.createdAt(DateTime.now().toDate())
					.userProfile(UserProfile.builder().address("HCM City").gender(GenderConst.MALE).build())
					.roles(readAndWriteRoles)
					.build(),
					User.builder().fullname("Vo Thi Anh")
					.username(USER_VOTHIANH)
					.password("123456")
					.createdAt(DateTime.now().toDate())
					.userProfile(UserProfile.builder().address("Ha Noi City").gender(GenderConst.FEMALE).build())
					.roles(readRoles)
					.build()
					);
			
			userRepository.saveAll(users);
		} else {
			List<User> users = userRepository.findAll();
			logger.info("The table user have data! : ", users);
		}
	}

	/*
	 * the fuction created 3 data seed Category when table is empty
	 * run 2
	 */
	public void seedCategory() throws HibernateException {

		if (categoryRepository.findAll().size() <= 0) {
			List<Category> categorys = Arrays.asList(
					Category.builder().name("Blog về java").typeCategory(CategoryConst.BLOG_JAVA).build(),
					Category.builder().name("Blog về javascript").typeCategory(CategoryConst.BLOG_JAVASCRIPT).build(), 
					Category.builder().name("Blog cuộc sống của dev").typeCategory(CategoryConst.BLOG_DEV).build());

			categoryRepository.saveAll(categorys);

		} else {
			List<Category> categorys = categoryRepository.findAll();
			logger.info("The table category have data!", categorys);
		}

	}

	/*
	 * the fuction created 3 data seed Post when table is empty
	 * run 4
	 */
	public void seedPost() throws HibernateException {

		if (postRepository.findAll().size() <= 0) {

			// Select User assign for Post
			User buiAnhTuan = userRepository.findByUsername(USER_BUIANHTUAN);
			User nguyenVanBinh = userRepository.findByUsername(USER_NGUYENVANBINH);
			User voThiAnh = userRepository.findByUsername(USER_VOTHIANH);
			
			// Select category assign for Post
			Category blogJava = categoryRepository.findByTypeCategory(CategoryConst.BLOG_JAVA);
			Category blogJavaScript = categoryRepository.findByTypeCategory(CategoryConst.BLOG_JAVASCRIPT);
			Category blogDev = categoryRepository.findByTypeCategory(CategoryConst.BLOG_DEV);
			
			List<Post> posts = Arrays.asList(
					Post.builder()
					.title("「Jpa」Hướng dẫn @ManyToMany")
					.modifile(PostConst.PUBLIC)
					.content(PostConst.BLOG_A)
					.user(buiAnhTuan)
					.category(blogJava)
					.build(),
					Post.builder()
					.title("「Jpa」Hướng dẫn sử dụng @OneToOne")
					.modifile(PostConst.PUBLIC)
					.content(PostConst.BLOG_B)
					.user(buiAnhTuan)
					.category(blogJava)
					.build(),
					Post.builder()
					.title("「Jpa」Hướng dẫn @OneToMany và @ManyToOne")
					.modifile(PostConst.PRIVATE)
					.content(PostConst.BLOG_C)
					.user(buiAnhTuan)
					.category(blogJava)
					.build(),
					Post.builder()
					.title("「Hướng dẫn Spring Security + JWT (Json Web Token) + Hibernate")
					.modifile(PostConst.PUBLIC)
					.content(PostConst.BLOG_D)
					.user(nguyenVanBinh)
					.category(blogDev)
					.build(),
					Post.builder()
					.title("Webpack là gì?")
					.modifile(PostConst.PUBLIC)
					.content(PostConst.BLOG_E)
					.user(voThiAnh)
					.category(blogJavaScript)
					.build()
					);

			postRepository.saveAll(posts);

		} else {
			List<Post> post = postRepository.findAll();
			logger.info("The table category have data! : ", post);
		}

	}

}
