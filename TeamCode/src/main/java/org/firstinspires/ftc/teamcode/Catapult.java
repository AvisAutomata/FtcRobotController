package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Catapult {
    private DcMotor motor;
    private Gamepad gamepad;

    private int targetPosition;
    private boolean direction=true;

    public Catapult(DcMotor motor, Gamepad gamepad) {
        this.motor = motor;
        this.gamepad = gamepad;
    }

    public void Shoot() {
        targetPosition = GetPosition()+100;
        motor.setPower(0.5);
        direction=true;
    }
    public void Return(){
        direction=false;
        targetPosition= GetPosition()-100;
        motor.setPower(-0.5);

    }

    public int GetPosition() {
        return motor.getCurrentPosition();
    }

    public void Loop() {
        boolean xButton = gamepad.x;
        if (xButton) {
            this.Shoot();
        }

        if (direction){
            if (motor.getCurrentPosition() > targetPosition) {
                Return();

            }
        } else {
            if (motor.getCurrentPosition()< targetPosition){
                motor.setPower(0);

            }
        }


    }


}
