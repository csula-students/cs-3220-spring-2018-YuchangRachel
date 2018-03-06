import constants from '../constants.js';


export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;

			// TODO: render generator initial view
			this.innerHTML = this.render();

			// TODO: subscribe to store on change event
			this.onStateChange = this.handleStateChange.bind(this);

			// TODO: add click event
			this.addEventListener('click',  () => {
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
		

		handleStateChange(newState){
			this.innerHTML = this.render();
			console.log('CounterComponent#stateChange', this, newState);
		}

		connectedCallBack(){
			console.log(this, this.dataset.id);
			this.store.subscribe(this.onStateChange)

		}

		disconnectedCallback () {
			this.store.unsubscribe(this.onStateChange);
		}

		render(){
			return `
			<div class="generator_box">
				<div class="generator_header">
					<h3 class="generator_name">${this.store.state.generators[this.dataset.id].name}</h3>
					<a class="generator_quantity">${this.store.state.generators[this.dataset.id].quantity}</a>
				</div>

				<p class ="generator_description">${this.store.state.generators[this.dataset.id].description}</p>

				<div class="generator_footer">
					<a class="generator_rate">${this.store.state.generators[this.dataset.id].rate}/60</a>
					<button class="generator_button">${this.store.state.generators[this.dataset.id].unlockValue} Cookies</button>
				</div>
			</div>
			`
		}
	};
}
