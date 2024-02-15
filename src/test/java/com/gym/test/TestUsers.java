package com.gym.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
	public final void testAddUsers() {
		Users user=new Users("Saiyam", "saiyam@gmail.com", "9876543210");
		when(uRepo.save(user)).thenReturn(user);
		String message=uservice.addUser(user);
		assertNotNull(message);
		assertEquals(message, "User added successfully");
	}

	@Test
    public final void testAllUsers() {
        Users user = new Users("Saiyam", "saiyam@gmail.com", "9876543210");
        when(uRepo.findAll()).thenReturn(Arrays.asList(user));
        List<Users> uList = uservice.getAll();
        assertEquals(1, uList.size());
        assertEquals(user.getName(), uList.get(0).getName());
        assertEquals(user.getEmail(), uList.get(0).getEmail());
        assertEquals(user.getPhoneNo(), uList.get(0).getPhoneNo());
    }

	@Test
	public final void testUpdateUser() {
		
		Users user = new Users(1L,"Saiyam", "saiyam@gmail.com", "9876543210");
		Users update_user = new Users(1L,"Saiyam", "saiyam@gmail.com", "9876543210");
		when(uRepo.findById(1L)).thenReturn(Optional.of(user));
		String message = uservice.updateUser(1L, update_user);
		assertEquals(update_user.getName(), user.getName());
		assertEquals(update_user.getEmail(), user.getEmail());
		assertEquals(update_user.getPhoneNo(), user.getPhoneNo());
		
		assertEquals(message,"User updated successfully");
	
	}
	
	@Test
	public final void testDeleteUser() {
		Long userId = 1L;
		Users user = new Users(1L,"Saiyam", "saiyam@gmail.com", "9876543210");
		when(uRepo.findById(1L)).thenReturn(Optional.of(user));
		String message=uservice.deleteUser(1L);
		assertEquals("User deleted successfully", message);
		verify(uRepo, times(1)).findById(userId);
		verify(uRepo,times(1)).deleteById(userId);
		
	}

   
}
	

	
