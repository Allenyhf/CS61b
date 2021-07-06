public class OffByOne implements CharacterComparator{

    /**
     * Return true if x and y is one letter apart.
     * For example, 'a' and 'b', 'c' and 'b'
     */
    @Override
    public boolean equalChars(char x, char y) {
//        int valX = (int)x;
//        int valY = (int)y;
//        if(valX-valY==1 || valY-valX==1)
//            return true;
//        else
//            return false;
        if (x - y == 1 || y - x == 1) {
            return true;
        }else {
            return false;
        }
    }


}
