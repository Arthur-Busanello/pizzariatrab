package org.example.Entity;

public enum Payment {
    CARTAO(0),
    DINHEIRO(1);

    private final int value;

    Payment(int value) {
        this.value = value;
    }
}
