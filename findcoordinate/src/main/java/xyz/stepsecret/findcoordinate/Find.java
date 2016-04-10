package xyz.stepsecret.findcoordinate;

import android.util.Log;

/**
 * Created by stepsecret on 10/4/2559.
 */
public class Find {


    public Boolean overdistance = false;
    public Double Newlong = 0.0;
    public Double NewLat = 0.0;

    public void NewCoordinate(double Lat_F, double Long_F, double Lat_S, double Long_S, double distance)
    {

        Double Distancetemp = calculateDistance(Lat_F,Long_F,Lat_S,Long_S);

        if(Distancetemp > distance)
        {
            overdistance = false;

            if(Lat_F<Lat_S)
            {

                NewLat = Lat_F+(double) ((distance*(Lat_S-Lat_F))/Distancetemp);

            }
            else
            {

                NewLat = Lat_F-(double) ((distance*(Lat_F-Lat_S))/Distancetemp);

            }

            if(Long_F<Long_S)
            {

                Newlong = Long_F+(double) ((distance*(Long_S-Long_F))/Distancetemp);

            }
            else
            {

                Newlong = Long_F-(double) ((distance*(Long_F-Long_S))/Distancetemp);

            }

        }
        else
        {
            overdistance = true;


        }


    }

    public Double finddistance(double Lat_F, double Long_F, double Lat_S, double Long_S)
    {

        return calculateDistance(Lat_F,Long_F,Lat_S,Long_S);
    }

    public Double getLatitude()
    {
        return NewLat;
    }

    public Double getLongitude()
    {
        return Newlong;
    }

    Double calculateDistance(double userLat, double userLng,double venueLat, double venueLng) {

        double latDistance = Math.toRadians(userLat - venueLat);
        double lngDistance = Math.toRadians(userLng - venueLng);

        double a = Math.sin(latDistance / 2.0) * Math.sin(latDistance / 2.0)
                + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(venueLat))
                * Math.sin(lngDistance / 2.0) * Math.sin(lngDistance / 2.0);

        double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0 - a));

        return 6371000.0 * c;
    }

}
