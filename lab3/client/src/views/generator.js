import constants from '../constants.js';

import Generator from '../models/generator'



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

			this.querySelector('button').addEventListener('click', () => {

				const generator = new Generator(this.store.state.generators[this.dataset.id])

				this.store.dispatch({

					type: constants.actions.BUY_GENERATOR,

					payload: {

						name: generator.name

					}

				});

			});

		}





		handleStateChange(newState) {

			console.log('GeneratorComponent#stateChange', this, newState);

			const generator = newState.generators[this.dataset.id]

			this.querySelector('.generator_quantity').innerHTML = generator.quantity

			this.querySelector('.generator_button').innerHTML = `${generator.baseCost} Cookies`

		}



		connectedCallback() {

			console.log('GeneratorComponent#stateChange');

			this.store.subscribe(this.onStateChange)



		}



		disconnectedCallback() {

			this.store.unsubscribe(this.onStateChange);

		}



		render() {

			const generator = this.store.state.generators[this.dataset.id]

			return `

			<div class="generator_box">

				<div class="generator_header">

					<h3 class="generator_name">${generator.name}</h3>

					<a class="generator_quantity">${generator.quantity}</a>

				</div>



				<p class ="generator_description">${generator.description}</p>



				<div class="generator_footer">

					<a class="generator_rate">${generator.rate}/60</a>

					<buy-button data-id="${generator.name}"></buy-button>

					<button class="generator_button">${generator.baseCost} Cookies</button>

				</div>

			</div>

			`

		}

	};

}
