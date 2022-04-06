import java.util.ArrayList;

import core.data.*;

public class music {
    public static void main(String[] args) {
        DataSource ds = DataSource.connect("https://data.nasa.gov/api/views/gh4g-9sfh/rows.xml?accessType=DOWNLOAD");
        ds.setCacheTimeout(15 * 60);
        ds.load();
        ds.printUsageString();
        System.out.println(ds.hasFields("mass"));
        /*
        ArrayList<Integer> mass = ds.fetchIntList("mass");
        System.out.println("The mass of the meteorite is " + mass);
        */
    }
}
