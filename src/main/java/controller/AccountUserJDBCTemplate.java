package controller;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.remoting.rmi.CodebaseAwareObjectInputStream;

import model.*;

/*
 * Class thực hiện các hàm truy vấn đến CSDL
 */
public class AccountUserJDBCTemplate implements AccountUserDAO{
		private DataSource dataSource;
		private JdbcTemplate jdbcTemplateObject;
						
		//1. Cài đặt DataSource và JdbcTemplate cho lớp (DataSource đã setup ở Beans.xml)
		public void setDataSource(DataSource dataSource) {
			 this.dataSource = dataSource;
		     this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		}
		
		//2. Chèn, tạo tài khoản mới vào bảng Account trong CSDL (Chú ý trường hợp chưa xử lý: tài khoản đã có trong CSDL)
		public void create(String user, String password) {
			 String SQL = "insert into Account (user_mail, password) values (?, ?)";
		     jdbcTemplateObject.update( SQL, user, password);
		     System.out.println("Đã tạo: user = " + user + " password = " + password);
		     return;
		}
		
		//3. Lấy về user_mail và password trong CSDL theo user và password. Sau đó truyền vào một AccountUser (Thông qua AccountUserMapper()) và trả về return
		//Sử dụng try catch để xử lý trường hợp tài khoản không có trong CSDL
		public AccountUser getAccountUser(String user, String password) {
			
			 AccountUser account;
			
			 //Nếu có tồn tại trong dữ liệu thì trả về account
			 try {
				 String SQL = "select * from Account where user_mail=? and password=?";
				 account = jdbcTemplateObject.queryForObject(SQL, new Object[]{user, password}, new AccountUserMapper());
			     return account;
			     
			 } catch (Exception e) {
				System.out.println("Không kết nối được CSDL hoặc không tồn tại tài khoản đang tra");
				//Nếu không có trong dữ liệu thì trả về null
				 return account = null;
			 }
		}
		
		//4. Lấy số lượng đơn hàng hiện có trong CSDL
		public int soLuongDonHang() {
			String SQL = "select count(*) from Orders";
	      	int soLuongDonHang = jdbcTemplateObject.queryForInt(SQL);
			return soLuongDonHang;
		}
		
}
