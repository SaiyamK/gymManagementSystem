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

import com.gym.entities.Trainer;
import com.gym.repository.TrainerRepository;
import com.gym.service.TrainerService;

@ExtendWith(MockitoExtension.class)
public class TestTrainer {

	@InjectMocks
	private TrainerService tservice;

	@Mock
	private TrainerRepository tRepo;

	@Test
	public final void testAddEmployee() {
		Trainer user=new Trainer(1L, "Kuldeep", "9876543210", "Weight", null);
		when(tRepo.save(user)).thenReturn(user);
		String message=tservice.addTrainer(user);
		assertNotNull(message);
		assertEquals(message, "Trainer added successfully");
	}

	@Test
    public final void testGetAllEmployee() {
		Trainer user = new Trainer(1L, "Kuldeep", "9876543210", "Weight", null);
        when(tRepo.findAll()).thenReturn(Arrays.asList(user));
        List<Trainer> uList = tservice.getAllTrainer();
        assertEquals(1, uList.size());
        assertEquals(user.getTrainerName(), uList.get(0).getTrainerName());
        assertEquals(user.getSpecialization(), uList.get(0).getSpecialization());
        assertEquals(user.getPhoneNo(), uList.get(0).getPhoneNo());
    }
	
	@Test
	public final void testUpdateTrainer() {
		
		Trainer user = new Trainer(1L, "Kuldeep", "9876543210", "Weight", null);
		Trainer update_trainer = new Trainer(1L,"Kuldeep Singh","9876541234","Power Lifting");
		when(tRepo.findById(1L)).thenReturn(Optional.of(user));
		String message = tservice.updateTrainer(1L, update_trainer);
		assertEquals(update_trainer.getTrainerName(), user.getTrainerName());
		assertEquals(update_trainer.getSpecialization(), user.getSpecialization());
		assertEquals(update_trainer.getPhoneNo(), user.getPhoneNo());
		
		assertEquals(message,"Trainer updated successfully");
	}
	
	@Test
	public final void testDeleteTrainer() {
		Long trainerID = 1L;
		Trainer trainer = new Trainer(1L,"Kuldeep Singh","9876541234","Power Lifting");
		when(tRepo.findById(1L)).thenReturn(Optional.of(trainer));
		String message=tservice.deleteTrainer(trainerID);
		assertEquals("Trainer deleted successfully", message);
		verify(tRepo, times(1)).findById(trainerID);
		verify(tRepo,times(1)).deleteById(trainerID);
		
	}

}