package org.firstinspires.ftc.teamcode.OpenCV;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
//Last Edited 2/19/2021 10:10PM AE

@TeleOp(name="Drive Main", group="Pushbot")

public class Drive4 extends LinearOpMode {
    public double autoPosition = 0;
    /* Declare OpMode members. */
    BotHardware robot = new BotHardware();
    ElapsedTime runtime = new ElapsedTime();
    // private DistanceSensor sensor_range;
    @Override
    public void runOpMode() {
        double lt;
        double rt;
        int tower = 5;
        boolean changeTower = false;
//  sensor_range = hardwareMap.get(DistanceSensor.class, "sensor_range");
//  Rev2mDistanceSensor sensrTimeoffliht = (Rev2mDistanceSensor)sensor_range;
        robot.init(hardwareMap);

// Send telemetry message to signify robot waiting;
        telemetry.update();
        telemetry.addData("Say", "Drive program 4"); //
        telemetry.update();

//         telemetry.addData("Lift Motor", robot.lift.getCurrentPosition() );

//         telemetry.addData("Auto Postion:", autoPosition);
// telemetry.update();
// Wait for the game to start (driver presses PLAY)
        //robot.lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //swivelMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        waitForStart();
    //    robot.init(hardwareMap);
        double x= 1.0;
        runtime.reset();

        while (opModeIsActive()) {
            lt = gamepad2.left_trigger;
            rt = gamepad2.right_trigger;
            /*ENCODER TELEMETRY*/
            telemetry.update();
            telemetry.addData("Lift Motor", robot.lift.getCurrentPosition() );

            telemetry.addData("Auto Postion:", autoPosition);
            telemetry.addData("Lift", "%.3f", robot.lift.getPower());
            telemetry.addData("Current time: ", runtime.seconds());
            telemetry.addData("Tower Position: ", tower);
            telemetry.update();

            /*DISTANCE SENSOR TELEMETRY*/
//   telemetry.addData("FOOT", "Life, Libert and the pursiut of happiness");
//   telemetry.update();

//       telemetry.addData("Say", "Life, Libert and the pursiut of happiness");
//       //  telemetry.addData("sensor_range", sensor_range.getDeviceName);
//      if (sensor_range.getDistance(DistanceUnit.MM) < 4){
//      telemetry.addData("Status", String.format("It's In", sensor_range.getDistance(DistanceUnit.MM)));
//      }
//     if (sensor_range.getDistance(DistanceUnit.MM) > 4){
//      telemetry.addData("Status", String.format("It's In", sensor_range.getDistance(DistanceUnit.MM)));
//      }


            robot.fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            //robot.lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            /*DRIVE PROGRAMING*/
            if(gamepad1.dpad_up) {
                robot.fr.setPower(x);
                robot.fl.setPower(x);
                robot.br.setPower(x);
                robot.bl.setPower(x);
            }
            else if(gamepad1.dpad_down) {
                robot.fr.setPower(-x);
                robot.fl.setPower(-x);
                robot.br.setPower(-x);
                robot.bl.setPower(-x);
            }
            else if(gamepad1.dpad_left) {
                robot.fr.setPower(x);
                robot.fl.setPower(-x);
                robot.br.setPower(-x);
                robot.bl.setPower(x);

            }
            else if(gamepad1.dpad_right) {
                robot.fr.setPower(-x);
                robot.fl.setPower(x);
                robot.br.setPower(x);
                robot.bl.setPower(-x);
            }
            else if(gamepad1.right_bumper) {
                robot.fr.setPower(-x);
                robot.fl.setPower(x);
                robot.br.setPower(-x);
                robot.bl.setPower(x);
            }
            else if (gamepad1.left_bumper) {
                robot.fr.setPower(x);
                robot.fl.setPower(-x);
                robot.br.setPower(x);
                robot.bl.setPower(-x);
            }
            else {
                robot.fr.setPower(0);
                robot.fl.setPower(0);
                robot.br.setPower(0);
                robot.bl.setPower(0);
            }


            /*SPEED VARIABLES FOR DRIVE*/
            if(gamepad1.y) {
                x = 1;
            }
            else if(gamepad1.a) {
                x = 0.5;
            }
            else if (gamepad1.x){
                x = 0.75;
            }
            else if (gamepad1.b){
                x = 0.25;
            }


            /*ARM PROGRAMING*/
            // if (gamepad2.dpad_left){
            //      robot.magnetArm.setPower(-0.75);
            //  }
            // else if (gamepad2.dpad_right){
            //      robot.magnetArm.setPower(-0.15);
            //  }
            // else if (gamepad2.dpad_up){
            //      robot.magnetArm.setPower(1);
            //  }
            //else {robot.magnetArm.setPower(0);





            /*BREAKS*/
            //  if (gamepad2.left_bumper){
            //      robot.BreakSet(0);

            //  }

            //  if (gamepad2.right_bumper){
            //      robot.BreakSet(1.0);

            //  }


            //HAND PROGRAMING
//            if (gamepad2.x){
//                robot.handSet(0);
//            }
//            else{
//                robot.handSet(1.0);
//            }


            //WRIST PROGRAMING
            //old wrist
            if (gamepad2.a){
                robot.wrist.setPosition(1);
            }
            else if (gamepad2.y){
                robot.wrist.setPosition(0);
            }
            else if (gamepad2.b){
                robot.wrist.setPosition(0.5);
            }

            //New wrist
//             if (robot.lift.getCurrentPosition() < 36){
//                 robot.R1.setPower(1.0);
//                 robot.L1.setPower(-1.0);
//             }
             if (gamepad2.left_bumper){
                 robot.R1.setPower(1.0);
                 robot.L1.setPower(1.0);
             }
             else if (gamepad2.right_bumper){
                 robot.R1.setPower(-1.0);
                 robot.L1.setPower(-1.0);
             }
             else{
                 robot.R1.setPower(0);
                 robot.L1.setPower(0);
             }

            // else if (gamepad2.y){
            //     robot.wristSet.setPower(0);
            // }

            // LIFT PROGRAMMING


            if (gamepad2.dpad_down){
                robot.lift.getCurrentPosition();
                robot.lift.setTargetPosition(33);
                robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.lift.setPower(-1);

            }
            else if (robot.lift.getCurrentPosition() < 36 && robot.lift.getCurrentPosition() > 20){
                robot.lift.setPower(0);
            }
            if (gamepad2.dpad_left){
                robot.lift.getCurrentPosition();
                robot.lift.setTargetPosition(-1300);
                robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                robot.lift.setPower(-1);
            }

            if (gamepad2.dpad_right){
                robot.lift.getCurrentPosition();
                robot.lift.setTargetPosition(-2200);
                robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                robot.lift.setPower(-1);

            }
            if (gamepad2.dpad_up){
                robot.lift.getCurrentPosition();
                robot.lift.setTargetPosition(-2900);
                robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                robot.lift.setPower(-1);

            }
            if (gamepad2.left_trigger > 0) {
                robot.lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
            telemetry.update();
            if (gamepad2.right_trigger > 0){


                if (gamepad2.left_stick_y > 0) {
                    robot.lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                    robot.lift.setPower(.5);
                }
                else if (gamepad2.left_stick_y < 0) {
                    robot.lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                    robot.lift.setPower(-.4);
                }
                else{
                    robot.lift.setPower(0);
                }
            }

                       //////////////////////Tower Code//////////////////////
            if(gamepad2.x && (tower == 5)){
                changeTower = true;

                robot.lift.getCurrentPosition();
                robot.lift.setTargetPosition(-470);
                robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                  robot.lift.setPower(-0.5);
            }

            if(gamepad2.x && (tower == 4)){
                changeTower = true;

                robot.lift.getCurrentPosition();
                robot.lift.setTargetPosition(-342);
                robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                  robot.lift.setPower(-0.5);
            }

            if(gamepad2.x && (tower == 3)){
                changeTower = true;

                robot.lift.getCurrentPosition();
                robot.lift.setTargetPosition(-247);
                robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                  robot.lift.setPower(-0.5);
            }

            if(gamepad2.x && (tower == 2)){
                changeTower = true;


                robot.lift.getCurrentPosition();
                robot.lift.setTargetPosition(-90);
                robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                  robot.lift.setPower(-0.5);
            }

            if(gamepad2.x && (tower == 1)){
                changeTower = true;

                robot.lift.getCurrentPosition();
                robot.lift.setTargetPosition(33);
                robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                robot.lift.setPower(-0.5);
            }
            
            //reset tower sequence
            if(gamepad2.guide){
                changeTower = true;

                tower = 5;
            }

            if(gamepad2.touchpad && changeTower){
                changeTower = false;
                if(tower == 1){
                    tower = 5;
                }else{
                    tower = tower-1;
                }
            }
    
            //////////////////////RUMBLE CODE/////////////////////////////
            if((runtime.seconds() > 85) && (runtime.seconds() < 86) && !gamepad1.isRumbling()){
                gamepad1.rumbleBlips(5);
                gamepad2.rumbleBlips(5);
            }
            
            if((runtime.seconds() > 90) && (runtime.seconds() < 91) && !gamepad1.isRumbling()){
                gamepad1.rumble(1000);
                gamepad2.rumble(1000);
            }




        }
    }

}
