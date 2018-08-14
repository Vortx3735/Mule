package org.usfirst.frc.team3735.robot;

import org.usfirst.frc.team3735.robot.commands.drive.DriveMoveDistancePID;
import org.usfirst.frc.team3735.robot.commands.drive.autonomous.MoveDistance;

import org.usfirst.frc.team3735.robot.util.settings.BooleanSetting;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous {


	private Command mainCommand = new MoveDistance();

	public Autonomous() {

	}

	public void startCommand() {

			printAuto();
			mainCommand.start();
	}


	public void printAuto() {
		System.out.println("Auto Logic Selected: " + mainCommand.getName());
	}

	public void cancel() {
		if (mainCommand != null) {
			mainCommand.cancel();
		}

	}


}
