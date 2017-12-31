// Store is heavily inspired by Redux from React pattern to handle state management
export default class Store {
	constructor (reducer, initialState = {}) {
		this.reducer = reducer;
		// listeners are internal state to keep track of which reducers to call in this
		// order
		this.listeners = [];
		// initial state
		this.__state = initialState;
	}

	// READ only state
	get state () {
		return deepCopy(this.__state);
	}

	// only way to change state is by dispatching actions and go through reducer
	dispatch (action) {
		this.__state = this.reducer(this.state, action);
		this.listeners.forEach(l => l(this.state));
	}

	// Observable pattern to listen for changes
	subscribe (listener) {
		this.listeners.push(listener);
	}
	unsubscribe (listener) {
		this.listeners = this.listeners.filter(l => l != listener);
	}
}

// deepCopy function is to create a immutability of certain object
function deepCopy(obj) {
	return JSON.parse(JSON.stringify(obj));
}
