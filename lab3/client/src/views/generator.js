export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;

			// TODO: render generator initial view
			this.textContent = this.store.state.example;

			// TODO: subscribe to store on change event
			this.onStageChange = this.handleStateChange.bind(this);

			// TODO: add click event
			document.querySelector('#Cursor').addEventListener('click',()=>{
				this.store.dispatch({
					type: 'BUY_GENERATOR',
					payload : 'Cursor',

				});
			});
			document.querySelector('#Grandma').addEventListener('click',()=>{
				this.store.dispatch({
					type: 'BUY_GENERATOR',
					payload : 'Grandma',

				});
			});

			document.querySelector('#Factory').addEventListener('click',()=>{
				this.store.dispatch({
					type: 'BUY_GENERATOR',
					payload : 'Factory',

				});
			});
			
		}
	
		handleStateChange(newState){
			console.log('GeneratorComponent#stateChange', this, newState);
			this.textContent = newState.example;

		}

		connectedCallback () {
            console.log('GeneratorComponent#onConnectedCallback');
            this.store.subscribe(this.onStateChange);
        }

        disconnectedCallback () {
            console.log('GeneratorComponent#onDisconnectedCallback');
            this.store.unsubscribe(this.onStateChange);
        }
	};
}
