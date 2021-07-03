# Calculator

- The application is a simple calculator that supports the following operations: 
  Addition, Subtraction, Multiplication and Division
- Calculator supports multi operand expressions and follows `bodmas` rule for operator precedence.
In this case, division and multiplication has precedence over addition and subtraction.
- The application reads input from a single line and prints the result back to console.
- Decimal numbers are supported
- Divisions are rounded with a scale of 2 decimals. 
  Rounding method is ROUND_HALF_EVEN as it minimizes the cumulative error.
  - ROUND_HALF_EVEN means: Round towards the "nearest neighbor" unless both neighbors are equidistant, in which case, round towards the even neighbor
- In case of invalid expressions, the application will warn the user and wait for a new input

## Usage

### Build (Skip to `Run With Docker` if JDK 11 not exists)
- It's a Java project that requires Jdk 11 or higher
  
- Run the following script in root directory in order to build with Maven:

  **`mvn clean install`**
- Run the following if Maven is not installed

  **`./mvnw clean install`**

  or in Windows

  **`./mvnw.cmd clean install`**

### Run
- Once the build is completed, you can run with one of the following commands:
 
  **`java -jar target/calculator-1.0.jar`**

### RUN WITH DOCKER
**`docker run  alidemirsoy/calculator`**
