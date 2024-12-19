package io.nishandi;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        //function , takes one input and returns one output value
        Function<Integer,Integer> addFiveFunction = x -> x + 5;
        System.out.println(addFiveFunction.apply(10));

        //performs same as Function when input and output are of same type
        UnaryOperator<Integer> addFiveUnaryOperator = x -> x + 5;
        System.out.println(addFiveUnaryOperator.apply(10));
        
        //consumer , takes one value and returns nothing
        Consumer<Integer> printNumberConsumer = x -> System.out.println("Hola!!!! it is: " + 5);
        printNumberConsumer.accept(10);
        
        //supplier , takes no arg and returns one value
        Supplier<Double> supplyRandomSupplier = () -> Math.random();
        System.out.println(supplyRandomSupplier.get());
        
        //predicate , accepts one value and returns boolean
        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        System.out.println(isEvenPredicate.test(5));

        //binary function , takes two input values , and returns one value
        BiFunction<Integer,Integer,Integer> addTwoNumBiFunction = (x, y) -> x + y;
        System.out.println(addTwoNumBiFunction.apply(10, 20));

        BinaryOperator<Integer> addTwoNumOperator = (x, y) -> x + y;
        System.out.println(addTwoNumOperator.apply(10, 20));

        //binary consumer , takes two input values and returns nothing
        BiConsumer<Integer,Integer> printSumConsumer = (x, y) -> System.out.println("sum of x and y is: " + x+y);
        printSumConsumer.accept(10, 20);

        //binary predicate , takes two input values and returns boolean
        BiPredicate<Integer,Integer> isBothEvenPredicate = (x, y) -> x%2 == 0 && y%2 == 0;
        System.out.println(isBothEvenPredicate.test(10, 20));
    }
}
