package BeforeRefactoring;
public class OrderManager {

    // Método que procesa una orden, aplica descuentos, guarda en BD y notifica.
    public boolean p(Order ord) {
        // 1. Lógica de negocio mezclada
        if (ord.type == 1) { 
            double d = ord.amt * 0.15; 
            ord.amt = ord.amt - d;
        } else if (ord.type == 2) {
            double d = ord.amt * 0.05;
            ord.amt = ord.amt - d;
        }

        // 2. Acoplamiento fuerte con Base de Datos
        try {
            DBConnection db = new DBConnection("jdbc:mysql://localhost:3306/shop", "user", "1234");
            db.execute("UPDATE orders SET total = " + ord.amt + " WHERE id = " + ord.id);
        } catch (Exception e) {
            System.out.println("Error");
            return false;
        }

        // 3. Efectos secundarios (envío de email)
        EmailService.send(ord.email, "Su pedido de " + ord.amt + " ha sido procesado");
        return true;
    }
}