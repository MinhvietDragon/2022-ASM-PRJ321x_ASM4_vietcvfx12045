package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.*;

/*
 * Hàm Mapper của AccountUser, sử dụng để dùng JdbcTemplate trong AccountUserJDBCTemplate
 * Mục đích class: Trả về một đối tượng AccountUser của lệnh truy vấn đến bảng CSDL
 */
public class AccountUserMapper implements RowMapper<AccountUser>{
	
	 public AccountUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		 	 AccountUser account = new AccountUser();
		 	 //Lấy giá trị trong các cột của bảng Account trong CSDL
			 account.setUser(rs.getString("user_mail"));
			 account.setPassword(rs.getString("password"));
			 return account;
	   }
}
