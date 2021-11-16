package org.firstinspires.ftc.teamcode;
//libraries
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="tankDrive") //connects robot brain to phone
public class tankDrive extends LinearOpMode { //main class
    public void runOpMode(){


        //DcMotor fl = hardwareMap.dcMotor.get("front_left_motor");
       // DcMotor fr = hardwareMap.dcMotor.get("front_right_motor");
        //DcMotor bl = hardwareMap.dcMotor.get("back_left_motor");
        //DcMotor br = hardwareMap.dcMotor.get("back_right_motor");
        //fl.setDirection(DcMotorSimple.Direction.REVERSE);
        //  bl.setDirection(DcMotorSimple.Direction.REVERSE);

        CRServo crServo = hardwareMap.crservo.get("crServo");


        double speed = 1;

        telemetry.addData("Status", "Initalized");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()){

          if(gamepad1.a) {
              if (speed == 1) { //if the current increment is 1, it'll switch to 0.5
                  speed = 0.2;
              } else { //if the current increment is not 1, it'll switch to 1
                  speed = 1;
              }
          }

          crServo.setPower(gamepad1.right_trigger);

         // fl.setPower(-gamepad1.left_stick_y);
          //fr.setPower(-gamepad1.right_stick_y);
          //bl.setPower(-gamepad1.left_stick_y);
          //br.setPower(-gamepad1.right_stick_y);

          telemetry.addData("Status", "Running");
          telemetry.addData("right joystick y value", gamepad1.right_stick_y);
          telemetry.addData("right joystick x value", gamepad1.right_stick_x);
          telemetry.addData("left joystick y value", gamepad1.left_stick_y);
          telemetry.addData("left joystick x value", gamepad1.left_stick_x);
          telemetry.update();
        }
    }


}
