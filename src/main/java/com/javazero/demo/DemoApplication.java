package com.javazero.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {

	public static void main(String[] args) {
//    ApplicationContext context = 
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("This Project Zero");

//    UserRepository userRepository = context.getBean(UserRepository.class);
//    
//    try {
//    	User user = userRepository.findByStamina(7);
//    	
//        user.setStamina(4);
//        userRepository.save(user);
//    } catch (Exception ex) {
//    	  System.out.println("can't find this user");
//    }
//    
//    List<User> users = userRepository.findAllByStamina(4);
//
//    users.forEach(System.out::println);

		// // Lấy ra toàn bộ user trong db
		// userRepository.findAll().forEach(System.out::println);

		// // Lưu user xuống database
		// User user = userRepository.save(new User());
		// // Khi lưu xong, nó trả về User đã lưsu kèm theo Id.
		// System.out.println("User vừa lưu có ID: " + user.getId());
		// Long userId = user.getId();
		// // Cập nhật user.
		// user.setAgi(100);
		// // Update user
		// // Lưu ý, lúc này đối tượng user đã có Id.
		// // Nên nó sẽ update vào đối tượng có Id này
		// // chứ không insert một bản ghi mới
		// userRepository.save(user);

		// // Query lấy ra user vừa xong để kiểm tra xem.
		// User user2 = userRepository.findById(userId).get();
		// System.out.println("User: " + user);
		// System.out.println("User2: " + user2);

		// // Xóa User khỏi DB
		// userRepository.delete(user);

		// User user3 = userRepository.findById(userId).orElse(null);
		// System.out.println("User3: " + user3);
	}

}
