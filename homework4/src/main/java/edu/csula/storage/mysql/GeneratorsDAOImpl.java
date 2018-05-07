package edu.csula.storage.mysql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.csula.storage.GeneratorsDAO;
import edu.csula.storage.Database;
import edu.csula.models.Generator;

import java.sql.*;

public class GeneratorsDAOImpl implements GeneratorsDAO {
	private final Database context;

	// TODO: fill the Strings with the SQL queries as "prepated statements" and
	//       use these queries variable accordingly in the method below
	//       should the same dataname as in database
	protected static final String getAllQuery = "SELECT * FROM generators;";
	protected static final String getByIdQuery = "SELECT 8 FROM generators WHERE generators.id = ?";
	protected static final String setQuery = "UPDATE generators SET name = ?, description = ?, rate = ?, base_cost = ?, unlock_at = ? WHERE generators.id = ?";
	protected static final String addQuery = "INSERT INTO generators(name, description, rate, base_cost,unlock_at) VALUE (?, ?, ?, ?, ?)";
	protected static final String removeQuery = "DELETE FROM generators WHERE generators.id = ?";

	public GeneratorsDAOImpl(Database context) {
		this.context = context;
	}

	@Override
	public List<Generator> getAll() {
		// TODO: get all generators from jdbc
		List<Generator> list = new ArrayList<>();
		try (Connection c = context.getConnection(); Statement stmt = c.createStatement()){
			ResultSet rs = stmt.executeQuery(getAllQuery);
			while (rs.next()){
				Generator generator = new Generator(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6));

				list.add(generator);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return list;
		}

		return list;
	}

	@Override
	public Optional<Generator> getById(int id) {
		// TODO: get specific generator by id
		Optional<Generator> items = Optional.empty();

		try (Connection c = context.getConnection(); PreparedStatement pstmt = c.prepareStatement(getByIdQuery)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()){
				Generator generator = new Generator(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6));

				items = Optional.of(generator);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		return items;
	}

	@Override
	public void set(int id, Generator generator) {
		// TODO: update specific generator by id
		try (Connection c = context.getConnection(); PreparedStatement pstmt = c.prepareStatement(setQuery)){
			pstmt.setString(1, generator.getName());
			pstmt.setString(2, generator.getDescription());
			pstmt.setInt(3, generator.getRate());
			pstmt.setInt(4, generator.getBaseCost());
			pstmt.setInt(5, generator.getUnlockAt());
			pstmt.setInt(6, id);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(Generator generator) {
		// TODO: implement jdbc logic to add a new generator

		try (Connection c = context.getConnection(); PreparedStatement pstmt = c.prepareStatement(addQuery)) {
			pstmt.setString(1, generator.getName());
			pstmt.setString(2, generator.getDescription());
			pstmt.setInt(3, generator.getRate());
			pstmt.setInt(4, generator.getBaseCost());
			pstmt.setInt(5, generator.getUnlockAt());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		// TODO: implement jdbc logic to remove generator by id
		try (Connection c = context.getConnection(); PreparedStatement pstmt = c.prepareStatement(removeQuery)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
