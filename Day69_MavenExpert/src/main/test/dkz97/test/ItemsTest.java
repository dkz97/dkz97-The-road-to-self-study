package dkz97.test;


import dkz97.service.impl.ItemsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class ItemsTest {

    @Autowired
    private ItemsService itemsService;


    @Test
    public void testDao() {
        System.out.println(itemsService.findAll());
    }
}
