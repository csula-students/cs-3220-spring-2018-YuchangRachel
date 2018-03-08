import constants from './constants.js';
import Generator from './models/generator'

export default function reducer(state, action) {
	switch (action.type) {
		case constants.actions.EXAMPLE:
			state.example = action.payload;
			return state;

		case constants.actions.BUTTON_CLICK:

			state.counter++;

			return state;



		case constants.actions.BUY_GENERATOR:

			for (var i = 0; i < state.generators.length; i++) {

				if (state.generators[i].name === action.payload.name) {

					const generator = new Generator(state.generators[i]);

					state.generators[i].baseCost = generator.getCost()

					state.counter = state.counter - generator.getCost();

					state.generators[i].quantity++

				}

			}

			return state;

		default:

			return state;

	}

}


