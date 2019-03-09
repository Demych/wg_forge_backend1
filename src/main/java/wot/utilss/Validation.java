package wot.utilss;

import org.springframework.stereotype.Service;
import wot.entity.Cat;
import wot.exception.ValidateColorException;
import wot.exception.ValidateNameException;
import wot.exception.ValidateTailException;
import wot.exception.ValidateWhiskersException;

@Service
public interface Validation {
    public void validate(Cat cat) throws ValidateNameException, ValidateColorException, ValidateTailException, ValidateWhiskersException;
}
