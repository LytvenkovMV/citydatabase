package com.example.cityserver.repository;

import com.example.cityserver.entity.Passport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassportRepository extends CrudRepository<Passport, Long> {

    Optional<Passport> findPassportByNumberAsc();
}
