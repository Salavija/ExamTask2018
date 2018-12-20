package it.sventes.controllers;

import it.sventes.model.country.Country;
import it.sventes.model.country.CountryRest;
import it.sventes.model.country.CountryServ;
import it.sventes.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(path = "/countries", method = RequestMethod.GET)
    public List<CountryRest> getCountries() {
        List<CountryRest> products = new ArrayList<>();
        List<CountryServ> serviceCountries = countryService.getCountry();
        for (CountryServ country : serviceCountries) {
            products.add(
                    new CountryRest(
                            country.getNameS(),
                            country.getFlagImageS(),
                            country.getPrezidentS(),
                            country.getHolidaysS())
            );
        }
        return products;
    }


    @RequestMapping(path = "/country", method = RequestMethod.PUT)
    public String addNewCountry(@RequestBody Country country){
        countryService.createCountry(new CountryServ(
                country.getName(),
                country.getFlagImageH(),
                country.getPrezident(),
                country.getHolidays()
        ));
        return "New country was added";
    }

}