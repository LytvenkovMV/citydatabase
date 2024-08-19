package com.example.cityserver.repository;

import com.example.cityserver.entity.Passport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends CrudRepository<Passport, Long> {
}
