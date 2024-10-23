package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.Core.RandomUtils;
import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    public static void addHexagon(int size , TETile[][] tiles){
        int height = 2 * size;
        for(int i = 0; i < height; i++){
            int startPos = generatePos(size, i)[0];
            int endPos = generatePos(size, i)[1];
            addRow(i, startPos, endPos, tiles, 3 *size -2);
        }
    }

    private static int generateItemNum(int size, int rowNum){
        if(rowNum >= size){
            rowNum = size- rowNum +1;
        }
        return 2 * rowNum + size;
    }

    private static int[] generatePos(int size, int rowNum){
        int[] posList = new int[2];
        int itemNum = generateItemNum(size, rowNum);
        if(rowNum < size){
            posList[0] = (3 * size -2 -itemNum)/2;
            posList[1] = posList[0] + itemNum-1;
        }else{
            int newRowNum= 2*size - rowNum -1;
            posList[0] = generatePos(size,newRowNum)[0];
            posList[1] = generatePos(size,newRowNum)[1];
        }
        return posList;
    }
    
    private static void addRow(int rowNum, int startPos, int endPos,  TETile[][] t ,int width){
        for(int i = 0; i < width; i++){
            if(i >= startPos && i <endPos +1){
                t[i][rowNum] = TETile.colorVariant(Tileset.FLOWER, 10, 32, 100, RANDOM);
            }else{
                t[i][rowNum] = Tileset.NOTHING;
            }
        }
    }


    public static void main(String[] args) {
        TERenderer tr = new TERenderer();
        tr.initialize(13,10 );

        TETile[][] tiles = new TETile[13][10];
        addHexagon(5, tiles);
        tr.renderFrame(tiles);
   }
}
