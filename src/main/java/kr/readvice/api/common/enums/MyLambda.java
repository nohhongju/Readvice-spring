package kr.readvice.api.common.enums;

public class MyLambda {
    @FunctionalInterface interface MyFunction{int execute(String arg);}
    @FunctionalInterface interface MyConsumer{void execute(String arg);}
    @FunctionalInterface interface MySupplier{int execute();}
    @FunctionalInterface interface MyPredicate{boolean execute(String arg);}
    @FunctionalInterface interface MyInterface{String myMethod();}
    @FunctionalInterface interface MyUnaryOp{int operator(Integer a);}
    @FunctionalInterface interface LengthOfString{int execute(String arg);}
    @FunctionalInterface interface MathOperation{int execute(int a, int b);}
}
