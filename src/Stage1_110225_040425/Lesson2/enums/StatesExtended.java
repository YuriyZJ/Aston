package Stage1_110225_040425.Lesson2.enums;

import java.io.Closeable;

public enum StatesExtended implements Closeable {
    START(1) {
        @Override
        public String toString() {
            return "Реализация START. Приоритет : " + getPriority();
        }

        @Override
        public String getDetail() {
            return "START is priority " + getPriority();
        }
    },
    RUNNING(2) {
        @Override
        public String getDetail() {
            return "RUNNING is priority " + getPriority();
        }
    },
    WAITING(3) {
        @Override
        public String getDetail() {
            return "WAITING is priority " + getPriority();
        }
    },
    DEAD(4) {
        @Override
        public String getDetail() {
            return "DEAD is priority " + getPriority();
        }
    };

    private int priority;

    public abstract String getDetail();

    //Enum конструкторы должны всегда быть private.
    StatesExtended(int i) {
        priority = i;
    }

    //У Enum могут быть методы
    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int p) {
        this.priority = p;
    }

    //Enum может переопределять методы
    @Override
    public String toString() {
        return "Стандартная реализация StatesExtended. Приоритет : " + getPriority();
    }

    @Override
    public void close() {
        System.out.println("Закрытие Enum");
    }
}
