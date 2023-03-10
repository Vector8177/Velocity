package frc.robot;

import java.util.ArrayList;

import com.pathplanner.lib.PathConstraints;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.apriltag.AprilTag;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
import frc.lib.config.SwerveModuleConstants;
import frc.lib.util.HSV;

public final class Constants {

  public static final class Swerve {
    public static final double stickDeadband = 0.1;

    public static final int pigeonID = 6;
    public static final boolean invertGyro = false; // Always ensure Gyro is CCW+ CW-

    /* Drivetrain Constants */
    public static final double trackWidth = Units.inchesToMeters(20.75);
    public static final double wheelBase = Units.inchesToMeters(20.75);
    public static final double wheelDiameter = Units.inchesToMeters(4.0);
    public static final double wheelCircumference = wheelDiameter * Math.PI;

    public static final double openLoopRamp = 0.25;
    public static final double closedLoopRamp = 0.0;

    public static final double driveGearRatio = (6.12 / 1.0); // 6.12:1
    public static final double angleGearRatio = ((150.0 / 7.0) / 1.0); // 150/7:1

    public static final SwerveDriveKinematics swerveKinematics = new SwerveDriveKinematics(
        new Translation2d(wheelBase / 2.0, trackWidth / 2.0),
        new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
        new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
        new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0));

    /* Swerve Compensation */
    public static final double voltageComp = 12.0;

    /* Swerve Current Limiting */
    public static final int angleContinuousCurrentLimit = 20;
    public static final int driveContinuousCurrentLimit = 30;

    public static final double pitchSetPoint = 0.0;

    public static final double drivePitchKP = 0.015;
    public static final double drivePitchKI = 0.0001;
    public static final double drivePitchKD = 0.000000000000001;
    public static final double drivePitchKFF = 0.000000000000001;

    /* Angle Motor PID Values */
    public static final double angleKP = 0.01;
    public static final double angleKI = 0.0;
    public static final double angleKD = 0.005;
    public static final double angleKFF = 0.0;

    /* Drive Motor PID Values */
    public static final double driveKP = 0.1;
    public static final double driveKI = 0.0;
    public static final double driveKD = 0.0;
    public static final double driveKFF = 0.0;

    /* Drive Motor Characterization Values */
    public static final double driveKS = 0.16059;
    public static final double driveKV = 2.4135;
    public static final double driveKA = 0.41807;

    /* Drive Motor Conversion Factors */
    public static final double driveConversionPositionFactor = (wheelDiameter * Math.PI) / driveGearRatio;
    public static final double driveConversionVelocityFactor = driveConversionPositionFactor / 60.0;
    public static final double angleConversionFactor = 360.0 / angleGearRatio;

    /* Swerve Profiling Values */
    public static final double maxSpeed = 4.5; // meters per second
    public static final double maxSpeedMinLimit = 2; // meters per second when speed is limited by driver minimally
    public static final double maxSpeedMaxLimit = .75; // meters per second when speed is limited by driver maximum

    public static final double maxAngularVelocity = 5;
    public static final double maxAngularVelocityMinLimit = 3.5;
    public static final double maxAngularVelocityMaxLimit = 1.25;

    /* Swerve Limiting Values */
    public static final double autoCenterLimit = .3;

    /* Neutral Modes */
    public static final IdleMode angleNeutralMode = IdleMode.kBrake;
    public static final IdleMode driveNeutralMode = IdleMode.kBrake;

    /* Motor Inverts */
    public static final boolean driveInvert = false;
    public static final boolean angleInvert = true;

    /* Angle Encoder Invert */
    public static final boolean canCoderInvert = false;

    /* Module Specific Constants */
    /* Front Left Module - Module 0 */
    public static final class Mod0 {
      public static final int driveMotorID = 20;
      public static final int angleMotorID = 10;
      public static final int canCoderID = 30;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(-121.8164);
      public static final SwerveModuleConstants constants = new SwerveModuleConstants(driveMotorID, angleMotorID,
          canCoderID, angleOffset);
    }

    /* Front Right Module - Module 1 */
    public static final class Mod1 {
      public static final int driveMotorID = 21;
      public static final int angleMotorID = 11;
      public static final int canCoderID = 31;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(111.09);
      public static final SwerveModuleConstants constants = new SwerveModuleConstants(driveMotorID, angleMotorID,
          canCoderID, angleOffset);
    }

    /* Back Left Module - Module 2 */
    public static final class Mod2 {
      public static final int driveMotorID = 22;
      public static final int angleMotorID = 12;
      public static final int canCoderID = 32;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(52.734);
      public static final SwerveModuleConstants constants = new SwerveModuleConstants(driveMotorID, angleMotorID,
          canCoderID, angleOffset);
    }

