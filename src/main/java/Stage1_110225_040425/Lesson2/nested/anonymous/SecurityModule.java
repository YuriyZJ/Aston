package Stage1_110225_040425.Lesson2.nested.anonymous;

public class SecurityModule implements MonitoringSystem {

    @Override
    public void startMonitoring() {
        System.out.println("Мониторинг безопасности стартовал!");
    }
}