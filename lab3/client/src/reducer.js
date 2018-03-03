export default function reducer (state, action) {
	switch (action.type) {
	case 'EXAMPLE_MUTATION':
		state.example = action.payload;
		return state;

	case 'BUY_GENERATOR':

		if (data-id === '0'){
			state.type = 'GENERATOR';
			state.name = 'Cursor';
			state.baseCost = state.getCost();
			state.quantity++;
			state.counter = state.counter - state.baseCost;
			window.state.counter = state.counter;
			state.unlockValue = state.baseCost; 
		}
		else if (data-id === '1'){
			state.type = 'GENERATOR';
			state.name = 'Grandma';
			state.baseCost = state.getCost();
			state.quantity++;
			state.counter = state.counter - state.baseCost;
			window.state.counter = state.counter;
			state.unlockValue = state.baseCost;
		}
		else if (data-id === '2'){
			state.type = 'GENERATOR';
			state.name = 'Factory';
			state.baseCost = state.getCost();
			state.quantity++;
			state.counter = state.counter - state.baseCost;
			window.state.counter = state.counter;
			state.unlockValue = state.baseCost;
		}


		
	default:
		return state;
	}
}

