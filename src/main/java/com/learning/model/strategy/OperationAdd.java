package com.learning.model.strategy;

/**
 * @author
 * 1、如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，那么使用策略模式可以动态地让一个对象在许多行为中选择一种行为。
 * 2、一个系统需要动态地在几种算法中选择一种。
 * 3、如果一个对象有很多的行为，如果不用恰当的模式，这些行为就只好使用多重的条件选择语句来实现。
 * @date 2021/9/17
 */
public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {

        return num1 + num2;
    }
}
