package com.groupone.shazar.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.groupone.shazar.model.Picture;
import com.groupone.shazar.repository.PictureRepository;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class PictureServiceTests {
	@InjectMocks
	private PictureServiceImpl pictureService;
	
	@MockBean
	private PictureRepository pictureRepository;
	
	@BeforeEach
	void setUp() {
		
	}
	
	@Test
	void when_getPictureById() {
		pictureService.getPictureById(1);
		verify(pictureRepository, times(1)).getById(Mockito.anyInt());
	}
	
	@Test
	void when_savePicture() {
		Picture picture = new Picture();
		pictureService.savePicture(picture);
		verify(pictureRepository, times(1)).save(Mockito.any(Picture.class));
	}
}
