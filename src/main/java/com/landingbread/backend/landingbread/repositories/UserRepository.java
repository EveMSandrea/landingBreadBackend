package com.landingbread.backend.landingbread.repositories;
/*Spring framework provee una configuarcion JPA Data llamada CRUD repository
 * con toda la configuración necesaria para implementar un CRUD */
import org.springframework.data.repository.CrudRepository;
import com.landingbread.backend.landingbread.entities.User;


public interface UserRepository extends CrudRepository<User,Long> {

}
