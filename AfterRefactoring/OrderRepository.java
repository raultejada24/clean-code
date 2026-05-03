package AfterRefactoring;

public interface OrderRepository {

    void updateOrderTotal(int orderId, double newTotal) throws DatabaseException;

}