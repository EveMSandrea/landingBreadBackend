package com.landingbread.backend.landingbread.entity;

import com.landingbread.backend.landingbread.entities.User;
import com.landingbread.backend.landingbread.repositories.UserRepository;
import com.landingbread.backend.landingbread.services.UserImplementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserImplementServiceTest {
   @InjectMocks
    private UserImplementService userImplementService;

    @Mock
    private UserRepository repository;


    @Test
    public void shouldFindAllUser() {

        User user = new User();

        user.setId(10L);
        user.setName("Eve");
        user.setLastName("Melendez");
        user.setEmail("eved@gmail.com");
        user.setUsername("MelendezA");
        user.setPassword("122345566544585");

        List<User> lstUser = new ArrayList<>();
        lstUser.add(user);
        when(repository.findAll()).thenReturn(lstUser);

        List<User> userList =userImplementService.findAll();
        assertNotNull(userList);
        assertEquals(1, userList.size());



    }

}
