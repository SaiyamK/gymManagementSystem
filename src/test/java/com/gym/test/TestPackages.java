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

import com.gym.entities.Packages;
import com.gym.repository.PackageRepository;
import com.gym.service.PackageService;

@ExtendWith(MockitoExtension.class)
public class TestPackages {

	@InjectMocks
	private PackageService uservice;

	@Mock
	private PackageRepository uRepo;

	@Test
	public final void testAddEmployee() {
		Packages user=new Packages(1L, "Plastic", 1000, false);
		when(uRepo.save(user)).thenReturn(user);
		String message=uservice.addPackage(user);
		assertNotNull(message);
		assertEquals(message, "Package added successfully");
	}

	@Test
    public final void testGetAllEmployee() {
		Packages user = new Packages(1L, "Plastic", 1000, false);
        when(uRepo.findAll()).thenReturn(Arrays.asList(user));
        List<Packages> uList = uservice.getAllPackages();
        assertEquals(1, uList.size());
        assertEquals(user.getPackageName(), uList.get(0).getPackageName());
        assertEquals(user.getPackageFees(), uList.get(0).getPackageFees());
        assertEquals(user.isMealIncluded(), uList.get(0).isMealIncluded());
    }

}