enablePlugins(ScalaJSBundlerPlugin)

name := "email"

version := "0.1"

scalaVersion := "2.12.8"

// Add npm packages
npmDependencies in Compile += "react" -> "16.8.6"
npmDependencies in Compile += "react-dom" -> "16.8.6"
npmDependencies in Compile += "react-router-dom" -> "5.0.0"

// Required by hot reloading
npmDependencies in Compile += "react-proxy" -> "1.1.8"

// Required npm packages to bundle with Webpack
npmDevDependencies in Compile += "url-loader" -> "1.1.2"
npmDevDependencies in Compile += "css-loader" -> "2.1.1"
npmDevDependencies in Compile += "html-webpack-plugin" -> "3.2.0"
npmDevDependencies in Compile += "copy-webpack-plugin" -> "5.0.3"
npmDevDependencies in Compile += "static-site-generator-webpack-plugin" -> "3.4.2"

// So we can access the site at http://localhost:9000
webpackDevServerPort := 9000

version in webpack := "4.30.0"
version in startWebpackDevServer:= "3.3.1"

webpackConfigFile in fastOptJS := Some(baseDirectory.value / "webpack" / "webpack-fastopt.config.js")
webpackConfigFile in fullOptJS := Some(baseDirectory.value / "webpack" / "webpack-opt.config.js")

webpackDevServerExtraArgs in fastOptJS := Seq("--inline", "--hot")
webpackBundlingMode in fastOptJS := BundlingMode.LibraryOnly("EmailKit")
webpackBundlingMode in fullOptJS := BundlingMode.LibraryAndApplication("EmailKit")

// ScalaJS options
scalacOptions += "-P:scalajs:sjsDefinedByDefault"

// For using `@react` annotation
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

// Add libraries
libraryDependencies += "me.shadaj" %%% "slinky-web" % "0.6.0"
libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.6.0"

// Command alias
addCommandAlias("dev", ";fastOptJS::startWebpackDevServer;~fastOptJS")
addCommandAlias("prod", "fullOptJS::webpack")
