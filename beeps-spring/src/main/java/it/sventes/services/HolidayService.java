package it.sventes.services;

import it.sventes.model.country.Country;
import it.sventes.model.holidays.Holidays;
import it.sventes.repository.CountryRepository;
import it.sventes.repository.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class HolidayService {

    private HolidaysRepository holidaysRepository;
    private CountryRepository countryRepository;
    private Map<Country, Integer> countries = new HashMap<>();

    @Autowired
    public HolidayService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Page<Holidays> findAllCountriesPageable(Pageable pageable) {
        return holidaysRepository.findAll(pageable);
    }

    public Map<Country, Integer> getCountriesInHolidays() {
        return Collections.unmodifiableMap(countries);
    }

    public void addCountry(Country country) {
        if (countries.containsKey(country)) {
            countries.replace(country, countries.get(country) + 1);
        } else {
            countries.put(country, 1);
        }
    }

    public void removeCountry(Country country){
        if (countries.containsKey(country)) {
            if (countries.get(country) > 1)
                countries.replace(country, countries.get(country) - 1);
            else if (countries.get(country) == 1) {
                countries.remove(country);
            }
        }
    }

}
