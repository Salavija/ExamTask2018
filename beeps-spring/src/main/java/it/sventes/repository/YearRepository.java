package it.sventes.repository;

import it.sventes.model.year.Year;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearRepository  extends JpaRepository<Year, Long> {
}
