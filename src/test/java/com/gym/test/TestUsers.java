package com.gym.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gym.entities.Users;
import com.gym.repository.UserRepository;
import com.gym.service.UserService;

@ExtendWith(MockitoExtension.class)
public class TestUsers {

	@InjectMocks
	private UserService uservice;

	@Mock
	private UserRepository uRepo;

	@Test
	public final void testAddEmployee() {
		Users user=new Users("Saiyam", "saiyam@gmail.com", "9876543210");
		when(uRepo.save(user)).thenReturn(user);
		String message=uservice.addUser(user);
		assertNotNull(message);
		assertEquals(message, "User added successfully");
	}

	@Test
    public final void testGetAllEmployee() {
        Users user = new Users("Saiyam", "saiyam@gmail.com", "9876543210");
        when(uRepo.findAll()).thenReturn(Arrays.asList(user));
        List<Users> uList = uservice.getAll();
        assertEquals(1, uList.size());
        assertEquals(user.getName(), uList.get(0).getName());
        assertEquals(user.getEmail(), uList.get(0).getEmail());
        assertEquals(user.getPhoneNo(), uList.get(0).getPhoneNo());
    }

}