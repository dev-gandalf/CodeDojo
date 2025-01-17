package com.groupone.shazar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupone.shazar.model.Picture;
import com.groupone.shazar.repository.PictureRepository;

@Service
public class PictureServiceImpl implements PictureService{
	private PictureRepository repo;
	
	@Autowired
	public PictureServiceImpl(PictureRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public Picture getPictureById(int id) {
		return repo.getById(id);
	}

	@Override
	public void savePicture(Picture picture) {
		repo.save(picture);
	}

}
