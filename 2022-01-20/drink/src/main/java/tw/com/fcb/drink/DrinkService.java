package tw.com.fcb.drink;

import java.time.LocalDate;
import java.util.List;

public interface DrinkService {

    public Drink getByCode(String code);
    public List<Drink> getByDate(LocalDate date);
    public List<Drink> getByPrice(int price);
    public List<Drink> getByMemo(String memo);

}
