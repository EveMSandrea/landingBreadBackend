package com.landingbread.backend.landingbread.entity;

import com.landingbread.backend.landingbread.entities.User;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import com.landingbread.backend.landingbread.repositories.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserEntityTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldSaveUser() {
        User user = new User();

        user.setId(10L);
     user.setName("Eve");
     user.setLastName("Melendez");
     user.setEmail("eved@gmail.com");
     user.setUsername("MelendezA");
     user.setPassword("122345566544585");
     User userN = userRepository.save(user);
 assertNotNull(userN.getId());
 assertEquals(user.getName(), userN.getName());
 assertEquals(user.getLastName(), userN.getLastName());
 assertEquals(user.getEmail(), userN.getEmail());
 assertEquals(user.getUserName(), userN.getUserName());
 assertEquals(user.getPassword(), userN.getPassword());

}
@Test
    public void shouldUpdateUser() {
        Optional<User>  userNewOptional = userRepository.findById(1L);
        assertEquals(true, userNewOptional.isPresent());
        User userNew = userNewOptional.get();
        assertEquals("paulina", userNew.getName());
        assertEquals("paulouspyth", userNew.getLastName());
        assertEquals("paulistotira@hotmail", userNew.getEmail());
        assertEquals("puapupaippai", userNew.getUserName());
        assertEquals("45612558848855", userNew.getPassword());
    }
}