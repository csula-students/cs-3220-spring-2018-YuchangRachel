window.incrementalGame = {
	state: {
		counter: 0
	}
};

class PubSub {
	constructor() {
		this.subList = [];
	}
	subscribe(fn){
		this.subList.push(fn);
	}
	publish(data){
		this.subList.forEach(fn => {
			fn(data);
		});
	}
}
const pubsub = new PubSub();

pubsub.subscribe(data => {
	document.querySelector("#cookie").innerText = data;
});

pubsub.subscribe(data => {
	console.log("Subscriber's counters: " + data);
});

document.querySelector('.button').addEventListener('click', () => {
	pubsub.publish(++window.incrementalGame.state.counter);
});
