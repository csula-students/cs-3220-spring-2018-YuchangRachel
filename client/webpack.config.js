const path = require('path');

module.exports = {
	entry: './src/app.js',
	output: {
		filename: 'app.bundle.js',
		path: path.join(__dirname, '..', 'src', 'main', 'webapp', 'js')
	},
	module: {
		rules: [
			{ test: /\.js$/, loader: 'babel-loader', exclude: /node_modules/ },
		]
	}
};
