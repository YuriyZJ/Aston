package Lesson2.nested.anonymous;

public class GeneralIndicatorsMonitoringModule implements MonitoringSystem {

    @Override
    public void startMonitoring() {
        System.out.println("Мониторинг общих показателей стартовал!");
    }
}
