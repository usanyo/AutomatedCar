package hu.oe.nik.szfmv17t.automatedcar.hmi;

import javax.annotation.Resource.AuthenticationType;

/**
 * Created by gabi1_000 on 2017.03.04..
 */
public class GearStick {

    private AutoGearStates autoGearState;
    private int autoGearStateIndex;
    private int manualGearState;
    private final int maxGear = 6;
    private HmiTimer timer;
    private final AutoGearStates lastGearState = AutoGearStates.D;
    private final AutoGearStates firstGearState = AutoGearStates.P;

    public int GetManualGearState() {
        return manualGearState;
    }

    public AutoGearStates getAutoGearState() {
        return autoGearState;
    }

    public GearStick() {
        autoGearState = AutoGearStates.P;
        autoGearStateIndex = autoGearState.ordinal();
        manualGearState = 0;
        timer = new HmiTimer();
    }

    public void gearDown() {
        if (manualGearState > 0) {
            manualGearState--;
        } else {
            manualGearState = 0;
        }
    }

    public void gearUp() {
        if (manualGearState < maxGear) {
            manualGearState++;
        } else {
            manualGearState = maxGear;
        }
    }

    public void setGearState(AutoGearStates newGearState) {
        autoGearState = newGearState;
        autoGearStateIndex = autoGearState.ordinal();
    }

    public void gearUpAutomatic(){
    	if(autoGearState != lastGearState){
    		autoGearStateIndex++;
    		autoGearState = AutoGearStates.values()[autoGearStateIndex];
    	}
    }
    
    public void gearDownAutomatic(){
    	if(autoGearState != firstGearState){
    		autoGearStateIndex--;
    		autoGearState = AutoGearStates.values()[autoGearStateIndex];
    	}
    }


}
