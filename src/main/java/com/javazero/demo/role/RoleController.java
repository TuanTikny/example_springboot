package com.javazero.demo.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/roles")
	public List<Role> getTodoList(@RequestParam Integer limit) {
		return roleService.findAll(limit);
	}

	@GetMapping("/role/{roleId}")
	public Role getrole(@PathVariable(name = "roleId") Integer roleId) throws Exception {
		return roleService.findById(roleId);
	}

	@PostMapping("/role")
	public ResponseEntity<Role> addrole(@RequestBody Role role) throws Exception {
		Role newrole = roleService.add(role);
		return ResponseEntity.ok().body(newrole);
	}

	@DeleteMapping("/role/{roleId}")
	public int deleterole(@PathVariable(name = "roleId") Integer roleId) throws Exception {
		return roleService.remove(roleId);
	}
}
