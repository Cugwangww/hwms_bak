package com.ebg.多线程;

public enum SignEnum {
    /**/
    A {
        @Override
        public SignEnum last() {
            return C;
        }
    },
    B {
        @Override
        public SignEnum last() {
            return A;
        }
    },
    C {
        @Override
        public SignEnum last() {
            return B;
        }
    };

    public abstract SignEnum last();
}
