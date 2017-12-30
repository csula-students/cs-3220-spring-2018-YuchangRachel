const interval = 1000;

/**
 * loop is main loop of the game, which will be executed once every second (
 * based on the interval variable configuration)
 */
export function loop () {
	// TODO: increment counter based on the generators in the state
	setTimeout(loop, interval);
}

export function increment (state, modifier = 1) {
	return state.counter + 1 * modifier;
}
