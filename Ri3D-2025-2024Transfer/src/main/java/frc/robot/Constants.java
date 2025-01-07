package frc.robot;

public final class Constants {

    public static final class OIConstants{
        public static final int driveController = 0;
        public static final int operatorController = 1;
    }

    public static final class driveConstants{
        public static final int leftDriveFront = 3;
        public static final int leftDriveBack = 4;
        public static final int rightDriveFront = 2;
        public static final int rightDriveBack = 1;

        public static final boolean leftInverted = false;
        public static final boolean rightInverted = true;

        public static final int driveCurrentLimit = 60;
    }

    public static final class liftConstants{
        public static final int bottomLimitSwitch = 0;
        public static final int liftMotor = 11;

        public static final double liftMotorP = 0.1;
        public static final double liftMotorI = 0.0;
        public static final double liftMotorD = 0.0;

        public static final int liftCurrentLimit = 60;

        public static final int liftTolerance = 50; //Ticks

        //Lift Setpoints
        public static final int low = 0;
        public static final int mid = 0;
        public static final int high = 0; //All three of these should be in ticks
    }

    public static final class intakeConstants{
        public static final int intakeMotor = 12;
        public static final double intakeSpeed = 0.3;
        public static final double outtakeSpeed = -0.25;
        public static final double staticSpeed = 0.1;

        public static final double triggerThreshold = 0.05;
    }

    public static final class indexConstants{
        public static final int indexMotor = 14;
        public static final double indexSpeed = 0.9;
    }
}
