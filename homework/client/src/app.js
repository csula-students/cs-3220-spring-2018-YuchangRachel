import '@webcomponents/webcomponentsjs';

import {loop} from './game';
import Store from './store';
import reducer from './reducer';

import ButtonComponent from './views/button';
import CounterComponent from './views/counter';
import ExampleComponent from './views/example';
import GeneratorComponent from './views/generator';
import StoryBookComponent from './views/story-book';

/**
 * Data flow diagram
 +----------------------------------------------------+
 | +------------------+          +------------------+ |
 | |                  |          |                  | |
++-|       Loop       |<---------|    Generator     | |
|| |                  |          |                  | |
|| +------------------+          +------------------+ |
||G          ^                                        |
||a          +-----------------------------+          |
||m                                        |          |
||e                                        |          |
||                               +------------------+ |
||                               |                  | |
||                               |     Stories      | |
||                               |                  | |
||                               +------------------+ |
|+----------------------------------------------------+
+------------------------------------------------------------+
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|       +----------------------------------------------------+----------+
|       | +------------------+                     +------------------+ |
|       | |                  |        Mutates      |                  | |
|       | |     Reducer      |-------------------->|      State       | |
|       | |                  |                     |                  | |
|       | +------------------+                     +------------------+ |
|       |S          ^                                        |          |
|       |t          |                                        |          |
|       |o          |                                        |          |
|       |r          | Triggers                     Notifies  |          |
|       |e          |                                        |          |
|       |           |                                        v          |
|       | +------------------+                     +------------------+ |
|       | |                  |                     |                  | |
+-------+>|      Action      |                     |    Listeners     | |
		| |                  |                     |                  | |
		| +------------------+                     +------------------+ |
		+-----------^----------------------------------------+----------+
					|                                        |
					|                                        |
					|                                        |
					|                                        |
					| Dispatches                             |
					|                                        |
					|                                        |
		  +------------------+                               |
		  |                  |                               |
		  |      Views       |              Notifies changes |
		  |    Components    |<------------------------------+
		  |                  |
		  +------------------+
		  */
main();

// main function wraps everything at top level
function main () {
	// TODO: fill the blank based on the theme you have choosen
	const initialState = {
		example: 'Hello custom element',
		counter: 0,
		generators: [
			{
				type: 'BUY_GENERATOR',
				name: 'Cursor',
				description: 'Cursor produces 5 cookies per minute, its purchase price increased by5%.',
				rate: 5,
				quantity: 0,
				baseCost: 10,
				unlockValue: 10
			},
			{
				type: 'BUY_GENERATOR',
				name: 'Grandma',
				description: 'Grandma produces 10 cookies per minute, its purchase price increased by10%.',
				rate: 10,
				quantity: 0,
				baseCost: 100,
				unlockValue: 100
			},
			{
				type: 'BUY_GENERATOR',
				name: 'Factory',
				description: 'Factory produces 50 cookies per minute, its purchase price increased by20%',
				rate: 25,
				quantity: 0,
				baseCost: 1000,
				unlockValue: 1000
			}
		],
		stories: [
			{
				name: 'Cursor walks by',
				description: 'Cursor making cookies',
				triggeredAt: 10
			},
			{
				name: 'Grandma shows up',
				description: 'Grandma baking cookies',
				triggeredAt: 100,
				state: 'hidden'
			},
			{
				name: 'Factory builds up',
				description: 'Factory producing and delieving cookies',
				triggeredAt: 1000,
				state: 'hidden'
			},

		]
	};

	// initialize store
	const store = new Store(reducer, initialState);
//	console.log(ExampleComponent(store));

	// define web components
	window.customElements.define('component-example', ExampleComponent(store));
	// no longer used
	window.customElements.define('game-button', ButtonComponent(store));
	window.customElements.define('game-counter', CounterComponent(store));
	// lab 3
	window.customElements.define('game-generator', GeneratorComponent(store));
	// homework 1
	window.customElements.define('game-story-book', StoryBookComponent(store));

	// For ease of debugging purpose, we will expose the critical store under window
	// ps: window is global
	window.store = store;

	// start game loop
	loop(store);
}
