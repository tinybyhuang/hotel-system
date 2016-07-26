
/*package com.distinct.hotel.user.service;

import java.util.List;

import com.distinct.hotel.user.model.User;

public interface UserService {
	boolean getUser(String username, String pwd);

	List<String> getUserName();

	int addUser(User user);

	void deleteUser(int id);

	void updateUser(User user);
}
*/
package com.distinct.hotel.user.service;

import java.util.List;

import com.distinct.hotel.user.model.Role;
import com.distinct.hotel.user.model.User;

public interface UserService {


	int addUser(User user);

	boolean getUser(String username, String pwd);
	
	User getUserByAccount(String account);
	
	List<Role> getRoleByAccount(String account);

}
