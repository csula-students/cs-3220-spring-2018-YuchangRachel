import constants from '../constants';

export default function (store) {
	return class ButtonComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			
			// TODO: add click event to increment counter
			// hint: use "store.dispatch" method (see example component)
		}


		connectedCallback () {
			console.log('ExampleComponent#onConnectedCallback');
			this.innerHTML = '<button>Collect Cookies</button>';
			this.addEventListener('click', () => {
				console.log('Hello click');

				this.store.dispatch({
					type: constants.actions.BUTTON_CLICK
				});
			});
		}

		disconnectedCallback () {
			console.log('ExampleComponent#onDisconnectedCallback');
			this.store.unsubscribe(this.onStateChange);
		}
	}
}
