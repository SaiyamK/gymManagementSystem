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

import com.gym.entities.GymAdmin;
import com.gym.repository.GymRepository;
import com.gym.service.GymService;

@ExtendWith(MockitoExtension.class)
public class TestGymAdmin {

	@InjectMocks
	private GymService uservice;
	
	@Mock
	private GymRepository uRepo;
	
	@Test
	public final void testAddGym() {	
		GymAdmin user=new GymAdmin(1L, "Saiyam Gym", "Delhi");
		when(uRepo.save(user)).thenReturn(user);
		String message=uservice.addGymAdmin(user);
		assertNotNull(message);
		assertEquals(message, "Gym admin added successfully");
	}
	
	@Test
    public final void testGetAllGym() {
		GymAdmin user = new GymAdmin(1L, "Saiyam Gym", "Delhi");
        when(uRepo.findAll()).thenReturn(Arrays.asList(user));
        List<GymAdmin> uList = uservice.getAllGymAdmins();
        assertEquals(1, uList.size());
        assertEquals(user.getName(), uList.get(0).getName());
        assertEquals(user.getLocation(), uList.get(0).getLocation());
    }
	
}