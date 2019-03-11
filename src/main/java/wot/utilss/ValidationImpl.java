package wot.utilss;

import org.apache.tomcat.util.buf.StringUtils;
import wot.entity.Cat;
import wot.entity.CatColor;
import wot.exception.ValidateColorException;
import wot.exception.ValidateNameException;
import wot.exception.ValidateTailException;
import wot.exception.ValidateWhiskersException;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidationImpl implements Validation{
    Cat cat;
    ArrayList<String> colors = new ArrayList<>(
            Arrays.asList("black", "white", "black & white",
                          "red", "red & white", "red & black & white"));

    public ValidationImpl() {
    }

    public ValidationImpl(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void validate(Cat cat) throws ValidateNameException, ValidateColorException, ValidateTailException, ValidateWhiskersException {
        nameValidate(  cat.getName());
        colorValidate(cat.getColor());
        tailValidate(cat.getTailLength());
        whiskersValidate(cat.getWhiskersLength());
    }

    private void nameValidate(String name) throws ValidateNameException {
        if (name.isEmpty()) {
            throw new ValidateNameException("Name can not be empty");
        }
    }

    private void colorValidate(String color) throws ValidateColorException {
        if (color.isEmpty()) {
            throw new ValidateColorException("Color can not be empty");
        }
        if (!colors.contains(color)) {
            throw new ValidateColorException("ValidationImpl error. There is no such color");
        }
    }

    private void tailValidate(int tail) throws ValidateTailException {
        if (tail < 0 || tail == 0) {
            throw new ValidateTailException("The length of the tail can not be less than 0 or equal");
        }
    }

    private void whiskersValidate(int whiskers) throws ValidateWhiskersException {
        if (whiskers < 0 || whiskers == 0) {
            throw new ValidateWhiskersException("The length of the whiskers can not be less than 0 or equal");
        }
    }

}
