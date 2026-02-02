package edu.narxoz.galactic;

import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.bodies.SpaceStation;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.HeavyDrone;
import edu.narxoz.galactic.drones.LightDrone;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.dispatcher.Result;
import edu.narxoz.galactic.task.DeliveryTask;

public class Main {
    public static void main(String[] args) {
        Planet earth = new Planet("Earth", 0, 0, "Nitrogen-Oxygen");
        SpaceStation alpha = new SpaceStation("Alpha", 100, 100, 1);

        Cargo lightCargo = new Cargo(5, "Light package");
        Cargo heavyCargo = new Cargo(50, "Heavy package");

        LightDrone lightDrone = new LightDrone("LD-01", 10);
        HeavyDrone heavyDrone = new HeavyDrone("HD-01", 100);

        DeliveryTask task1 = new DeliveryTask(earth, alpha, heavyCargo);

        Dispatcher dispatcher = new Dispatcher();

        Result r1 = dispatcher.assignTask(task1, lightDrone);
        System.out.println("Assign heavy to LightDrone: " + r1.ok() + " reason: " + r1.reason());

        Result r2 = dispatcher.assignTask(task1, heavyDrone);
        System.out.println("Assign heavy to HeavyDrone: " + r2.ok() + " reason: " + r2.reason());

        System.out.println("Estimated time: " + task1.estimateTime());

        Result r3 = dispatcher.completeTask(task1);
        System.out.println("Completion: " + r3.ok());
        System.out.println("Drone status: " + heavyDrone.getStatus());
        System.out.println("Task state: " + task1.getState());
    }
}