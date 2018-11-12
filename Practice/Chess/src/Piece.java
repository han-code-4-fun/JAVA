public class Piece
{
    Position position;

    Piece(){
        position.column = 0;
        position.row = 0;
    }

    boolean isValidMove(Position newPosition){
        if(newPosition.row>0 && newPosition.column>0
                && newPosition.row<8 && newPosition.column<8){
            return true;
        }
        else{
            return false;
        }
    }


}
