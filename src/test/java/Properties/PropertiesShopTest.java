package Properties;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesShopTest {

        @Test
        public void defaultPropTest01(){
            String testproperty = PropertiesShop.getProperties().getProperty("testproperty2");

            assertEquals("8F6a1&neS$Fr", testproperty);
        }

        @Test
        public void defaultPropTest02(){
           String testproperty = PropertiesShop.getProperties().getProperty("mysqlport");

           assertEquals("3306", testproperty);
        }
}