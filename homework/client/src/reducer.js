import constants from './constants.js';
import Generator from './models/generator';
import Story from './models/story';


export default function reducer(state, action) {
	switch (action.type) {
	case constants.actions.EXAMPLE:
		state.example = action.payload;
		return state;

	case constants.actions.INCREMENT:
		state.counter += action.payload;
		return state;

	case constants.actions.BUY_GENERATOR:
		state.generators.forEach(generator => {
			if(generator.name === action.payload.name){
				const g = new Generator(generator);
				let cost = g.getCost(); 
				if(cost <= state.counter){ 
					state.counter -= cost; 
					generator.quantity++;
					generator.unlockValue = g.getCost();  //new quantity 
				}
				else {
					alert('not enough cookies!!!');
				}
			}
		});
		return state;

	case constants.actions.CHECK_STORY:
		state.stories.forEach(story => {
			const s = new Story(story);
			if(s.isUnlockYet(state.counter)){
				s.state = "visible";
				story.state = s.state;

			}
		});
		return state;

	default:
		return state;
	}
}


