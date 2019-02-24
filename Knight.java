public class Knight extends Piece{
    public Knight(boolean white){
        super(Type.Knight, white);
    }

    @Override
    public boolean is_valid(Piece[][] board, Cord from, Cord to){
        boolean valid = false;
        int dx = abs(from.get_x() - to.get_x());
        int dy = abs(from.get_y() - to.get_y());
        if(dx == 1 && dy == 2) valid = true;
        if(dx == 2 && dy == 1) valid = true;
        return valid && super.is_valid(board, from, to);
    }

    @Override
    public char to_char(){
        return is_white? 'N' : 'n';
    }
}
