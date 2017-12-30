export default class GeneratorComponent extends window.HTMLElement {
	constructor () {
		super();
		this.textContent = 'Hello custom element';
	}
}
