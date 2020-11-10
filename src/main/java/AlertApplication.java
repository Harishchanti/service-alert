import service.AlertingService;

public class AlertApplication {

    public static void main(String[] args) {

        AlertingService alertingService = new AlertingService();
        alertingService.triggerAlerts();

    }
}
