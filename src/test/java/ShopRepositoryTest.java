import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void testFindAllProduct() {

        ShopRepository shopRepository = new ShopRepository();
        Product product = new Product(1, "Хлеб", 30);
        Product product1 = new Product(2, "Молоко", 107);
        Product product2 = new Product(3, "Сахар", 50);

        shopRepository.add(product);
        shopRepository.add(product1);
        shopRepository.add(product2);

        Product[] expected = {product, product1, product2};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveProduct() {

        ShopRepository shopRepository = new ShopRepository();
        Product product = new Product(1, "Хлеб", 30);
        Product product1 = new Product(2, "Молоко", 107);
        Product product2 = new Product(3, "Сахар", 50);

        shopRepository.add(product);
        shopRepository.add(product1);
        shopRepository.add(product2);

        shopRepository.remove(2);

        Product[] expected = {product, product2};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveNoProductId() {

        ShopRepository shopRepository = new ShopRepository();
        Product product = new Product(1, "Хлеб", 30);
        Product product1 = new Product(2, "Молоко", 107);
        Product product2 = new Product(3, "Сахар", 50);

        shopRepository.add(product);
        shopRepository.add(product1);
        shopRepository.add(product2);

        Assertions.assertThrows(NotFoundException.class,
                () -> shopRepository.remove(23)
        );
    }
}
