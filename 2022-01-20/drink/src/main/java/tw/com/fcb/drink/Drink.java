package tw.com.fcb.drink;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Drink {

    String code;
    String name;
    LocalDate date;
    String type;
    String memo;
    int price;

    @Override
    public String toString() {
        return  "編號='" + code + '\'' +
                ", 名稱='" + name + '\'' +
                ", 上市日期=" + date +
                ", 種類='" + type + '\'' +
                ", 備註='" + memo + '\'' +
                ", 價格=" + price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
