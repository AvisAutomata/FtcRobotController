package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Catapult {
    private DcMotor motor;
    private Gamepad gamepad;

    private int targetPosition;

    public Catapult(DcMotor motor, Gamepad gamepad) {
        this.motor = motor;
        this.gamepad = gamepad;
    }

    public void Shoot() {
        targetPosition =(int) (GetPosition()+537.6);
        motor.setTargetPosition(targetPosition);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(.5);


    }





    public int GetPosition() {
        return motor.getCurrentPosition();
    }

    public void Loop() {
        boolean xButton = gamepad.xWasPressed();
        if (xButton) {
            this.Shoot();
        }
    }


}
