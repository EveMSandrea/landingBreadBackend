package com.landingbread.backend.landingbread.controllers;
/*A controller is a spring component
*is responsible for managing requests in the client_environment and server_environment
*this communicates with the model and the service*/

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.landingbread.backend.landingbread.entities.User;
import com.landingbread.backend.landingbread.services.UserService;


@CrossOrigin(origins={"http://localhost:4200/"})
@RestController
@RequestMapping("users-rest")
public class UserController {

private UserService service;

public UserController(UserService service) {
  this.service = service;
}

@GetMapping
public List<User> list() {
  return service.findAll();
}


  /**
   * <p>This is a method i used to obtain a specific user given an Id.
   * </p>
   * @param id the identity the User
   * @return the whole User
   * @see <a href="http://www.link_to_jira/HERO-402">Jira-402</a>
   * @since 1.0
   */
@GetMapping("/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
  Optional<User> userOptional = service.findById(id);
    if (userOptional.isPresent()) {
    return ResponseEntity.status(HttpStatus.OK).body(userOptional.orElseThrow());
  }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
}

  /**
   * <p>This is a method i used to create new user.
   * </p>
   * @param user incoming from client
   * @return the entire new  User
   * @see <a href="http://www.link_to_jira/HERO-403">Jira-403</a>
   * @since 1.0
   */
@PostMapping
public ResponseEntity<User> createNewUser(@RequestBody User user) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
}

@PutMapping("/{id}")
public ResponseEntity<User> updateExistingUser(@PathVariable Long id, @RequestBody User user) {
  Optional<User> userOptional = service.findById(id);
  if (userOptional.isPresent()) {
    User userDb = userOptional.get();
    userDb.setName(user.getName());
    userDb.setLastName(user.getLastName());
    userDb.setEmail(user.getEmail());
    userDb.setUsername(user.getUserName());
    userDb.setPassword(user.getPassword());
    return ResponseEntity.ok(service.save(userDb));
}
    return ResponseEntity.notFound().build();
}

@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) {
  Optional<User> userOptional = service.findById(id);
  if (userOptional.isPresent()) {
  service.deleteById(id);
    return ResponseEntity.noContent().build();
  }
    return ResponseEntity.notFound().build();
  }
}
