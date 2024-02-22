package Amalitek.amalitek;

import Amalitek.amalitek.ProductLine.ProductLine;
import Amalitek.amalitek.ProductLine.ProductLineResponse;
import Amalitek.amalitek.ProductLine.ProductLineService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class AmalitekApplicationTests {
private @Autowired ProductLineService PLS;
	@Test
	void contextLoads() {
  Assertions.assertNotNull(PLS.saveProductLine(new ProductLine(2, 5, 7, 8)));
	}

}
