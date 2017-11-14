package ca.ciccc.madp202.maisaya.InterviewerBackend.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MySQLConnector {
	
	//登録時
	public static void insertUser(String query) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:8080/interview", "root", "");
            con.createStatement().executeUpdate(query);
            
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
            }
        }   
    }
	
	//ログイン時
	public static ArrayList<String> connectUser(String query) {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:8080/interview", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ArrayList<String> data = new ArrayList<>();
				
			while(rs.next()){
			    /* 行からデータを取得 */
				String userid = rs.getString("userid");
				String firstname = rs.getString("first_name");
			    String lastname = rs.getString("last_name");
			    String country = rs.getString("country");
				String username = rs.getString("username");
			    String password = rs.getString("password");
			    
			    data.add(userid);
			    data.add(firstname);
			    	data.add(lastname);
			    	data.add(country);	
			    data.add(username);
			    	data.add(password);
			}
				rs.close();
				stmt.close();
				return data;
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (con != null) {
	                try {
	                    con.close();
	                } catch (SQLException e) {
	                        e.printStackTrace();
	                }
	            }
		}
		return null;
	}
	
	//interview Question取得時
	public static ArrayList<String[]> getQuestion(String query){
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:8080/interview", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ArrayList<String[]> data = new ArrayList<>();
			
			int columnCount = rs.getMetaData().getColumnCount();
			
			while(rs.next()){
				String[] row = new String[columnCount];
				for(int i=0;i<columnCount;i++) {
					row[i] = rs.getString(i+1);
				}
				data.add(row);
			}
				rs.close();
				stmt.close();
				return data;
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (con != null) {
	                try {
	                    con.close();
	                } catch (SQLException e) {
	                        e.printStackTrace();
	                }
	            }
		}
		return null;
	}
	
	//ヒストリー格納時
//	public static void insertHistory(String tableName,String fieldName, ArrayList<String> parameters) {
//        Connection con = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/interview", "root", "");
//            con.createStatement().executeUpdate(parameters);
//            
//        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                        e.printStackTrace();
//                }
//            }
//        }   
//    }
	
}
