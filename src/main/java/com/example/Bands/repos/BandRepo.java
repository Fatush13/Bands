package com.example.Bands.repos;

import com.example.Bands.domain.Band;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BandRepo extends CrudRepository<Band, Long> {

    List<Band> findByName(String name);

}
