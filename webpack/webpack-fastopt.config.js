// Webpack configuration for development environment (fast opt)
// The build will copy this file to the target of ScalaJS bundler (`target/scala-2.12/scalajs-bundler/main`)

// Define the root directory, so we can get rid of nested relative paths such as `../../`
const ROOT_DIR = '/home/phuocnguyen/emailcomponent';

const path = require("path");
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyWebpackPlugin = require('copy-webpack-plugin');

module.exports = {
    mode: 'development',

    // The next `entry` and `output` sections can be copied from `scalajs.webpack.config.js`
    // We can merge the sections by using `webpack-merge`
    entry: {
        'email-fastopt': ['./email-fastopt-entrypoint.js']
    },
    output: {
        path: `${ROOT_DIR}/target/scala-2.12/scalajs-bundler/main`,
        // `[name]` will be replaced with `email-fastopt` automatically
        filename: '[name]-library.js',
        library: 'ScalaJSBundlerLibrary',
        libraryTarget: 'var'
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                use: ['css-loader']
            },
            // url loader for svg
            {
                test: /\.svg$/,
                use: ['url-loader']
            }
        ],
        noParse: (content) => {
            return content.endsWith('-fastopt.js');
        }
    },
    plugins: [
        new CopyWebpackPlugin([
            // Copy static resources from `public` to `build`
            { from: `${ROOT_DIR}/public` }
        ]),
        // Auto insert the link to bundled script to `public/index.html`
//        new HtmlWebpackPlugin({
//            template: `${ROOT_DIR}/public/index.html`
//        })
    ]
};
