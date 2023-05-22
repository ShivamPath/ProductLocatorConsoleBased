import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List <Product> products= new ArrayList<>();
    ProductDB db= new ProductDB();

    public void addProduct(Product product){
        db.save(product);
    }

    public List<Product> getAllProducts() {
        return db.getAll();
        }

    public Product getproduct(String givenName) {
        return db.getProduct(givenName);
    }

    public List<Product> getProductsByKeywords(String givenKeyword) {
        return db.getProductsByKeywords(givenKeyword);
    }

    public List<Product> getProductsByLocation(String givenLocation){
        return db.getProductsByLocation(givenLocation);
    }

    public List<Product> getExpiredWarrantyProducts() {
        return db.getExpiredWarrantyProducts();
    }
}
