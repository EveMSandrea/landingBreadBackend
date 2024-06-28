package com.landingbread.backend.landingbread.services;
/* Es un componente que se va almacenar en el contenedor de spring quien manejará su ciclo de vida
 * tendremos una sola instancia para toda la aplicacion(Singleton)y los metodos que se invocan serán transaccionales,
 * cada usuario que invoque este metodo tendra su propia transaccion-atómica,los service no manejan estado
 * Ejecutan operaciones de acuerdo a los objetos del dominio,transacciones como consulta*/
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.landingbread.backend.landingbread.entities.User;
import com.landingbread.backend.landingbread.repositories.UserRepository;

@Service
public class UserImplementService implements UserService {

  private UserRepository repository;

  public UserImplementService(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<User> findAll() {
    return (List<User>) this.repository.findAll();
  }

  @Override
  @Transactional
  public Optional<User> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  @Transactional
  public User save(User user) {
    return repository.save(user);
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
