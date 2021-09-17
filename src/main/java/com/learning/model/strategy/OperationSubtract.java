package com.learning.model.strategy;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2021/9/17
 */
public class OperationSubtract implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
