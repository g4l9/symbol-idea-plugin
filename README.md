# Spec &amp; Math symbols

[![Version](https://img.shields.io/jetbrains/plugin/v/io.galagutskiy.symbol-idea-plugin)](https://plugins.jetbrains.com/plugin/14267-spec-and-math-symbols)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/io.galagutskiy.symbol-idea-plugin)](https://plugins.jetbrains.com/plugin/14267-spec-and-math-symbols)
[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/g4l9/symbol-idea-plugin.svg)](https://github.com/g4l9/symbol-idea-plugin/issues)
[![Percentage of issues still open](http://isitmaintained.com/badge/open/g4l9/symbol-idea-plugin.svg)](https://github.com/g4l9/symbol-idea-plugin/issues)
[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/g4l9/symbol-idea-plugin)


<div align="center">
  <img src="docs/logo.svg" width="200" height="200" alt="logo">
</div>

## Usage

<div align="center">
  <img src="docs/usage.gif" alt="usage">
</div>

## Plugin features

Inject symbols

You can find all available auto-complete symbols in the [table](SYMBOLS.md)

<div align="center">
    <img src="docs/example_1.png" alt="example_1">
</div>

Inject random value

<div align="center">
    <img src="docs/example_2.png" alt="example_2">
</div>

Inject lorem ipsum

<div align="center">
    <img src="docs/example_3.png" alt="example_3">
</div>

## Build

### Build zip plugin

```bash
./gradlew buildPlugin
```

Windows

```bash
.\gradlew.bat buildPlugin
```

### Run plugin in debug mode

Linux/MacOS

```bash
./gradlew runIde --debug-jvm
```

Windows

```bash
.\gradlew.bat runIde --debug-jvm
```