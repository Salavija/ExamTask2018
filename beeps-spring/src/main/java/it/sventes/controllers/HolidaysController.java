package it.sventes.controllers;

import it.sventes.services.CountryService;
import it.sventes.services.HolidayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HolidaysController {

    private static Logger logger = LoggerFactory.getLogger(HolidaysController.class);


    private CountryService countryService;
    private HolidayService holidayService;

    @Autowired
    public HolidaysController(CountryService countryService, HolidayService holidayService) {
        this.countryService = countryService;
        this.holidayService = holidayService;
    }

    @GetMapping("/holidays")
    public ModelAndView holidays() {
        logger.info("Holidays list generated");
        ModelAndView modelAndView = new ModelAndView("/holidays");
        modelAndView.addObject("countries", holidayService.getCountriesInHolidays());
        return modelAndView;
    }
    @GetMapping("/holidays/addCountry/{countryName}")
    public ModelAndView addCountryToHoliday(@PathVariable("countryName") String CountryName) {
        countryService.findByName(CountryName).ifPresent(holidayService::addCountry);
        return holidays();
    }

    @GetMapping("/holidays/removeCountry/{countryName}")
    public ModelAndView removeCountry(@PathVariable("countryName") String CountryName) {
        countryService.findByName(CountryName).ifPresent(holidayService::removeCountry);
        return holidays();
    }

}
