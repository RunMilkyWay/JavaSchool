import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

class GeoLocation {

    private static int numLocation = 0;
    Random random = new Random();
    private double lat = 0;
    private double lon = 0;


    GeoLocation(){
        lat = random.nextDouble() * 180 - 90;
        lat = (double) Math.round(lat * 1000000d) / 1000000d;
        lon = random.nextDouble() * 360 - 180;
        lon = (double) Math.round(lon * 1000000d) / 1000000d;
        numLocation++;
    }
    GeoLocation(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
        numLocation++;
    }
    GeoLocation(GeoLocation copy){
        this.lat = copy.lat + random.nextDouble() * 0.2 - 0.1;
        this.lat = (double) Math.round(lat * 1000000d) / 1000000d;
        this.lon = copy.lon + random.nextDouble() * 0.2 - 0.1;
        this.lon = (double) Math.round(lon * 1000000d) / 1000000d;
        numLocation++;
    }

    public void print(){
        System.out.println("["+lat+" ; "+lon+"]");
    }

    public static double distance(GeoLocation one, GeoLocation two){
        final int R = 6371;

        double lat1 = Math.toRadians(one.lat);
        double lon1 = Math.toRadians(one.lon);
        double lat2 = Math.toRadians(two.lat);
        double lon2 = Math.toRadians(two.lon);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double herro = R * c;

        return Math.round(herro * 10.0) / 10.0;  ///////////////////////////////@HERE


    }

    public static int getNumLocations(){
        return  numLocation;
    }


}




public class Main {
    public static void main(String[] args) {


        GeoLocation someLocation = new GeoLocation();
        GeoLocation vilnius = new GeoLocation(54.683333, 25.283333);
        GeoLocation kaunas = new GeoLocation(54.897222, 23.886111);
        GeoLocation nearVilnius = new GeoLocation(vilnius);

        someLocation.print();
        vilnius.print();
        nearVilnius.print();

        System.out.println("Number of locations: " + GeoLocation.getNumLocations());

        System.out.println("From Vilnius to Kaunas: " + GeoLocation.distance(vilnius, kaunas));
        System.out.println("From Vilnius to random location: " + GeoLocation.distance(vilnius, someLocation));
        System.out.println("From Vilnius to random neighbour: " + GeoLocation.distance(vilnius, nearVilnius));



        }
    }



/// JAIGU PANAUDOČIAU FLOOR TIES TAG @HERE GAUČIAU REIKIAMA 92.6 TARP VILNIAUS IR KAUNO, NORS TEISINGAS ATSAKYMAS YRA 92.7



