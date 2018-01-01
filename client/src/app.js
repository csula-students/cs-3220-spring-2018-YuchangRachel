import '@webcomponents/webcomponentsjs';

import {loop} from './game';
import Store from './store';

import ButtonComponent from './views/button';
import CounterComponent from './views/counter';
import ExampleComponent from './views/example';
import GeneratorComponent from './views/generator';
import StoryBookComponent from './views/story-book';

main();

// main function wraps everything at top level
function main () {
	// TODO: fill the blank based on the theme you have choosen
	const initialState = {
		example: 'Hello custom element',
		resource: {},
		generators: [],
		story: []
	};

	// initialize store
	const store = new Store(reducer, initialState);
	console.log(ExampleComponent(store));

	// define web components
	window.customElements.define('component-example', ExampleComponent(store));
	window.customElements.define('game-button', ButtonComponent(store));
	window.customElements.define('game-counter', CounterComponent(store));
	window.customElements.define('game-generator', GeneratorComponent(store));
	window.customElements.define('game-story-book', StoryBookComponent(store));

	// For ease of debugging purpose, we will expose the critical store under window
	window.store = store;

	// start game loop
	loop(store);
}

function reducer (state, action) {
	switch (action.type) {
	case 'EXAMPLE_MUTATION':
		state.example = action.payload;
		return state;
	case 'INCREMENT':
		state.resource.value ++;
		return state;
	case 'ADD_GENERATOR':
		state.generators.push(action.payload);
		return state;
	default:
		return state;
	}
}

