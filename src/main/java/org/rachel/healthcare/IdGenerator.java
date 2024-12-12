package org.rachel.healthcare;

public class IdGenerator {

    private static int id = 1;

    public static synchronized int generateId() {
        return id++;
    }
}
