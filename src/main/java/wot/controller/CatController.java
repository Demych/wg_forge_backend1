package wot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wot.entity.Cat;
import wot.exception.ValidateColorException;
import wot.exception.ValidateNameException;
import wot.exception.ValidateTailException;
import wot.exception.ValidateWhiskersException;
import wot.service.CatService;
import wot.utilss.ValidationImpl;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class CatController {

    @Autowired
    CatService catService;



    @GetMapping(value = "/ping")

    public String getPing() {
        return "Cats Service. Version 0.1";
    }

//    @GetMapping(value = "get")
//    public ArrayList<Cat> getCats() {
//        System.out.println("Вошли в метод getCats");
//        return (ArrayList<Cat>) catService.findAll();
//    }

    @GetMapping(value = "cats")
    public ArrayList<Cat> getSortCats(@RequestParam (required = false) String attribute,
                                      @RequestParam (defaultValue = "asc") String order) throws ValidateColorException {

        System.out.println("Вошли в метод getCats");
        System.out.println(order);
        if (attribute == null) {
            return (ArrayList < Cat >) catService.findAll();
        }
        return (ArrayList<Cat>) catService.findAll(attribute, order);
    }


    @PostMapping(value = "/cat")
    public Cat saveCat(@RequestBody @Valid Cat cat) throws ValidateColorException, ValidateWhiskersException, ValidateNameException, ValidateTailException {
        System.out.println(cat.getColor());
        ValidationImpl valid = new ValidationImpl();
        valid.validate(cat);

//        cat.setColor(CatColor.BLACK);
        return catService.save(cat);
    }

}
