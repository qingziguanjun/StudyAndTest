package java8function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author songyi
 * @date 2020-07-01 10:42
 * @Description:https://www.jianshu.com/p/6f724b073f3c
 */
public class Test {
    public static List<Apple> filterApple(List<Apple> appleList){
        List<Apple> apples = new ArrayList<Apple>();
        for (Apple apple : appleList) {
            if(apple.getWight() > 100){
                apples.add(apple);
            }
        }
        return apples;
    }


    /**
     Predicate<T>接口：默认调用test方法，返回boolean值，传递的参数只有一个。
     在需要调用Lambeda表达式返回boolean的时候使用。
     */
    public static List<Apple> filterApple(List<Apple> appleList, Predicate<Apple> predicate){
        List<Apple> apples = new ArrayList<>();
        for (Apple apple : appleList) {
            if(predicate.test(apple)){
                apples.add(apple);
            }
        }
        return apples;
    }
    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple("RED", 80),
                new Apple("GREEN", 100),
                new Apple("BLACK", 150));
        // 重量大于100
        List<Apple> filterApple = filterApple(appleList, apple -> apple.getWight() > 100);
        // 红色的苹果
        filterApple = filterApple(appleList, apple -> apple.getColor().equals("RED"));
    }
}
