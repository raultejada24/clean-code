package AfterRefactoring;

public interface NotificationService {

    void sendOrderProcessedEmail(String email, double amount) throws NotificationException;

}