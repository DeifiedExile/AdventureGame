/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

/**
 *
 * @author Lucas Wolfs <lwolfs@my.wctc.edu>
 */
public class Starving extends CharacterDecorator {

    public Starving(Character character) {
        super(character);
    }

    @Override
    public String getName() {
        return character.getName() + ", Starving";
    }

    @Override
    public double getMight() {
        return character.getMight() + -5;
    }
    
}
