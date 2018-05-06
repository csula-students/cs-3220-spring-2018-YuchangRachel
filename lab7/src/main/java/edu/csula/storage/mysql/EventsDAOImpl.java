package edu.csula.storage.mysql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.sql.*;

import edu.csula.storage.EventsDAO;
import edu.csula.storage.Database;
import edu.csula.models.Event;

public class EventsDAOImpl implements EventsDAO {
	private final Database context;

	// TODO: fill the Strings with the SQL queries as "prepated statements" and
	//       use these queries variable accordingly in the method below
	protected static final String getAllQuery = "SELECT * FROM events;";
	protected static final String getByIdQuery = "SELECT * FROM events WHERE events.id = ?";
	protected static final String setQuery = "UPDATE events SET name = ? , description = ?, trigger_at = ? WHERE events.id = ?";
	protected static final String addQuery = "INSERT INTO events (name, description, trigger_at) VALUES (?, ?, ?)";
	protected static final String removeQuery = "DELETE FROM events WHERE events.id = ? ";

	public EventsDAOImpl(Database context) {
		this.context = context;
	}

	@Override
	public List<Event> getAll() {
		// TODO: get all events from jdbc
		List<Event> list = new ArrayList<>();
		try (Connection c = context.getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery(getAllQuery);
			while (rs.next()) {
				//get column index:id, name, description, trigger_at
				Event event = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		return list;
	}

	@Override
	public Optional<Event> getById(int id) {
		// TODO: get specific event by id
		Optional<Event> items = Optional.empty();

		try (Connection c = context.getConnection(); PreparedStatement pstmt = c.prepareStatement(getByIdQuery)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()){
				Event event = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				items = Optional.of(event);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		return items;
	}

	@Override
	public void set(int id, Event event) {
		// TODO: update specific event by id
		try (Connection c = context.getConnection(); PreparedStatement pstmt = c.prepareStatement(setQuery)){
			pstmt.setInt(1, id);
			pstmt.setString(2, event.getName());
			pstmt.setString(3, event.getDescription());
			pstmt.setInt(4, event.getTriggerAt());
			pstmt.setInt(5, event.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void add(Event event) {
		// TODO: implement jdbc logic to add a new event
		try (Connection c = context.getConnection(); PreparedStatement pstmt = c.prepareStatement(addQuery)) {
			pstmt.setString(1, event.getName());
			pstmt.setString(2, event.getDescription());
			pstmt.setInt(3, event.getTriggerAt());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		// TODO: implement jdbc logic to remove event by id
		try (Connection c = context.getConnection(); PreparedStatement pstmt = c.prepareStatement("DELETE FROM events WHERE events.id = ? ")) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
