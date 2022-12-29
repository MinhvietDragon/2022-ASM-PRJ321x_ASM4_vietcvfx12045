package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.AccountUser;
import model.User;

@Controller
public class LoginController {
	
	//1.Các phần xử lý của @RequestMapping có value = "/login.html", dùng hàm GET (Đặt .html vì tại web.xml DispatcherServlet đã đặt thành nhận đuôi .html thân thiện người dùng)	
	//Khởi đầu dự án . Tên đặt nối tiếp sau tên dự án là value = "/" (để dùng redirect chuyển trang theo value nếu cần), và đích đến là return "login". Có thể đặt nhiều thư mục sau value = "/"
	//Theo dự đoán thì có thể đặt nhiều phương thức chứ không chỉ 1 hàm như index() dưới đây
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	
	//Chuyển vào login.jsp | Theo cài đặt trong login2-servlet.xml thì các đuôi sẽ tự động là .jsp
	public String index() {
	      return "login";
	   }
	
	//2.Xử lý của phần @RequestMapping có value = "/dologin.html", dùng hàm POST (Có thể chuyển sang GET cho cả form và @RequestMapping để nhìn URL cho rõ)
	@RequestMapping(value = "/dologin.html", method = RequestMethod.POST)
	   
	   //2.1 Thông số từ form login được truyền vào User bởi @ModelAttribute. (Đặt tên @ModelAttribute là SpringWebASM4) (không cần lấy qua request như lúc trước -- Tiết kiệm bước làm)
	   //Có thể lấy cách khác theo hàm request nếu không sử dụng truyền đối tượng như @ModelAttribute. Ở đây dùng @ModelAttribute là lấy được luôn (tên nhập) user và password truyền vào (Đối tượng) User.
	   public String redirect (@ModelAttribute("SpringWebASM4") User user, ModelMap model) {
			
			//2.2 Truyền dữ liệu sang trang (sử dụng) khác (Dùng ModelMap). (Cách khác: Lưu theo request, session như đã biết)
			//(Dùng hàm get của User (chứ chưa dùng kiểu đặt lại tên) để hiểu bản chất - ý là dùng thô xong mới đặt lại tên cho tinh gọn)
			model.addAttribute("username", user.getUsername());
		    model.addAttribute("password", user.getPassword());
		    
		    //2.3 Đặt lại thông tin lấy được từ User để nhìn cho gọn
		    String userLogin = user.getUsername();
		    String passLogin = user.getPassword();
		    
		    //2.4 Xử lý thông tin đăng nhập từ form gửi lên
			if(userLogin != null && passLogin != null) {
				
				//a.Sử dụng AccountUserJDBCTemplate để kiểm tra sự tồn tại của tài khoản có trong CSDL, trả về một AccountUser
				//Hàm setup
				ApplicationContext context = new ClassPathXmlApplicationContext("controller/Beans.xml"); //(địa chỉ của Beans.xml)
				AccountUserJDBCTemplate accountJDBCTemplate = (AccountUserJDBCTemplate) context.getBean("AccountUserJDBCTemplate"); //(tên bean đã tạo ở Beans.xml)
				//Gọi hàm sử dụng đã tạo
				AccountUser accountUser = accountJDBCTemplate.getAccountUser(userLogin, passLogin);
				
				//b.Nếu không có trong CSDL thì accountUser == null. (Theo hàm getAccountUser() của AccountUserJDBCTemplate)
				if(accountUser == null) {
					model.addAttribute("message","Thông báo: Username hoặc password không có trong CSDL (1)");
					return "login";
					
				} else if (userLogin.equalsIgnoreCase(accountUser.getUser()) && passLogin.equals(accountUser.getPassword())) {
					//Chuyển trực tiếp đến sang trang đích, truyền số lượng dữ liệu qua model
					model.addAttribute("message","Thông báo: Đăng nhập Admin thành công!");
					model.addAttribute("soLuongDonHang", accountJDBCTemplate.soLuongDonHang());
					
					//Tạo ngày tháng theo format và truyền vào model
					Calendar calendar = Calendar.getInstance();
					SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-YYYY");
					String ngayHomNay = myFormat.format(calendar.getTime());
					
					model.addAttribute("NgayHomNay", ngayHomNay);
					
					//Chuyển về trang index của admin, dữ liệu được truyền vào
					return "admin/index"; 
				}
			}
			
		  model.addAttribute("message","Thông báo: Vui lòng điền tên và mật khẩu");
	      return "login";
	   }
	
	//Xử lý đăng xuất tài khoản
	@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
	/*
	 * Model hay ModelMap chỉ để là cơ chế truyền dữ liệu giữa view và controller chứ không lưu lại (Còn session là cơ chế lưu dữ liệu)
	 * Nó cũng có cấu trúc hơi giống để đặt tên và truyền. Tên của Model còn lưu lại nhưng giá trị thì chỉ truyền 1 lần xong rồi thôi
	 */
	public String logout (ModelMap model, HttpServletRequest request) {
//		model.addAttribute("username", ""); //Có thể đặt lại model nếu cần
//	    model.addAttribute("password", "");
		
		//Lấy tên username được truyền lên từ form logout của index admin, đặt vào model để hiển thị ở value form khi vừa đăng xuất
		String user = request.getParameter("testTruyenModelMap");
		model.addAttribute("username", user);
		model.addAttribute("message","Thông báo: Đăng xuất xong!");
		//Trả lại trang login
		return "login";
	}
	
	//Điều hướng về trang home.jsp (Mọi trang đều được set về đuôi hiển thị trên URL là .html)
	@RequestMapping (value = "/home.html", method = RequestMethod.GET)
	public String home() {
	      return "home";
	}
}
