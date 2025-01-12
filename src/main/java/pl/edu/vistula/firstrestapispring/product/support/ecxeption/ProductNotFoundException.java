package pl.edu.vistula.firstrestapispring.product.support.ecxeption;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Product with id " + id + " not found");
    }
}
