/*eslint-env node, mocha */
import reducer from '../src/reducer';
import {assert} from 'chai';

describe('reducer', function() {
	it('should be able to set example state from "EXAMPLE_MUTATION" action', function() {
		const action = {
			type: 'EXAMPLE_MUTATION',
			payload: 'mutated'
		};
		const initialState = {
			example: 'hello'
		};
		const expected = action.payload;
		assert.equal(reducer(initialState, action).example, expected);
	});
});
