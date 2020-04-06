public class Vehicle {
    static final String producedBy = "Mihai";
    final int productionYear;
    final String vin;
    String plateNumber;
    int kilometers;
    int lastSoldOnYear;
    int positionX, positionY;

    public void setplateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getkilometers() {
        return this.kilometers;
    }

    public Vehicle(int productionYear, String vin) {
        this.productionYear = productionYear;
        this.vin = vin;
    }

    public Vehicle(int productionYear, String vin, String plateNumber) {
        this(productionYear, vin);
        this.plateNumber = plateNumber;
    }

    public Vehicle(int productionYear, String vin, String plateNumber, int kilometers) {
        this(productionYear, vin, plateNumber);
        this.kilometers = kilometers;
    }

    public void sellVehicle(String plateNumber, int lastSoldOnYear) {
        this.plateNumber = plateNumber;
        this.lastSoldOnYear = lastSoldOnYear;
    }

    public void mutareMasina(int positionX, int positionY) {
        double distance;
        distance = Math.sqrt(Math.pow(positionX - this.positionX, 2) + Math.pow(positionY - this.positionY, 2));
        this.kilometers += distance;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public boolean isVinValid(boolean isDrivingInNorthAmerica) {
        if (isDrivingInNorthAmerica = false) return true;
        int[] arr = new int[17], weight = {8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2};
        // weight={8,7,6,5,4,3,2,10,0,9,8,7,6,5,4,3,2};
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            switch (vin.charAt(i)) {
                case 'A':
                case 'J':
                    arr[k++] = 1;
                    break;
                case 'B':
                case 'K':
                case 'S':
                    arr[k++] = 2;
                    break;
                case 'C':
                case 'L':
                case 'T':
                    arr[k++] = 3;
                    break;
                case 'D':
                case 'M':
                case 'U':
                    arr[k++] = 4;
                    break;
                case 'E':
                case 'N':
                case 'V':
                    arr[k++] = 5;
                    break;
                case 'F':
                case 'W':
                    arr[k++] = 6;
                    break;
                case 'G':
                case 'P':
                case 'X':
                    arr[k++] = 7;
                    break;
                case 'H':
                case 'Y':
                    arr[k++] = 8;
                    break;
                case 'R':
                case 'Z':
                    arr[k++] = 9;
                    break;
                default:
                    arr[k++] = vin.charAt(i) - '0';

            }
        }
        int sum = 0;
        for (int i = 0; i < 16; i++) {
            sum += arr[i] * weight[i];
        }
        if ((vin.charAt(8) == 'X' && sum % 11 == 10) || vin.charAt(8) - '0' == sum % 11)
            return true;
        return false;


    }

    public void display() {
        System.out.println("Masina are " + this.kilometers + " km si are vin-ul " + this.vin + "...");
    }

    public void printVinDecomposed() {
        System.out.println("Identificatorul producatorului: ");
        for (int i = 0; i < 3; i++)
            System.out.print(vin.charAt(i));
        System.out.println();
        System.out.println("Atributele vehiculului");
        for (int i = 3; i < 10; i++)
            System.out.println(vin.charAt(i));
        System.out.println();
        System.out.println("Cifra de verificare: ");
        System.out.print(vin.charAt(10));
        System.out.println("Seria fabricii: " + vin.charAt(12));
    }
}
