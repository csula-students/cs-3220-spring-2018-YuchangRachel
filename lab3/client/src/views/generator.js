import constants from '../constants.js';

export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor() {
			super();
			this.store = store;

			// TODO: render generator initial view
			this.innerHTML = this.render();

			// TODO: subscribe to store on change event
			this.onStateChange = this.handleStateChange.bind(this);

			// TODO: add click event

			this.addEventListener('click', () => {
				console.log('buy generator');

				this.store.dispatch({
					type: constants.actions.BUY_GENERATOR,
					payload: {
						name: this.store.state.generators[this.dataset.id].name,
						quantity: this.store.state.generators[this.dataset.id].quantity
					}
				});
			});
		}

		handleStateChange(newState) {
			console.log('GeneratorComponent#stateChange', this, newState);
			const generator = newState.generators[this.dataset.id];
			this.innerHTML = this.render();
			// this.innerHTML = this.render(generator);
		}

		connectedCallback() {
			console.log('GeneratorComponent#stateChange');
			this.store.subscribe(this.onStateChange)
		}

		disconnectedCallback() {
			this.store.unsubscribe(this.onStateChange);
		}

		render() {
			const generator = this.store.state.generators[this.dataset.id];

			return `
			<div class="generator_box">
				<div class="generator_header">
					<h3 class="generator_name">${generator.name}</h3>
					<a class="generator_quantity">${generator.quantity}</a>
				</div>

				<p class ="generator_description">${generator.description}</p>
				<div class="generator_footer">
					<a class="generator_rate">${generator.rate}/60</a>
					<button class="generator_button">${generator.unlockValue} Cookies</button>
				</div>
			</div>
			`
		}
	};
}
