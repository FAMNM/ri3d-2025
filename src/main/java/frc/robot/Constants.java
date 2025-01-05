package frc.robot;

public final class Constants {

    public static final class driveConstants{
        public static final int leftDriveFront = 0;
        public static final int leftDriveBack = 0;
        public static final int rightDriveFront = 0;
        public static final int rightDriveBack = 0;

        public static final boolean leftInverted = true;
        public static final boolean rightInverted = false;

        public static final int driveCurrentLimit = 60;
    }

    public static final class liftConstants{
        public static final int bottomLimitSwitch = 0;
        public static final int liftMotor = 0;

        public static final double liftMotorP = 0.1;
        public static final double liftMotorI = 0.0;
        public static final double liftMotorD = 0.0;

        public static final int liftCurrentLimit = 60;
    }
}
