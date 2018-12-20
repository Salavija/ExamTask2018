package it.sventes.configs;

import it.sventes.model.country.Country;
import org.springframework.data.domain.Page;

public class Pager {

    private final Page<Country> countries;

    public Pager(Page<Country> products) {
        this.countries = products;
    }

    public int getPageIndex() {
        return countries.getNumber() + 1;
    }

    public int getPageSize() {
        return countries.getSize();
    }

    public boolean hasNext() {
        return countries.hasNext();
    }

    public boolean hasPrevious() {
        return countries.hasPrevious();
    }

    public int getTotalPages() {
        return countries.getTotalPages();
    }

    public long getTotalElements() {
        return countries.getTotalElements();
    }

    public boolean indexOutOfBounds() {
        return this.getPageIndex() < 0 || this.getPageIndex() > this.getTotalElements();
    }

}