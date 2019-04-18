package com.abcd.lol.repository;

import com.abcd.lol.domain.Arrival;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ArrivalRepository extends PagingAndSortingRepository<Arrival, Integer> {

    List<Arrival> findByDate(String filter);

}
