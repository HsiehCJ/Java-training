package tw.com.fcb.drink;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrinkServiceImpl implements DrinkService{

    Map<String, Drink> myDrinks = new HashMap<String, Drink>();
    List<Drink> result = new ArrayList<Drink>();
    Drink thisDrink = new Drink();

    public DrinkServiceImpl(){
        Drink drink11 = new Drink();
        drink11.setCode("T01");
        drink11.setName("古城錫蘭紅茶");
        drink11.setDate(LocalDate.of(2021,01,01));
        drink11.setType("Tea");
        drink11.setMemo("Recommend");
        drink11.setPrice(30);

        Drink drink12 = new Drink();
        drink12.setCode("T02");
        drink12.setName("纖活綠茶");
        drink12.setDate(LocalDate.of(2021,01,01));
        drink12.setType("Tea");
        drink12.setMemo("");
        drink12.setPrice(30);

        Drink drink21 = new Drink();
        drink21.setCode("M01");
        drink21.setName("許慶良鮮奶茶");
        drink21.setDate(LocalDate.of(2022,01,15));
        drink21.setType("Milk");
        drink21.setMemo("");
        drink21.setPrice(55);

        Drink drink22 = new Drink();
        drink22.setCode("M02");
        drink22.setName("許慶良珍珠鮮奶茶");
        drink22.setDate(LocalDate.of(2022,01,20));
        drink22.setType("Milk");
        drink22.setMemo("Recommend");
        drink22.setPrice(55);

        Drink drink31 = new Drink();
        drink31.setCode("F01");
        drink31.setName("繽紛水果茶");
        drink31.setDate(LocalDate.of(2021,11,05));
        drink31.setType("Fruit");
        drink31.setMemo("Recommend");
        drink31.setPrice(65);

        Drink drink32 = new Drink();
        drink32.setCode("F02");
        drink32.setName("蜂蜜檸檬");
        drink32.setDate(LocalDate.of(2021,12,31));
        drink32.setType("Fruit");
        drink32.setMemo("");
        drink32.setPrice(60);

        myDrinks.put(drink11.getCode(),drink11);
        myDrinks.put(drink12.getCode(),drink12);
        myDrinks.put(drink21.getCode(),drink21);
        myDrinks.put(drink22.getCode(),drink22);
        myDrinks.put(drink31.getCode(),drink31);
        myDrinks.put(drink32.getCode(),drink32);

    }


    @Override
    public Drink getByCode(String code) {
        return myDrinks.get(code);
    }

    @Override
    public List<Drink> getByDate(LocalDate date) {
        for (String key : myDrinks.keySet()){
            thisDrink = myDrinks.get(key);
            if (thisDrink.getDate().isAfter(date.minusDays(30)) &&
                    thisDrink.getDate().isBefore(date.plusDays(1))){
                result.add(thisDrink);
            }
        }
        return result;
    }

    @Override
    public List<Drink> getByPrice(int price) {
        for (String key : myDrinks.keySet()){
            thisDrink = myDrinks.get(key);
            if (thisDrink.getPrice() <= price){
                result.add(thisDrink);
            }
        }
        return result;
    }

    @Override
    public List<Drink> getByMemo(String memo) {
        for (String key : myDrinks.keySet()){
            thisDrink = myDrinks.get(key);
            if (thisDrink.getMemo().equals(memo)){
                result.add(thisDrink);
            }
        }
        return result;
    }
}
