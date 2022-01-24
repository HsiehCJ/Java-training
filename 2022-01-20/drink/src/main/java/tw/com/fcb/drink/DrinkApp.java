package tw.com.fcb.drink;

import com.sun.tools.jconsole.JConsoleContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DrinkApp {

    public static void main(String[] args){

        DrinkService service = new DrinkServiceImpl();
        Scanner sc = new Scanner(System.in);
        String functionCode;
        Drink drink = new Drink();
        List<Drink> drinks = new ArrayList<Drink>();

        System.out.println("請選擇要執行的項目");

        while (true){
            System.out.println("1.依編號查詢名稱 2.查詢近30天新品 3.依金額查詢產品 4.查詢推薦商品");
            functionCode = sc.next();
            if (functionCode.equals("1") || functionCode.equals("2")
                    || functionCode.equals("3") || functionCode.equals("4")){
                break;
            }else {
                System.out.println("輸入錯誤，請重新輸入");
            }
        }

        switch(functionCode) {
            case "1":
                System.out.println("請輸入欲查之編號");
                String searchCode = sc.next();
                drink = service.getByCode(searchCode);
                try {
                    System.out.println(drink.getName() + " " + drink.getPrice());
                }catch (NullPointerException e){
                    System.out.println("查不到品項");
                }
                break;
            case "2":
                drinks = service.getByDate(LocalDate.now());
                for (Drink thisDrink:drinks){
                    System.out.println(thisDrink);
                }
                break;
            case "3":
                System.out.println("請輸入金額，以查詢小於等於該金額之品項");
                Integer price = 0;
                while (true){
                    try {
                        price = sc.nextInt();
                        break;
                    }catch (InputMismatchException e){
                        System.out.println("輸入值非數字，請重新輸入");
                        sc.next();
                    }
                }

                drinks = service.getByPrice(price);
                if (drinks.size()==0){
                    System.out.println("查不到品項");
                }
                for (Drink thisDrink:drinks){
                    System.out.println(thisDrink);
                }
                break;
            case "4":
                drinks = service.getByMemo("Recommend");
                for (Drink thisDrink:drinks){
                    System.out.println(thisDrink);
                }
                break;
        }
    }

}
