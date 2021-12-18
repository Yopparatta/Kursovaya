package com.example.crsr.service;

import com.example.crsr.entity.Cars;
import com.example.crsr.repository.CarsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class CarService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarService.class);

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private FilterService filterService;

    public List<Cars> getAll() {
        List<Cars> result;

        try {
            result =  carsRepository.findAll(Sort.by(filterService.getFilters()));
        } catch (Exception ex) {
            LOGGER.error("Не удaлось получить данные из БД!", ex);
            result = null;
        }

        return result;
    }

    public void delete(Integer id) {
        try {
            carsRepository.deleteById(id);
        } catch (Exception ex) {
            LOGGER.error("Не удалось удалить строку из БД! id = "+id, ex);
        }
    }

    public void save(Cars car) {
        try {
            carsRepository.save(car);
        } catch (Exception ex) {
            LOGGER.error("Не удалось сохранить данные в БД!", ex);
        }
    }
}
