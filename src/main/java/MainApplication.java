import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

//        //Write operation
//        productService.addProduct(new Product("Asus vivobook", "Laptop", "Almira", 2019));
//        productService.addProduct(new Product("Macbook Air", "Laptop", "Black table", 2024));
//        productService.addProduct(new Product("Monitor's remote", "Remote", "White table", 2024));
//        productService.addProduct(new Product("Alexa Black", "AI model", "White Almira", 2020));
//        productService.addProduct(new Product("Alexa White", "AI model", "White Almira", 2023));
//        productService.addProduct(new Product("Airpods", "earbud", "White Almira", 2023));
//        productService.addProduct(new Product("Markers", "Stationary", "shelf", 0));
//        productService.addProduct(new Product("BikeKeys", "Keys", "Black Table Drawer", 0));
//        productService.addProduct(new Product("logitech keyboard", "keyboard", "Almira", 2024));
//        productService.addProduct(new Product("Logitech-mouse", "mouse", "Almira", 2024));
//        productService.addProduct(new Product("HDMI cable", "cables", "Main table", 2024));
//        productService.addProduct(new Product("Black Chargers", "chargers", "Almira base", 2023));
//        productService.addProduct(new Product("White Chargers", "chargers", "Almira base", 2020));

//        //Read operation
//        System.out.println("All products : ");
//        List<Product> allProducts = productService.getAllProducts();
//        allProducts.stream().forEach(System.out::println);

//        System.out.println("___________________________________________________________________");

//        //Search operation
//        System.out.println("Product by name : ");
//        Product productByName = productService.getproduct("macBook aIr");
//        System.out.println(productByName);
//
//        System.out.println("___________________________________________________________________");
//
////        //Search by keywords
//        System.out.println("Products By Keyword : ");
//        List<Product> productsByKeyword = productService.getProductsByKeywords("wHite");
//        productsByKeyword.stream().forEach(System.out::println);
////
////        System.out.println("___________________________________________________________________");
//
////        //Search by location
//        System.out.println("Products By Location : ");
//        List<Product>productListByLocation= productService.getProductsByLocation("alMira");
//        productListByLocation.stream().forEach(System.out::println);
//
//        System.out.println("______________________________________________________________________");
//
        //Search products which are out of Warranty
        System.out.println("Out of warranty Products : ");
        List <Product> expiredWarrantyProducts= productService.getExpiredWarrantyProducts();
        expiredWarrantyProducts.stream().forEach(System.out::println);
    }
}