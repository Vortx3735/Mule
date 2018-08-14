package org.usfirst.frc.team3735.robot.commands.drive.autonomous;

import org.usfirst.frc.team3735.robot.commands.drive.DriveMoveDistancePID;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveDistance extends CommandGroup {
	public MoveDistance() {
//    	addSequential(new MoveDDx(-Dms.Field.TOBASELINE - 36, .6, .05).addA(new NavxAssist()));
    	
    		addSequential(new DriveMoveDistancePID(12), 2);
    		
    }
    
    public void initialize() {
    	System.out.println("starting very simple");
    }
    
    public void end() {
    	System.out.println("ending very simple");
    }
}