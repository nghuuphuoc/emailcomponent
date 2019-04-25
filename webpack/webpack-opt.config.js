// Webpack configuration for production environment (fast opt)
// The build will copy this file to the target of ScalaJS bundler (`target/scala-2.12/scalajs-bundler/main`)

// Define the root directory, so we can get rid of nested relative paths such as `../../`
const ROOT_DIR = '/home/phuocnguyen/emailcomponent';

const path = require("path");
const webpack = require("webpack");
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyWebpackPlugin = require('copy-webpack-plugin');

module.exports = {
    mode: 'production',

    // The next `entry` and `output` sections can be copied from `scalajs.webpack.config.js`
    // We can merge the sections by using `webpack-merge`
    entry: {
        'email-opt': ['./email-opt.js']
    },
    output: {
        path: `${ROOT_DIR}/build`,
        publicPath: '/',
        // `[name]` will be replaced with `email-opt` automatically
        filename: '[name].js',
        library: 'EmailKit',
        libraryTarget: 'umd'
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
        ]
    },
    plugins: [
        new webpack.DefinePlugin({
            'process.env': {
                NODE_ENV: JSON.stringify('production')
            }
        }),
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
