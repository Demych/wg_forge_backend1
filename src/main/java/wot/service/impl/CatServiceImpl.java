package wot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import wot.exception.ValidateColorException;
import wot.entity.Cat;
import wot.repository.CatRepository;
import wot.service.CatService;

import java.util.ArrayList;
import java.util.List;


@Service
public class CatServiceImpl implements CatService {
    @Autowired
    CatRepository catRepository;

    @Override
    public List<Cat> findAll(String property, String order) {
        ArrayList<Cat> cats = new ArrayList<>();
        if ("asc".equals(order)) {
           cats = (ArrayList<Cat>) catRepository.findAll(Sort.by(property));
        }
        if ("desc".equals(order)) {
            cats =( ArrayList<Cat>) catRepository.findAll(Sort.by(Sort.Direction.DESC, property));
        }
        return cats;
    }

    @Override
    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    @Override
    public Cat save(Cat cat)  {
        catRepository.save(cat.getName(), cat.getColor(), cat.getTailLength(), cat.getWhiskersLength());
        return cat;
    }
}
