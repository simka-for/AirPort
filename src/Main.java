import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.Comparator;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        Date date = new Date();
        date.setHours(date.getHours() + 2);
        Date now = new Date();

        airport.getTerminals().stream().flatMap(f -> f.getFlights().stream()).
                filter(flight -> flight.getDate().after(now) && flight.getDate().before(date)).
                filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE)).
                sorted(Comparator.comparing(Flight::getDate)).
                forEach(flight -> System.out.println(flight.getAircraft().getModel() + "\t" + flight));


    }
}
