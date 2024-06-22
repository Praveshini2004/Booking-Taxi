  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.util.*;
public class Taxi {
    static int taxicount=0;
    int id;
    boolean booked;
    char currentspot; 
    int freetime;
    int totalearnings;
    List<String> trips;
    public Taxi(){
        booked=false;
        currentspot='A';
        freetime=6;
        totalearnings=0;
        trips=new ArrayList<>();
        taxicount=taxicount+1;
        id=taxicount;
    }
    public void setdetails(boolean booked,char currentspot,int freetime,int totalearnings,String tripdetail){
        this.booked=booked;
        this.currentspot=currentspot;
        this.totalearnings=totalearnings;
        this.freetime=freetime;
        this.trips.add(tripdetail);
    }
    public void printdetails(){
        System.out.println("Taxi-"+this.id+" Total Earning-"+this.totalearnings);
        System.out.println("Taxi ID | Booking ID  | CustomerID |  From | To | Pickuptime | Droptime | Amount");
        for(String trip:trips){
            System.out.println(id+"-----------"+trip);
        }
        System.out.println("------------------------------------------------------------");
    }
    public void printtaxidetails(){
        System.out.println("Taxi-"+this.id+"  Total Earning-"+this.totalearnings+"  CurrentSpot-"+this.currentspot+"  freetime-"+this.freetime);
    }
}
