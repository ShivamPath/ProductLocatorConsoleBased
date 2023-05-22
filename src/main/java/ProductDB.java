import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    Connection connection= null;

    public ProductDB() {
        try {
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/productLocator","postgres","1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Product product) {
            String query="insert into product(name,type,location,warranty) values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getType());
            preparedStatement.setString(3,product.getLocation());
            preparedStatement.setInt(4,product.getWarranty());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll() {
        List<Product> allProducts= new ArrayList<>();
        String query= "select name, type, location, warranty from product";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet =preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product= new Product();
                product.setName(resultSet.getString(1));
                product.setType(resultSet.getString(2));
                product.setLocation(resultSet.getString(3));
                product.setWarranty(resultSet.getInt(4));
                allProducts.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allProducts;
    }

    public Product getProduct(String givenName) {
        Product product= new Product();
        String query= "select name, type, location, warranty from product where lower(name)=?";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            String givenNameLowerCase=givenName.toLowerCase();

            preparedStatement.setString(1,givenNameLowerCase);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                product.setName(resultSet.getString(1));
                product.setType(resultSet.getString(2));
                product.setLocation(resultSet.getString(3));
                product.setWarranty(resultSet.getInt(4));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public List<Product> getProductsByKeywords(String givenKeyword) {
        List<Product> products= new ArrayList<>();
        String query= "select name, type, location, warranty from product where lower(name) like ? " +
                        "or lower(type) like ? or lower(location) like ?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            String givenKeywordLowerCase=givenKeyword.toLowerCase();
            preparedStatement.setString(1,"%"+givenKeywordLowerCase+"%");
            preparedStatement.setString(2,"%"+givenKeywordLowerCase+"%");
            preparedStatement.setString(3,"%"+givenKeywordLowerCase+"%");

            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product= new Product();
                product.setName(resultSet.getString(1));
                product.setType(resultSet.getString(2));
                product.setLocation(resultSet.getString(3));
                product.setWarranty(resultSet.getInt(4));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Product> getProductsByLocation(String givenLocation) {
        List<Product> products= new ArrayList<>();
        String query= "select name, type, location, warranty from product where lower(location)=?";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(query);
             String givenLocationLowerCase=givenLocation.toLowerCase();
            preparedStatement.setString(1,givenLocationLowerCase);

            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString(1));
                product.setType(resultSet.getString(2));
                product.setLocation(resultSet.getString(3));
                product.setWarranty(resultSet.getInt(4));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Product> getExpiredWarrantyProducts() {
        List <Product> products= new ArrayList<>();
        String query= "select name, type, location, warranty from product where warranty<2023";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product= new Product();
                product.setName(resultSet.getString(1));
                product.setType(resultSet.getString(2));
                product.setLocation(resultSet.getString(3));
                product.setWarranty(resultSet.getInt(4));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
