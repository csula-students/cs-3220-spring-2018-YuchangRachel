// Dependency Injection pattern to inject store into the GeneratorComponent
export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			this.textContent = 'Hello custom element';

			// add click event
		}
	};
}
