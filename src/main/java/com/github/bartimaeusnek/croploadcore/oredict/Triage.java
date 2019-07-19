package com.github.bartimaeusnek.croploadcore.oredict;

import java.util.Arrays;

public class Triage<A,B,C> {

    private Object[] ABC;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triage)) return false;

        Triage<?, ?, ?> triage = (Triage<?, ?, ?>) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(ABC, triage.ABC);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(ABC);
    }

    public Triage(A one, B two, C three){
        ABC = new Object[]{one,two,three};
    }
    public A getA() {
        return (A) ABC[0];
    }
    public B getB() {
        return (B) ABC[1];
    }
    public C getC() {
        return (C) ABC[2];
    }

    public Object[] getABC() {
        return ABC;
    }

    public void setABC(Object[] ABC) {
        this.ABC = ABC;
    }
}
