package edu.factory;


import edu.dao.WebProjectDao;

public class DaoFactory {

	public static WebProjectDao getWebProjectDao() {
		return WebProjectDao.getWebProjectDao();
	}
}
