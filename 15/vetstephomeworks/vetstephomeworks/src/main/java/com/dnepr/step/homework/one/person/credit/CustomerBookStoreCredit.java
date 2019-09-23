package com.dnepr.step.homework.one.person.credit;

public class CustomerBookStoreCredit extends Credit {

    @Override
    public float getDebit() {
        return super.debit;
    }

    @Override
    public void addDebit(float amount) {
        if (amount <= 0) {
            throw new RuntimeException("Amount can't be 0 or less");
        }
        float newDebt = getDebit() + amount;
        if (newDebt > MAX_AMOUNT) {
            throw new RuntimeException("Max debit limit exceeded");
        }
        super.debit = newDebt;
    }

    @Override
    public boolean canAfford(float amount) {
        return getDebit() + amount < MAX_AMOUNT;
    }
}
