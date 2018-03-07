package com.nexxi.userapplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dieselpoint.norm.Database;
import com.nexxi.userapplication.db.DBFactory;
import com.nexxi.userapplication.models.User;

public class UserService {

	@Autowired
	private Database database;
	private DBFactory db;

	public String addingUser(User user) {

		database = db.getSchoolDb();
		int roweffected = database.insert(user).getRowsAffected();
		if (roweffected <= 0) {
			return "failed";
		}
		return "success";

	}

	public List<User> listofUsers() {
		database = db.getSchoolDb();

		return database.results(User.class);
	}

	public String updatingUser(Long id, User user) {
		database = db.getSchoolDb();
		user.setId(id);
		int roweffected = database.update(user).where("id=?", id).getRowsAffected();
		if (roweffected <= 0) {
			return "update failure";

		}
		return "update successs";
	}

	public String deletingUser(Long id, User user) {
		database = db.getSchoolDb();
		user.setId(id);
		int roweffected = database.delete(user).where("id=?", id).getRowsAffected();
		if (roweffected <= 0) {
			return "no deletion";
		}
		return "user deletion successful";
	}

}
