package org.usfirst.frc.team3735.robot.subsystems;

import org.usfirst.frc.team3735.robot.util.settings.Setting;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class LeftDrive extends Subsystem implements PIDSource, PIDOutput{

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	WPI_TalonSRX leftDrive1;
	WPI_TalonSRX leftDrive2;
	
	public PIDController controller;
	
	public LeftDrive() {
		leftDrive1 = new WPI_TalonSRX(2);
		leftDrive2 = new WPI_TalonSRX(3);
		
		leftDrive1.setNeutralMode(NeutralMode.Brake);
		
		controller = new PIDController(.017,.002,0.01,0,this,this, 5);
		controller.setAbsoluteTolerance(2);
		SmartDashboard.putData("Cube Angler PID", controller);
		
		leftDrive1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		leftDrive1.setSelectedSensorPosition(0, 0, 0);
		leftDrive1.setSensorPhase(true);
		leftDrive1.configNominalOutputForward(0, 0);
		leftDrive1.configNominalOutputReverse(0, 0);
		leftDrive1.configPeakOutputForward(1, 0);
		leftDrive1.configPeakOutputReverse(-1, 0);
		resetEncoderPositions();
		
		leftDrive1.configContinuousCurrentLimit(0, 0);
		leftDrive1.configPeakCurrentLimit(2, 0);
		leftDrive1.configPeakCurrentDuration(2000, 0);
		leftDrive1.enableCurrentLimit(true);
		
		leftDrive2.follow(leftDrive1);
	}
		
	public double getPosition() {
		return leftDrive1.getSelectedSensorPosition(0);
	}
	
	public void resetEncoderPositions() {
		leftDrive1.setSelectedSensorPosition(0, 0, 0);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        
    	
    	
    }

	public void setPOutput(double anglerMove) {
		leftDrive1.set(anglerMove);	
	}

	@Override
	public void pidWrite(double val) {
	}
	

	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		return getPosition();
	}
	

	public void log() {
//		SmartDashboard.putNumber("Cube Angler Angle", getPosition());
		SmartDashboard.putNumber("Cube Angler Angle", getPosition());
//		SmartDashboard.putNumber("Pivot Percent ", value)
		SmartDashboard.putNumber("Cube Angler Current", leftDrive1.getOutputCurrent());
	}

	@Override
	public void setPIDSourceType(PIDSourceType arg0) {
		
	}

}

