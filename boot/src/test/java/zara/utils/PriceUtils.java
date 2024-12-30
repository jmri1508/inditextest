package zara.utils;

public class PriceUtils {

    public static String returnCase1And3Result(){
        return "{\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14T00:00:00\"," +
                "\"endDate\":\"2020-12-31T23:59:59\",\"price\":35.5}";
    }

    public static String returnCase2Result(){
        return "{\"productId\":35455,\"brandId\":1,\"priceList\":2,\"startDate\":\"2020-06-14T15:00:00\"," +
                "\"endDate\":\"2020-06-14T18:30:00\",\"price\":25.45}";
    }

    public static String returnCase4Result(){
        return "{\"productId\":35455,\"brandId\":1,\"priceList\":3,\"startDate\":\"2020-06-15T00:00:00\"," +
                "\"endDate\":\"2020-06-15T11:00:00\",\"price\":30.5}";
    }

    public static String returnCase5Result(){
        return "{\"productId\":35455,\"brandId\":1,\"priceList\":4,\"startDate\":\"2020-06-15T16:00:00\"," +
                "\"endDate\":\"2020-12-31T23:59:59\",\"price\":38.95}";
    }

}
