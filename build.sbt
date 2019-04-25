enablePlugins(ScalaJSBundlerPlugin)

name := "emailcomponent"

version := "0.1"

scalaVersion := "2.12.8"

// Add npm packages
npmDependencies in Compile += "react" -> "16.8.1"
npmDependencies in Compile += "react-dom" -> "16.8.1"
npmDependencies in Compile += "react-proxy" -> "1.1.8"
npmDependencies in Compile += "react-router-dom" -> "5.0.0"

// Required npm packages to bundle with Webpack
npmDevDependencies in Compile += "url-loader" -> "0.6.2"
npmDevDependencies in Compile += "css-loader" -> "0.28.7"
npmDevDependencies in Compile += "html-webpack-plugin" -> "3.2.0"
npmDevDependencies in Compile += "copy-webpack-plugin" -> "4.5.1"
npmDevDependencies in Compile += "static-site-generator-webpack-plugin" -> "3.4.1"

version in webpack := "4.5.0"
version in startWebpackDevServer:= "3.2.1"

webpackConfigFile in fastOptJS := Some(baseDirectory.value / "webpack" / "webpack-fastopt.config.js")
webpackConfigFile in fullOptJS := Some(baseDirectory.value / "webpack" / "webpack-opt.config.js")

webpackDevServerExtraArgs in fastOptJS := Seq("--inline", "--hot")
webpackBundlingMode in fastOptJS := BundlingMode.LibraryOnly()

// ScalaJS options
scalacOptions += "-P:scalajs:sjsDefinedByDefault"

// Add libraries
libraryDependencies += "me.shadaj" %%% "slinky-web" % "0.6.0"
libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.6.0"

// Command alias
addCommandAlias("dev", ";fastOptJS::startWebpackDevServer;~fastOptJS")
addCommandAlias("build", "fullOptJS::webpack")