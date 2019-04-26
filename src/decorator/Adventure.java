/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

import java.util.Scanner;

/**
 *
 * @author Lucas Wolfs <lwolfs@my.wctc.edu>
 */
public class Adventure {
    
    public void onward()
    {
        Scanner input = new Scanner(System.in);
        Character pc;
        boolean alive = true;
        do
        {
            System.out.println("Enter character name:");
            pc = new BasicCharacter(input.nextLine());
            
            System.out.println("Choose your Weapon:");
            System.out.println("1. Sword");
            System.out.println("2. Spear");
            
            if(input.nextInt() == 1)
            {
                pc = new Sword(pc);
                
                
            }
            else
            {
                pc = new Spear(pc);
            }
            
            System.out.println("You are " + pc.getName() + "with a might of " + pc.getMight());
            
            System.out.println("What direction do you go?");
            System.out.println("1. Forward");
            System.out.println("2. Backward");
            if(input.nextInt() == 2)
            {
                System.out.println("You find a shield. Equip it? y/n");
                if(input.next().equalsIgnoreCase("y"))
                {
                    pc = new Shield(pc);
                    System.out.println("You are " + pc.getName() + "with a might of " + pc.getMight());
                }
                    
            }
            
            System.out.println("You have been traveling for many days, what do you do?");
            System.out.println("1. Forage for food");
            System.out.println("2. Look for a town");
            System.out.println("3. Hunt for game");
            System.out.println("4. Rob a carriage");
            
            switch(input.nextInt())
            {
                case 1: 
                    System.out.println("You find some berries and can continue on");
                    break;
                case 2:
                    System.out.println("You search for a long time and fail to find anything, you are very hungry");
                    pc = new Starving(pc);
                    System.out.println("You are " + pc.getName() + "with a might of " + pc.getMight());
                    break;
                case 3:
                    System.out.println("You are attacked by a wolf!");
                    if(pc.getMight() < 15)
                    {
                        System.out.println(pc.getName() + " has died. game over");
                        alive = false;
                    }
                    break;
                default:
                    System.out.println("You got arrested, good job, you get to starve to death in prison. Game over");
                    alive = false;
                    break;
                    
            }
            
            

            
            
        }while(alive);
    }
}
