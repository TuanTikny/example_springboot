package com.javazero.demo.role;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleValidator validator;

	public List<Role> findAll(Integer limit) {

		return Optional.ofNullable(limit).map(value -> roleRepository.findAll(PageRequest.of(0, value)).getContent())
				.orElseGet(() -> roleRepository.findAll());
	}

	public Role findById(Integer roleId) throws Exception {

		Role role = roleRepository.findById(roleId);
		if (role == null) {
			throw new Exception("Can't find the Todo");
		}

		return role;
	}

	public Role add(Role role) throws Exception {

		if (validator.isValid(role)) {
			return roleRepository.save(role);
		}

		throw new Exception("Validation role");
	}
	
	public int remove(Integer roleId) throws Exception {

		Integer flagRm = roleRepository.deleteById(roleId);

		if (flagRm <= 0) {
			throw new Exception("The role is not exits");
		}

		return flagRm;
	}

}