/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Surri
 */
public class TestNonsense {
    public void generateBoxes(final int pDotCountX, final int pDotCountY)
    {
        //Generiere zuerst die Boxen
        Box[][] boxes = new Box[pDotCountY][pDotCountX];

        for(int y = 0; y < pDotCountY; y++)
        {
            for(int x = 0; x < pDotCountX; x++)
            {
                boxes[y][x] = new Box();
            } //-- for()
        } //-- for()
        
        //Befülle nun die Boxen mit den Linien
        for(int y = 0; y < pDotCountY; y++)
        {
            for(int x = 0; x < pDotCountX; x++)
            {
                //Horizontale Linien
                Line newHLine = new Line();
                
                if(y == 0) //Erste Reihe
                {
                    boxes[y][x].addTopLine(newHLine);
                }
                else
                {
                    boxes[y - 1][x].addBottomLine(newHLine);
                    boxes[y][x].addTopLine(newHLine);

                    if(y == pDotCountY - 1) //Letzte Reihe
                        boxes[y][x].addBottomLine(newHLine);
                }

                //Vertikale Linien
                Line newVLine = new Line();
                
                if(x == 0) //Erste Box
                {
                    boxes[y][x].addLeftLine(newVLine);
                }
                else
                {
                    boxes[y][x - 1].addRightLine(newVLine);
                    boxes[y][x].addLeftLine(newVLine);
                    
                    if(x == pDotCountX - 1) //Letzte Box
                        boxes[y][x].addRightLine(newVLine);
                }
            } //-- for()
        } //-- for()
    }        
}
