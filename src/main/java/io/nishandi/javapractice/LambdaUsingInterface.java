package io.nishandi;

public class LambdaUsingInterface {
    public static void main(String[] args) {
        MathOperation addition = (x, y) -> x + y;
        MathOperation subtraction = (x, y) -> x - y;
        System.out.println(operationExecutor(addition, 10, 20));
        System.out.println(operationExecutor(subtraction, 30, 20));
    }

    public static int operationExecutor(MathOperation operation, int x, int y) {
        return operation.doOperation(x, y);
    }

}

@FunctionalInterface
interface MathOperation {
    int doOperation(int x, int y);
}
