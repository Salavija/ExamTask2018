package it.sventes.repository;

import it.sventes.model.holidays.Holidays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidaysRepository extends JpaRepository<Holidays, Long> {
}
