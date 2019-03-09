package wot.service;

import org.springframework.stereotype.Service;
import wot.entity.Cat;
import wot.exception.ValidateColorException;

import java.util.List;

@Service
public interface CatService {
    List<Cat> findAll(String property, String order);

    List<Cat> findAll();

    Cat save(Cat cat) throws ValidateColorException;
}
