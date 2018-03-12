import constants from '../constants.js';
import Generator from '../models/generator';

export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			this.innerHTML = this.render();
			this.onStateChange = this.handleStateChange.bind(this);

			// TODO: render generator initial view

			// TODO: subscribe to store on change event

			// TODO: add click event
			this.querySelector('.generator_button').addEventListener('click', () => {
				const generator = new Generator(this.store.state.generators[this.dataset.id]);
				this.store.dispatch({
					type: constants.actions.BUY_GENERATOR,
					payload: {
						name: generator.name,
						quantity: generator.quantity
					}
				});
			});
		}

		handleStateChange (newState) {
			console.log('GeneratorComponent#stateChange', this, newState);
			const generator = newState.generators[this.dataset.id];
			this.querySelector('.generator_quantity').innerHTML = generator.quantity;
			this.querySelector('.generator_button').innerHTML = `${generator.unlockValue} Cookies`;
		}

		connectedCallback () {
			console.log('GeneratorComponent#stateChange');
			this.store.subscribe(this.onStateChange);
		}

		disconnectedCallback () {
			this.store.unsubscribe(this.onStateChange);
		}


		render() {
			const generator = this.store.state.generators[this.dataset.id];
			return `
				<h3 class="generator_name">${generator.name}</h3>
				<span class="generator_quantity">${generator.quantity}</span>

				<p class ="generator_description">${generator.description}</p>

				<a class="generator_rate">${generator.rate}/60</a>
				<button class="generator_button">${generator.baseCost} Cookies</button>

				`
		}
	};
}
