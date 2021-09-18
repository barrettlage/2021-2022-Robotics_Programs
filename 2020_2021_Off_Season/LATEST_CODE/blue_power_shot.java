package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="blue_power_shot")
public class blue_power_shot extends LinearOpMode {

    //-------------------------------- Drivetrain Motors --------------------------------\\
    // Motors are Gobilda 5202 and rotate at around 435 Revolutions/Rotations Per Minute (RPM).
    DcMotor FL;
    DcMotor FR;
    DcMotor BL;
    DcMotor BR;

    //-------------------------------- Intake Motors --------------------------------\\
    // The motor for the Intake is an AndyMark Neverest 40 Motor.
    DcMotor Intake;

    //-------------------------------- Flipper Servo --------------------------------\\
    // Loadingservo is a smart servo used for our flipper on the robot.
    Servo Loadingservo;

    //-------------------------------- Flywheel Motors --------------------------------\\
    // Both Flywheel 1 and Flywheel 2 use AndyMark Neverest 40 Motors.
    DcMotor Flywheel1;
    DcMotor Flywheel2;

    //-----------------------------Wobble goal servo and motor--------------------------------------\\

    //This is the motor for rotating the wobble goal arm. It will rotate downwards 90 degrees for grabbing.
    DcMotor Rotation;
    //This servo is for grabbing and letting go of the wobble goals.
    Servo Claw;

    @Override
    public void runOpMode() throws InterruptedException {


        //-------------------------------- Hardware Mapping --------------------------------\\


        // Hardware mapping the Drivetrain's 4 main drive motors, they should be Gobilda 5202 which spin at 435 RPM.
        FL = hardwareMap.dcMotor.get("flmotor");
        FR = hardwareMap.dcMotor.get("frmotor");
        BL = hardwareMap.dcMotor.get("blmotor");
        BR = hardwareMap.dcMotor.get("brmotor");
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Reversing 2 of the Drivetrain motors to allow the wheels to all move in the correct direction.
        FL.setDirection(DcMotor.Direction.REVERSE);
        BL.setDirection(DcMotor.Direction.REVERSE);


        // - Intake Motor, uses a single AndyMark Neverest 40 Motor.
        //Intake = hardwareMap.dcMotor.get("intake");


        // - Flipper Servo.
        //Loadingservo = hardwareMap.servo.get("flipper");


        // - Flywheel Motors, which are both AndyMark Neverest 40 Motors.
        /*Flywheel1 = hardwareMap.dcMotor.get("flyl");
        Flywheel2 = hardwareMap.dcMotor.get("flyr");*/

        // Reversing one of the Flywheel motors to allow them both to spin in the same direction.
        //Flywheel2.setDirection(DcMotor.Direction.REVERSE);

        // - Wobble Goal Mechanism Motors.
        //Rotation = hardwareMap.dcMotor.get("rotation");
        //Rotation.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //Rotation.setTargetPosition(0);
        //Rotation.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        //Claw = hardwareMap.servo.get("claw");

//        Rotation.setTargetPosition(0);


        //-------------------------------- Robot Start Telemetry & WaitForStart Code. --------------------------------\\

        telemetry.addData("Status", "Ready to run");
        telemetry.update();


        // Wait for the game to start (driver presses PLAY).
        waitForStart();

            //-------------------------------- Variables and Step-By-Step Code --------------------------------\\


            int right = 1;
            int left = 0;
            // check to see if any buttons are pressed.

            /*Step 1  -  Drive Forward 62 inches
            (12.566 is the circumference.) (4.93 rotations for 62 inches)
            (1891.148 ticks in 62 inches) (I rounded to 1891)
            */
            FL.setPower(1.00);
            FR.setPower(1.00);
            BR.setPower(1.00);
            BL.setPower(1.00);
            telemetry.addData("FL: Starting Ticks" , FL.getCurrentPosition());
            telemetry.addData("FR: Starting Ticks" , FR.getCurrentPosition());
            telemetry.addData("BL: Starting Ticks" , BL.getCurrentPosition());
            telemetry.addData("BR: Starting Ticks" , BR.getCurrentPosition());
            FL.setTargetPosition(25);
            FR.setTargetPosition(25);
            BR.setTargetPosition(25);
            BL.setTargetPosition(25);
            telemetry.addData("FL: Ending Ticks" , FL.getCurrentPosition());
            telemetry.addData("FR: Ending Ticks" , FR.getCurrentPosition());
            telemetry.addData("BL: Ending Ticks" , BL.getCurrentPosition());
            telemetry.addData("BR: Ending Ticks" , BR.getCurrentPosition());
            telemetry.update();
            while(BR.isBusy()) { ; }

            //while (FL.isBusy()) ;
            sleep(4000);
            /*Step 2  -  Strafe Right 30 inches (This is still experimental)
            (12.566 is the circumference.) (2.39 rotations for 30 inches)
            (915.804 ticks in 30 inches) (I rounded to 916)
            */
           /* FL.setPower(-1.00);
            FR.setPower(1.00);
            BL.setPower(1.00);
            BR.setPower(-1.00);
            FL.setTargetPosition(916);
            FR.setTargetPosition(916);
            BL.setTargetPosition(916);
            BR.setTargetPosition(916);
        */
        /*
            //Step 3  -  Start Flywheel
            Flywheel1.setPower(1.00);
            Flywheel2.setPower(1.00);
            //Step 4  -  Load Flywheel using Flipper
            Loadingservo.setPosition(0.00);
            sleep(500);
            Loadingservo.setPosition(1.00);
            /*Step 5  -  Strafe to the right and Shoot at Middle Goal - Strafe Right 8 inches (This is still experimental)
            (12.566 is the circumference.) (0.636 rotations for 8 inches)
            (244.216 ticks in 30 inches) (I rounded to 244)
            */

        /*  FL.setPower(-1.00);
            FR.setPower(1.00);
            BL.setPower(1.00);
            BR.setPower(-1.00);
            FL.setTargetPosition(244);
            FR.setTargetPosition(244);
            BL.setTargetPosition(244);
            BR.setTargetPosition(244);
            sleep(300);
            Loadingservo.setPosition(0.00);
            sleep(500);
            Loadingservo.setPosition(1.00);
            //Step 6  -  Strafe to the right and Shoot at Right Goal
            FL.setPower(-1.00);
            FR.setPower(1.00);
            BL.setPower(1.00);
            BR.setPower(-1.00);
            FL.setTargetPosition(244);
            FR.setTargetPosition(244);
            BL.setTargetPosition(244);
            BR.setTargetPosition(244);
            sleep(300);
            Loadingservo.setPosition(0.00);
            sleep(500);
            Loadingservo.setPosition(1.00);
            sleep(300);
            Flywheel1.setPower(0.00);
            Flywheel2.setPower(0.00);
            /*Step 7  -  Park on white line - I need to go 9 inches forward
            (12.566 inches is the circumference.) (9/12.566=0.716)
            (0.716x383.6=274.74 ticks) (I rounded to 275)
           */
        /*  FL.setPower(1.00);
            FR.setPower(1.00);
            BR.setPower(1.00);
            BL.setPower(1.00);
            FL.setTargetPosition(275);
            FR.setTargetPosition(275);
            BR.setTargetPosition(275);
            BL.setTargetPosition(275);
        */
            FL.setPower(0.00);
            FR.setPower(0.00);
            BL.setPower(0.00);
            BR.setPower(0.00);

        }
    }
