package com.landingbread.backend.landingbread.entities;
// El framework ofrece la estrategia de generacion de persistencia
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity  indican que serán persistidas en BD
@Entity
@Table(name = "users") // Nombre de la tabla que almacenara los registros de usuario
// El Objeto User estará mapeado o asignado a esta entidad llamada users
public class User {

@Id
@GeneratedValue(strategy = IDENTITY) // Es para manejar el autoincremental en BD relacional

private Long id;
private String name;
// @Column(lastname="apellidos")convension por Sobreconfiguracion.Cuando un dato no coincide
private String lastName;
// @Transient Si no hay ninguna columna en la tabla con el nombre del campo requerido
private String email;
private String userName;
private String password;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getUserName() {
    return userName;
}

public void setUsername(String userName) {
    this.userName = userName;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}
}
