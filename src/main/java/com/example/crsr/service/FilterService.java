package com.example.crsr.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterService {
    private List<Sort.Order> filters;

    public List<Sort.Order> getFilters() {
        if (filters == null) {
            setFilters(new ArrayList<>());
        }

        return filters;
    }

    public void removeAllFilters() {
        filters = new ArrayList<>();
    }

    public void addField(String field) {
        if (filters.size() > 2) {
            return;
        }

        if (getFilters().contains(Sort.Order.asc(field))) {
            getFilters().remove(Sort.Order.asc(field));
            getFilters().add(Sort.Order.desc(field));
            return;
        }

        if (getFilters().contains(Sort.Order.desc(field))) {
            getFilters().remove(Sort.Order.desc(field));
            getFilters().add(Sort.Order.asc(field));
            return;
        }

        getFilters().add(Sort.Order.asc(field));
    }

    private void setFilters(List<Sort.Order> filters) {
        this.filters = filters;
    }
}
