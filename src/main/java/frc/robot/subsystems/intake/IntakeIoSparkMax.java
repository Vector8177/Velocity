package frc.robot.subsystems.intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class IntakeIOSparkMax implements IntakeIO {
    private final CANSparkMax intakeMotor;
    private final RelativeEncoder intakeEncoder;

    public IntakeIOSparkMax() {
        intakeMotor = new CANSparkMax(Constants.Intake.motorId, MotorType.kBrushless);
        intakeEncoder = intakeMotor.getEncoder();
    }

    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        inputs.velocity = intakeEncoder.getVelocity();
        inputs.current = intakeMotor.getOutputCurrent();
    }

    @Override
    public void setVoltage(double speed) {
        intakeMotor.setVoltage(speed);
    }

    @Override
    public void setPosition(double position) {
        intakeEncoder.setPosition(position);
    }
}
