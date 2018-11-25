package svc;
import dao.LoginDao;
import vo.User;
import static util.DbUtil.*;
import java.sql.*;

public class LoginBiz {
	public User getUserLogin(String id, String passwd) {
		Connection con = getConnection();
		LoginDao loginDao = new LoginDao(con);
		System.out.println(id);
		
		User user = loginDao.getUserLogin(id, passwd);
		close(con);
	    System.out.println(passwd);
		return user;
	
		
		
	}

	
}
