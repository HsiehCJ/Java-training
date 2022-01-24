package tw.com.fcb.drink;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrinkServiceTest {

    @Test
    void getByCode() {
        DrinkService service = new DrinkServiceImpl();
        Drink drink = service.getByCode("T01");

        assertEquals("古城錫蘭紅茶",drink.getName());
    }

    @Test
    void getByDate() {
        DrinkService service = new DrinkServiceImpl();
        List<Drink> drinks = service.getByDate(LocalDate.of(2021,12,31));

        assertEquals(1,drinks.size());
    }

    @Test
    void getByPrice() {
        DrinkService service = new DrinkServiceImpl();
        List<Drink> drinks = service.getByPrice(35);

        assertEquals(true,drinks.toString().contains("編號='T01'"));
    }

    @Test
    void getByMemo() {
        DrinkService service = new DrinkServiceImpl();
        List<Drink> drinks = service.getByMemo("Recommend");

        assertEquals(true,drinks.toString().contains("編號='T01'"));
    }
}