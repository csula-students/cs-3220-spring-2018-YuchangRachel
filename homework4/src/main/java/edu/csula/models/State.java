package edu.csula.models;

import java.util.Collection;

public class State {
	private Collection<Event> stories;
	private Collection<Generator> generators;

	public State(Collection<Event> stories, Collection<Generator> generators) {
		this.stories = stories;
		this.generators = generators;
	}
}
