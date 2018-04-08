package edu.csula.storage;

import java.util.Collection;
import java.util.Optional;

import edu.csula.models.Generator;

/**
 * EventsDAO defines the database access layer between the business layer and
 * the database layer
 */
public interface GeneratorsDAO {
	/**
	 * Find all generators
	 */
	public Collection<Generator> getAll();
	/**
	 * Find a specific generator given its id
	 */
	public Optional<Generator> getById(int id);
	/**
	 * Change a generator given its id
	 */
	public void set(int id, Generator generator);
	/**
	 * addEvent adds a new generator to database storage
	 */
	public void add(Generator generator);
}
