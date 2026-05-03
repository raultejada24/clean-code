package AfterRefactoring;

public class OrderManagerClean {


    private final DiscountCalculator discountCalculator;

    private final OrderRepository orderRepository;

    private final NotificationService notificationService;


    // Inyección de dependencias a través del constructor

    public OrderManagerClean(DiscountCalculator discountCalculator, 

                        OrderRepository orderRepository, 

                        NotificationService notificationService) {

        this.discountCalculator = discountCalculator;

        this.orderRepository = orderRepository;

        this.notificationService = notificationService;

    }


    public boolean processOrder(Order order) {

        try {

            // 1. Calcular y aplicar el descuento

            double finalAmount = discountCalculator.calculateDiscount(order.getType(), order.getAmount());

            order.setAmount(finalAmount);


            // 2. Persistir en la base de datos

            orderRepository.updateOrderTotal(order.getId(), order.getAmount());


            // 3. Notificar al usuario

            notificationService.sendOrderProcessedEmail(order.getEmail(), order.getAmount());


            return true;


        } catch (DatabaseException | NotificationException e) {

            // Aquí idealmente se usaría un Logger (ej. log.error("Error procesando orden", e);)

            System.err.println("Error procesando la orden: " + e.getMessage());

            return false;

        }

    }

}