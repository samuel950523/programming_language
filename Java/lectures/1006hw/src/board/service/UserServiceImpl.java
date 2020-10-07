package board.service;

import board.dao.UserDao;
import board.dao.UserDaoImpl;
import board.dto.UserDto;

public class UserServiceImpl implements UserService {
	@Override
	public int userRegister(UserDto userDto) {
		UserDao userDao = new UserDaoImpl();
		return userDao.userRegister(userDto);
	}
}
