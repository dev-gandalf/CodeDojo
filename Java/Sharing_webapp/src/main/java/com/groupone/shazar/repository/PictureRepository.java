package com.groupone.shazar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupone.shazar.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Integer> {

}
