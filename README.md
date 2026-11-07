# CMSC335-w4-Discussion

## binary-conversion-app

A JavaFX app that shows the IEEE 754 double-precision binary form of a decimal number as you type it. The output is split into sign bit, exponent, and mantissa.

### Prerequisites

- JDK 11 or newer (`java -version`)
- Apache Maven (`mvn -version`)

You don't need to install JavaFX separately. Maven downloads it as a dependency.

### Installation

Clone the repository and move into it:

```bash
git clone https://github.com/cookelg/CMSC335-w4-Discussion.git
cd CMSC335-w4-Discussion
```

If you have SSH keys set up with GitHub, you can clone over SSH instead:

```bash
git clone git@github.com:cookelg/CMSC335-w4-Discussion.git
```

### Running from the command line

From the repository root:

```bash
cd binary-conversion-app
mvn clean javafx:run
```

Maven compiles the project and opens the app window. The first run takes longer because Maven downloads its dependencies.

To compile without launching:

```bash
mvn compile
```

### Usage

Type a decimal number (for example `1.5` or `-0.1`) into the text field. The binary representation updates on every keystroke.