    /* Back Right Module - Module 3 */
    public static final class Mod3 {
      public static final int driveMotorID = 23;
      public static final int angleMotorID = 13;
      public static final int canCoderID = 33;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(60.82);
      public static final SwerveModuleConstants constants = new SwerveModuleConstants(driveMotorID, angleMotorID,
          canCoderID, angleOffset);
    }
  }

  public static final class Elevator {
    public static final int motorLeftId = 50;
    public static final int motorRightId = 51;

    public static final double elevatorKP = 1.5;
    public static final double elevatorKI = .2;
    public static final double elevatorKD = .05;

    public static final double maxMotorVoltage = 5;

  }

  public static final class Wrist {
    public static final int wristMotorId = 61;
    public static final double maxMotorVoltage = 2.5;

    public static double kP = 2.2;
    public static double kI = 0.0;
    public static double kD = 0.2;

    public static double kS = 0.11237;
    public static double kV = 0.56387;
    public static double kA = 0.041488;
    public static double kG = 0.56416;

    public static final double motorGearRatio = 1 / 32.0;
    public static final double absoluteEncoderOffset = 5.412927;
  }

  public static final class Intake {
    public static final int motorId = 60;

    public static final int pdpChannel = 2; // update number later

    public static final double coneIntakeSpeed = 8;
    public static final double cubeIntakeSpeed = 4;


    public static final double coneOuttakeSpeed = 7;
    public static final double coneShootSpeed = 12;
    public static final double cubeOuttakeSpeed = 7;

    public static final double maxCurrentIntake = 80;

    public enum EjectSpeed {
      FAST,
      NORMAL
    }
  }

  public enum Position {

    HIGH(0, 0),
    CONEHIGH(.104327, 35),
    CUBEHIGH(1.55, 35),
    MID(0, 0),
    CONEMID(.104327, 23),
    CUBEMID(1.427, 16.5),
    LOW(.5236, .25),
    STANDBY(1.1765, .25),
    CUBEINTAKE(0.05, 0.3),
    STANDINGCONEINTAKE(5.106, 14.380),
    TIPPEDCONEINTAKE(5.572, 1.333),
    HUMANPLAYERINTAKE(.8763, 1.5);

    private double wristPos;
    private double elevatorPos;

    private Position(double wrist, double elev) {
      this.wristPos = wrist;
      this.elevatorPos = elev;
    }

    public double getWrist() {
      return wristPos;
    }

    public double getElev() {
      return elevatorPos;
    }
  }

  public enum GamePiece {
    CUBE(1),
    CONE(-1);

    private double direction;

    private GamePiece(double value) {
      direction = value;
    }

    public double getDirection() {
      return direction;
    }
  }

  public enum SEGMENT { // Numbers in order of segment from left to right (driver station POV)
    CONE_1(0), CONE_2(31.8), CONE_3(35.2), CONE_4(-1), CONE_5(-1), CONE_6(-1),
    CUBE_1(0), CUBE_2(20.6), CUBE_3(35.2);

    // intake Ground Cube: 0
    // intake Cone Upright: 12
    // intake Cone Tipped: 0

    // intake Cone Single HP: 8.9
    // intake Cube Single HP: 11.8

    private double level;

    private SEGMENT(double level) {
      this.level = level;
    }

    public static SEGMENT getSegment(int level, boolean cone) {
      if (cone) {
        switch (level) {
          case 1:
            return CONE_1;
          case 2:
            return CONE_2;
          case 3:
            return CONE_3;
        }
      } else {
        switch (level) {
          case 1:
            return CUBE_1;
          case 2:
            return CUBE_2;
          case 3:
            return CUBE_3;
        }
      }
      return null;
    }

    public double getValue() {
      return level;
    }

  }

  public static final class Autonomous {
    public static final PathConstraints constraints = new PathConstraints(1, 1);

    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
    public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

    public static final double kPXController = 1;
    public static final double kPYController = 1;
    public static final double kPThetaController = 1;
  }

  public static final class PhotonVision {
    public static final String photonVisionName = "OV5647";
    public static final Transform3d robotToCam = new Transform3d(
        new Translation3d(Units.inchesToMeters(9.1505), Units.inchesToMeters(9.666), Units.inchesToMeters(31.185)),
        new Rotation3d(
            0, Units.degreesToRadians(15),
            Units.degreesToRadians(5)));
  }

  public static final class AprilTags {
    public static final AprilTag tag1 = new AprilTag(1, FieldConstants.aprilTags.get(1));
    public static final AprilTag tag2 = new AprilTag(2, FieldConstants.aprilTags.get(2));
    public static final AprilTag tag3 = new AprilTag(3, FieldConstants.aprilTags.get(3));
    public static final AprilTag tag4 = new AprilTag(4, FieldConstants.aprilTags.get(4));
    public static final AprilTag tag5 = new AprilTag(5, FieldConstants.aprilTags.get(5));
    public static final AprilTag tag6 = new AprilTag(6, FieldConstants.aprilTags.get(6));
    public static final AprilTag tag7 = new AprilTag(7, FieldConstants.aprilTags.get(7));
    public static final AprilTag tag8 = new AprilTag(8, FieldConstants.aprilTags.get(8));
    public static final ArrayList<AprilTag> aprilTagList = new ArrayList<>();

    static {
      aprilTagList.add(tag1);
      aprilTagList.add(tag2);
      aprilTagList.add(tag3);
      aprilTagList.add(tag4);
      aprilTagList.add(tag5);
      aprilTagList.add(tag6);
      aprilTagList.add(tag7);
      aprilTagList.add(tag8);
    }
  }

  public static final class LEDs {
    public static final int id = 9;
    public static final int length = 18;

    public static final LEDMode defaultMode = LEDMode.VECTORWAVE;

    public static final class Flash {
      public static final double speed = 5;
    }

    public static final class VectorWave {
      public static final HSV hsv = HSV.googleColorPickerHSV(14, 99, 100);

      public static final int pauseBetween = 5;
      public static final int length = 20;
      public static final double spread = 4;
      public static final double speed = .25;
    }

    public static final class OrangeDot {
      public static final HSV hsv = HSV.googleColorPickerHSV(20, 99, 100);

      public static final int pauseBetween = 10;
      public static final int length = 0;
      public static final double spread = 2;
      public static final double speed = .5;
    }

    public enum LEDMode {
      ORANGEDOT("Orange Dot"),
      VECTORWAVE("Vector Wave"),
      RAINBOW("Rainbow"),
      PURPLEFLASH("Purple Flash"),
      YELLOWFLASH("Yellow Flash");

      private String name;

      private LEDMode(String name) {
        this.name = name;
      }

      @Override
      public String toString() {
        return name;
      }
    }
  }
}