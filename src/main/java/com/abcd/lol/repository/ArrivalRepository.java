package com.abcd.lol.repository;

import com.abcd.lol.domain.Arrival;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArrivalRepository extends CrudRepository<com.abcd.lol.domain.Arrival, Integer> {

    List<Arrival> findByDate(String filter);

}
