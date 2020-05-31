import com.tongpao.CoreApplication;
import com.tongpao.entity.CompanyInfo;
import com.tongpao.service.ICompanyInfoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>Title: Test001</p>
 * <p>Description: </p>
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/5/28 11:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CoreApplication.class)
public class Test001 {

	@Autowired
	private ICompanyInfoService iCompanyInfoService;

	@Test
	public void testCompanyFindById(){
		CompanyInfo byId = iCompanyInfoService.getById("111");
		System.out.println("=============>result:"+byId);
	}
}
