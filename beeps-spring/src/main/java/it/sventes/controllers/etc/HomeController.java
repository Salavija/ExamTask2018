package it.sventes.controllers.etc;

import it.sventes.configs.Pager;
import it.sventes.model.country.Country;
import it.sventes.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {
    private static final int INITIAL_PAGE = 0;

    private final CountryService countryService;

    @Autowired
    public HomeController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/home")
    public ModelAndView home(@RequestParam("page") Optional<Integer> page) {


        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Country> countries = countryService.findAllCountriesPageable(new PageRequest(evalPage, 5));
        Pager pager = new Pager(countries);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", countries);
        modelAndView.addObject("pager", pager);
        modelAndView.setViewName("/home");
        return modelAndView;
    }
}
