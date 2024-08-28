/*
package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestPlacePayLoad {

   public AddPlace addPlacePayLoad(String name, String language, String address)
   {
       AddPlace p= new AddPlace();
       p.setAccuracy(50);
       p.setAddress(address);
       p.setLanguage(language);
       p.setPhone_number("(+91) 9876543218");
       p.setWebsite("https://rahulshettyacademy.com");
       p.setName(name);
       List<String> myList =  new ArrayList<String>();
       myList.add("park");
       myList.add("shop");

       p.setTypes(myList);

       Location l= new Location();   //we have set small JSON and we Pass it to large on
       l.setLat(-38.383494);
       l.setLng(33.427362);
       p.setLocation(l);

       return p;
   }

   public String deletePlacePayload(String place_id)
   {
       return "{\r\n   \"place_id\":\"c759aeb60f85c72175a2828b44057901\"\r\n}";
   }

}
*/
package resources;

import pojo.Location;
import pojo.AddPlace;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
    public AddPlace addPlacePayload(String name,String language,String address){
        AddPlace p =new AddPlace();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhone_number("(+91) 983 893 3937");
        p.setWebsite("https://rahulshettyacademy.com");
        p.setName(name);
        List<String> myList =new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        p.setTypes(myList);
        Location l =new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }

    public String deletePlacePayload(String placeId){
        return("{\r\n  \"place_id\":\""+placeId+"\"\r\n}");
    }
}
