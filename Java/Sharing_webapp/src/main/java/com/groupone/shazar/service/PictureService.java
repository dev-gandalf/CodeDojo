package com.groupone.shazar.service;



import com.groupone.shazar.model.Picture;

public interface PictureService {
	//List<Picture> getAllPictures();
	Picture getPictureById(int id);
	void savePicture(Picture picture);	
}
