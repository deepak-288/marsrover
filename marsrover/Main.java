package marsrover;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(10, 10);
        grid.addObstacle(2, 2);
        grid.addObstacle(3, 5);

        Rover rover = new Rover(0, 0, Direction.N, grid);

        Command[] commands = {
            new MoveCommand(),
            new MoveCommand(),
            new TurnRightCommand(),
            new MoveCommand(),
            new TurnLeftCommand(),
            new MoveCommand()
        };

        for (Command command : commands) {
            rover.executeCommand(command);
        }

        System.out.println(rover.getStatus());
    }
}
