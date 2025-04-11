package  Stage1_110225_040425.Lesson5.lambda;

@FunctionalInterface
public interface OperationableGeneric<T> {

    T calculate(T x, T y);
}
