package com.negi.springapp.photos.services;

import com.negi.springapp.photos.models.photo;
import com.negi.springapp.photos.repository.PhotosRepository;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    private final PhotosRepository photosRepository;

    public PhotoService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }


    public Iterable<photo> get() {
        return photosRepository.findAll();
    }

    public photo getById(Integer id) {
        return photosRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photosRepository.deleteById(id);
    }

    public photo save(String fileName, byte[] data, String contentType) {
        photo photo = new photo();
        //photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        photo.setContentType(contentType);
        //db.put(photo.getId(),photo);
        photosRepository.save(photo);
        return photo;
    }
}
