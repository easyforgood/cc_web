package Dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DAO{
	public Connection openConnection();
	public boolean closeConnection();

}
