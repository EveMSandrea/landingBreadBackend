package com.landingbread.backend.landingbread.services;
/*Service maneja la logica de negocio JPA Data proporciona una interface
 * para manejar los metodos de manera transaccional
 */
import java.util.List;
import java.util.Optional;

import com.landingbread.backend.landingbread.entities.User;

public interface UserService {
    List<User> findAll();// Devuelve una lista de tipo User de pakques Entity

    Optional<User> findById(Long id);// Busca y devuelve el id del usuario si no la consigue esta el opcional

    User save(User user);// Recibe el usuario para modificar y guarda los cambios(Update-Insert)

    void deleteById(Long id);// Eliminar por el atributo Id
}
