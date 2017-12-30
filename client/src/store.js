// Store is heavily inspired by Redux from React pattern to handle state management
export default class Store {
	constructor (reducer, initialState = {}) {
		this.reducer = reducer;
		// listeners are internal state to keep track of which reducers to call in this
		// order
		this.listeners = [];
		// initial state
		this.state = initialState;
	}

	getState () {
		return deepCopy(this.state);
	}

	dispatch (action) {
		this.state = this.reducer(deepCopy(this.state), action);
		this.listeners.forEach(l => l(this.state));
	}

	subscribe (listener) {
		this.listeners.push(listener);
	}
}

// deepCopy function is to create a immutability of certain object
function deepCopy(obj) {
	return JSON.parse(JSON.stringify(obj));
}
