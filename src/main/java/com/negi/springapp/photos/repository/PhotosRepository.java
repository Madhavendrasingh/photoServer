package com.negi.springapp.photos.repository;

import com.negi.springapp.photos.models.photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<photo, Integer> {

}
