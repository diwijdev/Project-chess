/**
 * Main class to run the game.  Creates a new game, prints the game state, creates a new player
 * then alternates moves and prints the game state while there is no winner.
 *
 */
public class Main{
    public static void main(String[] args){
        int row = 8;//Change row and col to change the board size
        int col = 8;//As long as both values are >= 8

        Game game = new Game(row, col);
        GameHelper.printState(game);

        Player white, black;

        if(args.length == 2){
            switch (args[0]){
                case "Human": 
                    white = new Human(game);
                    break;
                case "Engine": 
                    white = new Engine(game);
                    break;
                case "AIMinMax":
                    white = new AIMinMax(game);
                    break;
                case "AIAlphaBeta":
                    white = new AIAlphaBeta(game);
                    break;
                default:
                    white = new AIRandom(game);
                    break;
            }
            switch (args[1]){
                case "Human": 
                    black = new Human(game);
                    break;
                case "Engine": 
                    black = new Engine(game);
                    break;
                case "AIMinMax":
                    black = new AIMinMax(game);
                    break;
                case "AIAlphaBeta":
                    black = new AIAlphaBeta(game);
                    break;
                default:
                    black = new AIRandom(game);
                    break;
            }
        }else{
            white = new Human(game);
            black = new Human(game);
        }

        while(game.getEnd() == Constant.ONGOING){
            white.move();
            GameHelper.printState(game);
            if(game.getEnd() == Constant.ONGOING){
                black.move();
                GameHelper.printState(game);
            }
        }

        GameHelper.printState(game);

        switch (game.getEnd()){
            case Constant.WHITE_WIN:
                System.out.println("White Wins.");
                break;
            case Constant.BLACK_WIN:
                System.out.println("Black Wins.");
                break;
            case Constant.DRAW_BY_FIFTY_MOVE_RULE:
                System.out.println("Draw by Fifty-move Rule.");
                break;
            case Constant.STALEMATE:
                System.out.println("Stalemate.");
                break;
            default:
                System.out.println("Error: Invalid End.");
                break;
        }
    }
}
