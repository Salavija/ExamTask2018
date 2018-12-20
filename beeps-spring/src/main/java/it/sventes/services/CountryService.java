package it.sventes.services;

import it.sventes.model.country.Country;
import it.sventes.model.country.CountryServ;
import it.sventes.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private CountryRepository countryRepository;
    private Map<Country, Integer> countries = new HashMap<>();

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Page<Country> findAllCountriesPageable(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    public Optional<Country> findByName(String name) {
        return countryRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<CountryServ> getCountry() {
        return countryRepository.findAll().stream().map((product) ->
                new CountryServ(
                        product.getName(),
                        product.getFlagImageH(),
                        product.getPrezident(),
                        product.getHolidays()
                )).collect(Collectors.toList());
    }

    @Transactional
    public void createCountry(CountryServ country) {
        Country newCountry = new Country();
        newCountry.setName(country.getNameS());
        newCountry.setFlagImageH(country.getFlagImageS());
        newCountry.setPrezident(country.getPrezidentS());
        newCountry.setHolidays(country.getHolidaysS());
        countryRepository.save(newCountry);
    }

    @Transactional
    public void removeCountry(Country country){
        if (countries.containsKey(country)) {
            if (countries.get(country) > 1)
                countries.replace(country, countries.get(country) - 1);
            else if (countries.get(country) == 1) {
                countries.remove(country);
            }
        }
    }

    public CountryRepository getCountryRepository() {
        return countryRepository;
    }

    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Map<Country, Integer> getCountries() {
        return countries;
    }

    public void setCountries(Map<Country, Integer> countries) {
        this.countries = countries;
    }
}
