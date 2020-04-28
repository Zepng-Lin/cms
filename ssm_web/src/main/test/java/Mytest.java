import com.ZepngLin.dao.*;
import com.ZepngLin.domain.Member;
import com.ZepngLin.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Mytest {
    @Test
    public void test1(){
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ProductService service = (ProductService) ac.getBean("productService");
//        System.out.println(service.findAll());
//        TravellersDao travellersDao = (TravellersDao) ac.getBean(TravellersDao.class);
//        System.out.println(travellersDao.findByOrdersId(1));
//       MemberDao memberDao = (MemberDao) ac.getBean(MemberDao.class);
//        System.out.println(memberDao.findById(1));
//        OrdersDao ordersDao = (OrdersDao) ac.getBean(OrdersDao.class);
//        System.out.println(ordersDao.findById(1));
//        System.out.println(ac.getBean(UserDao.class).findByUsername("root"));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("root"));

    }
}
