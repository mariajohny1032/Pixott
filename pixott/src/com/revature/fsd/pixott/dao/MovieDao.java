package com.revature.fsd.pixott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.fsd.pixott.Movie;

public class MovieDao {
	public static void topfivemovie() {
		String sql = "select * from viewtopfivemovies join movie where topfivemovieid=movie.id";
		List<Movie> movies = new ArrayList<>();
		try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setName(rs.getString("name"));
				movie.setGenre(rs.getString("genre"));
				movie.setSales(rs.getInt("sales"));
				movie.setYear(rs.getInt("year"));
				movies.add(movie);
				
			}
	
		}catch (SQLException e) {
			Util.displayMessage(e);
		}
		MovieDao.print();
		movies.forEach(System.out::println);
	}
	public static void searchmovie(String keyword) {
		String symbol = "%";
		String sql = String.format("select * from movie where name like '%s%s%s'", symbol,keyword,symbol);
		List<Movie> movies = new ArrayList<>();
		try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setName(rs.getString("name"));
				movie.setGenre(rs.getString("genre"));
				movie.setSales(rs.getInt("sales"));
				movie.setYear(rs.getInt("year"));
				movies.add(movie);
				
			}
	
		}catch (SQLException e) {
			Util.displayMessage(e);
		}
		MovieDao.print();
		movies.forEach(System.out::println);
	}
	public static void showWishList(String wishlist) {
		String sql= String.format("select * from movie join wishlist where user-id=%d && wishlist=movie.id;",wishlist);
		List<Movie> movies = new ArrayList<>();
		try(
				Connection connection = Util.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);
				){
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setName(rs.getString("name"));
				movie.setGenre(rs.getString("genre"));
				movie.setYear(rs.getInt("year"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			Util.displayMessage(e);
		}
		MovieDao.print();
		movies.forEach(System.out::println);

} 
	public static void print() {
		System.out.printf("%-20s %-40s %-40s %4s\n","**","****","*****","****");
		System.out.printf("%-20s %-40s %-40s %4s\n","id","Name","Genre","Year");
		System.out.printf("%-20s %-40s %-40s %4s\n","**","****","*****","****");
		
	}
}
