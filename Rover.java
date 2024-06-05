
public class Rover {
    private int x;
    private int y;
    private Direction direction;
    private final Grid grid;

    public Rover(int x, int y, Direction direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public void executeCommand(Command command) {
        command.execute(this);
    }

    public void move() {
        int newX = x, newY = y;
        switch (direction) {
            case N -> newY += 1;
            case S -> newY -= 1;
            case E -> newX += 1;
            case W -> newX -= 1;
        }
        if (grid.isWithinBounds(newX, newY) && !grid.hasObstacle(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public String getStatus() {
        return "Rover is at (" + x + ", " + y + ") facing " + direction;
    }
}
