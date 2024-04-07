package lojavirtual.loja_virtual.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductBrandTest {
    private ProductBrand productBrand;

    @BeforeEach
    void setUp() {
        productBrand = new ProductBrand("test");
    }

    @Test
    void constructor_throwsExceptionWhenNullIsPassed() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new ProductBrand(null));
        String expectedMessage = "Description Name cannot be null";
        String actualMessage = exception.getMessage();

        assert actualMessage.equals(expectedMessage);
    }

    @Test
    void constructor_throwsExceptionWhenMoreThan255CharactersArePassed() {
        String descriptionName = String.join("", Collections.nCopies(256, "a"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new ProductBrand(descriptionName));
        String expectedMessage = "Description Name cannot be longer than 255 characters";
        String actualMessage = exception.getMessage();

        assert actualMessage.equals(expectedMessage);
    }

    @Test
    void getDescriptionName_returnsCorrectDescriptionName() {
        assert productBrand.getDescriptionName().equals("test");
    }

    @Test
    void setDescriptionName_setsCorrectDescriptionName() {
        productBrand.setDescriptionName("Brand");
        assert productBrand.getDescriptionName().equals("Brand");
    }

    @Test
    void setDescriptionName_throwsExceptionWhenNullIsPassed() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> productBrand.setDescriptionName(null));
        String expectedMessage = "Description Name cannot be null";
        String actualMessage = exception.getMessage();

        assert actualMessage.equals(expectedMessage);
    }

    @Test
    void setDescriptionName_throwsExceptionWhenMoreThan255CharactersArePassed() {
        String descriptionName = String.join("", Collections.nCopies(256, "a"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> productBrand.setDescriptionName(descriptionName));
        String expectedMessage = "Description Name cannot be longer than 255 characters";
        String actualMessage = exception.getMessage();

        assert actualMessage.equals(expectedMessage);
    }
}