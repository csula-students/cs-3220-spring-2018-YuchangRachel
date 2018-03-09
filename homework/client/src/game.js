import constants from './constants.js';
import Generator from './models/generator';


// default interval as 1 second
const interval = 1000;

/**
 * loop is main loop of the game, which will be executed once every second (
 * based on the interval variable configuration)
 */
//loop(store) in app.js
export function loop (store) {
	// TODO: increment counter based on the generators in the state
	// hint: read how many "generators" in store and iterate through them to
	//       count how many value to increment to "resource"
	// hint: remember to change event through `store.dispatch`
	//console.log('Game loop runnin');


	for (var i = 0; i < store.generators.length; i++) {
		if (store.generators[i].name === action.payload.name) {
			const generator = new Generator(store.generators[i]);
			store.counter = store.counter + generator.generate();

			store.dispatch({
				type: constants.actions.INCREMENT
			});
		}

	}	



	// TODO: triggers stories from story to display state if they are passed
	//       the `triggeredAt` points
	// hint: use store.dispatch to send event for changing events state

	// recursively calls loop method every second
	setTimeout(loop.bind(this, store), interval);
}


