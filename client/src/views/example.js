// Dependency Injection pattern to inject store into the GeneratorComponent
export default function (store) {
	return class ExampleComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			console.log(this.store);
			// initial DOM rendering
			this.textContent = this.store.state.example;

			this.onStateChange = this.handleStateChange.bind(this);

			// add click event
			this.addEventListener('click', () => {
				this.store.dispatch({
					type: 'EXAMPLE_MUTATION',
					payload: 'You clicked this element'
				});
			});
		}

		handleStateChange (newState) {
			console.log('stateChanges!', this);
			this.textContent = newState.example;
		}

		connectedCallback () {
			console.log('on connected callback');
			this.store.subscribe(this.onStateChange);
		}

		disconnectedCallback () {
			console.log('on disconnected callback');
			this.store.unsubscribe(this.onStateChange);
		}
	};
}
