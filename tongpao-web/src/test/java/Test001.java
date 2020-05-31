import com.tongpao.WebApplication;
import com.tongpao.entity.CompanyInfo;
import com.tongpao.service.ICompanyInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>Title: Test001</p>
 * <p>Description: </p>
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/5/28 22:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = WebApplication.class)
public class Test001 {

	@Reference
	private ICompanyInfoService iCompanyInfoService;

	@Test
	public void testGetCompany(){
		CompanyInfo byId = iCompanyInfoService.getById("111");
		System.out.println("====================result:" + byId);
	}
}
