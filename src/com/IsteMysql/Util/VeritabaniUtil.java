package com.IsteMysql.Util;
import java.sql.*;
public class VeritabaniUtil {
static Connection conn=null;



public static Connection Baglan() {
	
	
try {
	
conn=DriverManager.getConnection("jdbc:mysql://localhost/yemek_rezervasyon?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "mysql");
return conn;
} catch (Exception e) {
System.out.println(e.getMessage().toString());
return null;
}
}
}
