package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.elevator.Elevator;
import java.util.function.DoubleSupplier;

public class TeleopElevator extends CommandBase {
    private Elevator s_Elevator;
    private DoubleSupplier moveVal;

    public TeleopElevator(Elevator s_Elevator, DoubleSupplier moveVal) {
        this.s_Elevator = s_Elevator;
        this.moveVal = moveVal;

        addRequirements(s_Elevator);
    }

    @Override
    public void execute() {
        double deadbandController = Math.abs(moveVal.getAsDouble()) > .1 ? -moveVal.getAsDouble() : 0;
        s_Elevator.setPosition(s_Elevator.getTargetPosition() + deadbandController * .2);
    }
}
