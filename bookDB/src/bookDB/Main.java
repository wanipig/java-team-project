package bookDB;


import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		String url = "jdbc:mysql://127.0.0.1:3306/bookdb";
		String username = "user";
		String password = "12345";
		
		//Select
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			
			System.out.println("bookdb 접속 성공");
			
			String selectSql = "SELECT * FROM books";
			try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSql)) {
				
				while(rs.next()){
					String ISBN = rs.getString("ISBN");
					String title = rs.getString("title");
					String publisher = rs.getString("publisher");
					int count = rs.getInt("count");
					String author = rs.getString("author");
					
					System.out.printf(" ISBN: %s, title: %s, publisher: %s, count: %d, author: %s", ISBN, title, publisher, count, author);
					
				}
				
			
			}
			
			//Insert
			String insertSql = "INSERT INTO books (ISBN, title, publisher, count, author) VALUES (?, ?, ?, ?, ?)";
			try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
				
				pstmt.setString(1, input.next());
				pstmt.setString(2, input.next());
				pstmt.setString(3, input.next());
				pstmt.setInt(4, input.nextInt());
				pstmt.setString(5, input.next());
				pstmt.executeUpdate();
				
				System.out.println("책 입력 성공");
			}
			
			//Delete
			System.out.print("삭제할 책 제목 입력: ");
	        String bookTitle = input.next();

	        String deleteSql = "DELETE FROM books WHERE title = ?";

	        try (PreparedStatement pstmt = conn.prepareStatement(deleteSql)) {
	            pstmt.setString(1, bookTitle);
	            int rows = pstmt.executeUpdate();
	            if (rows > 0) {
	                System.out.println("책 정보가 삭제되었습니다.");
	            } else {
	                System.out.println("해당 책이 없습니다.");
	            }
	        }
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	
	


}

