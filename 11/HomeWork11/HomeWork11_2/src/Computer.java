/**
 * Created by Вит on 15.02.2017.
 */
public class Computer {
    private double price;
    private boolean laptop;
    private long freeRAMSpace;//bytes
    private long hardDriveSize;//bytes
    private OperatingSystem operatingSystem;

    public static void main(String[] args) {
        Computer comp = new Computer(4000,true,4600000,460000000,OperatingSystem.WINDOWS_XP);
        comp.printStats();
    }

    public Computer(double price, boolean laptop, long freeRAMSpace, long hdd, OperatingSystem operatingSystem) {
        this.price = price;
        this.laptop = laptop;
        this.freeRAMSpace = freeRAMSpace;//not sure we need to init RAM when creating an object?!
        this.hardDriveSize = hdd;
        this.operatingSystem = operatingSystem;
    }

    public void installOS(OperatingSystem os) {
        this.operatingSystem = os;
    }

    public void setRamUsage(long usedRam) {
        if (usedRam < 0 || usedRam > freeRAMSpace) {
            throw new RuntimeException("Invalid RAM usage");
        }
        freeRAMSpace = freeRAMSpace - usedRam;
    }

    public void printStats() {
        if (laptop) {
            System.out.println("Laptop info:");
        } else {
            System.out.println("Computer info:");
        }
        System.out.println("OS: " + operatingSystem);
        System.out.println("price: " + price);
        System.out.println("free RAM space: " + freeRAMSpace);
        System.out.println("HDD Size: " + hardDriveSize);
    }

    enum OperatingSystem {
        WINDOWS_XP,
        WINDOWS_10,
        UBUNTU_1204,
        UBUNTU_1404
    }

}
