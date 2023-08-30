public class Player {
  // Private fields to store player name and symbol (X or O)
private String name;
private char symbol;

// Constructor to initialize player name and symbol
Player(String name, char symbol) {
  this.name = name;
  this.symbol = symbol;
}  

// Getter method for player name
public String getName() {
  return name;
}
// Getter method for player symbol
public char getSymbol() {
  return symbol;
}
}

