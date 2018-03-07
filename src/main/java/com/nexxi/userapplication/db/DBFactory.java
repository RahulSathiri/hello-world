package com.nexxi.userapplication.db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;


@Service
public class DBFactory {
	private final DBConnectionProperties dbProperties;
	private final Database smsDB;

	@Autowired
	public DBFactory(DBConnectionProperties dbProperties) {
		this.dbProperties = dbProperties;
		System.setProperty("norm.jdbcUrl", dbUrl("sms"));
		System.setProperty("norm.user", dbProperties.user());
		System.setProperty("norm.password", dbProperties.password());
		smsDB = new Database();
	}

	public Database getSchoolDb() {
		return smsDB;
	}

	private String dbUrl(String schema) {
		return "jdbc:mysql://" + dbProperties.host() + ":" + dbProperties.port() + "/" + schema + "?useSSL=false";
	}

}
