package it.sventes.repository;

import it.sventes.model.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(@Param("name") String name);
}
