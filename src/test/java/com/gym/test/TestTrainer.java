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

import com.gym.entities.Trainer;
import com.gym.repository.TrainerRepository;
import com.gym.service.TrainerService;

@ExtendWith(MockitoExtension.class)
public class TestTrainer {

	@InjectMocks
	private TrainerService uservice;

	@Mock
	private TrainerRepository uRepo;

	@Test
	public final void testAddEmployee() {
		Trainer user=new Trainer(1L, "Kuldeep", "9876543210", "Weight", null);
		when(uRepo.save(user)).thenReturn(user);
		String message=uservice.addTrainer(user);
		assertNotNull(message);
		assertEquals(message, "Trainer added successfully");
	}

	@Test
    public final void testGetAllEmployee() {
		Trainer user = new Trainer(1L, "Kuldeep", "9876543210", "Weight", null);
        when(uRepo.findAll()).thenReturn(Arrays.asList(user));
        List<Trainer> uList = uservice.getAllTrainer();
        assertEquals(1, uList.size());
        assertEquals(user.getTrainerName(), uList.get(0).getTrainerName());
        assertEquals(user.getSpecialization(), uList.get(0).getSpecialization());
        assertEquals(user.getPhoneNo(), uList.get(0).getPhoneNo());
    }

}