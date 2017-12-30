import '@webcomponents/webcomponentsjs';

import {loop} from './game';
import Store from './store';
import GeneratorComponent from './views/generator';

main();

// TODO: fill the blank based on the theme you have choosen
const initialState = {
	resource: [],
	generators: [],
	story: []
};

// main function wraps everything at top level
function main () {
	// initialize store
	const store = new Store(reducer, initialState);

	// TODO: bind click event to "le button"
	// hint: you will need to use `querySelector` to find button first
	//       and then you will need to use `addEventListener` to bind event

	// define web components
	window.customElements.define('game-generator', GeneratorComponent);

	// start game loop
	loop();
}

function reducer (state, action) {
	switch (action.type) {
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

