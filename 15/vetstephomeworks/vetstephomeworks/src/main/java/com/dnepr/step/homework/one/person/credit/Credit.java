package com.dnepr.step.homework.one.person.credit;

public abstract class Credit {
    final public static float MAX_AMOUNT = 1000f;
    protected float debit;
    public abstract float getDebit();
    public abstract void addDebit(float amount);
    public abstract boolean canAfford(float amount);
}
