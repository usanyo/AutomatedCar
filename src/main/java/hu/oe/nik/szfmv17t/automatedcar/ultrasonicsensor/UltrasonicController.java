package hu.oe.nik.szfmv17t.automatedcar.ultrasonicsensor;

import java.util.ArrayList;
import java.util.List;

import hu.oe.nik.szfmv17t.automatedcar.SystemComponent;
import hu.oe.nik.szfmv17t.automatedcar.bus.Signal;
import hu.oe.nik.szfmv17t.automatedcar.hmi.HMI;
import hu.oe.nik.szfmv17t.environment.domain.World;
import hu.oe.nik.szfmv17t.environment.interfaces.ICollidableObject;
import hu.oe.nik.szfmv17t.environment.interfaces.IWorldVisualisation;

/**
 * Created by SebestyenMiklos on 2017. 03. 26..
 */
public class UltrasonicController extends SystemComponent {
	
	private List<UltrasonicSensor> ultrasonicSensors;
	private IUltrasonicSensorController hmi;
	private IWorldVisualisation world;
	private List<ICollidableObject> allSeenObjectsBuffer;
    
	public UltrasonicController(IUltrasonicSensorController hmi, World w) {
		world = w;
		this.hmi = hmi;
		initSensors();
	}
	private void initSensors(){
		ultrasonicSensors = new ArrayList<UltrasonicSensor>();
		
	}
    @Override
    public void loop() {

    }

    @Override
    public void receiveSignal(Signal s) {

    }
}
