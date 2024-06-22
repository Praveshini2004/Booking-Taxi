/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.util.*;
public class Booking {
    
    public static List<Taxi> createTaxis(int n){
        List<Taxi> taxis=new ArrayList<>();
        for(int i=1;i<=n;i++){
            Taxi t=new Taxi();
            taxis.add(t);         
        }
        return taxis;
    }
    public static List<Taxi> getfreetaxis(List<Taxi> taxis,int pickuptime,char pickup){
        List<Taxi> freetaxi=new ArrayList<>(); 
        for(Taxi t:taxis){
            if(t.freetime<=pickuptime && (Math.abs((t.currentspot-'0')-(pickup-'0'))<=pickup-t.freetime));
                freetaxi.add(t);
        }
        return freetaxi;
    }
    public static void booktaxi(int customerid,char pickup,char drop,int pickuptime,List<Taxi> freetaxi){
        int min=999;
        int distance=0;
        int earning=0;
        int nextfreetime=0;
        char nextspot='Z';
        Taxi bookedtaxi=null;
        String tripdetail="";
        for(Taxi t:freetaxi){
            int distancecusandtaxi=Math.abs((t.currentspot-'0')-(pickup-'0'))*15;
            if(distancecusandtaxi<min){
                bookedtaxi=t;
                distance= Math.abs((drop - '0') - (pickup - '0')) * 15;
                 earning = (distance-5) * 10 + 100;
                 int droptime  = pickuptime + distance/15;
                nextfreetime=droptime;
                nextspot=drop;
                tripdetail=customerid+"             "+customerid+"            "+pickup+"     "+drop+"         "+pickuptime+"         "+droptime+"         "+earning;
                min=distancecusandtaxi;
            }
            
        }
         bookedtaxi.setdetails(true, nextspot, nextfreetime, bookedtaxi.totalearnings+earning, tripdetail);
        System.out.println("Taxi-"+bookedtaxi.id+" booked");
    }
    public static void main(String[] args){
        List<Taxi> taxis=createTaxis(4);
        Scanner sc=new Scanner(System.in);
        int id=1;
        while(true){
            System.out.println("0->Book Taxi");
            System.out.println("1->Bisplay Details");
            int choice=sc.nextInt();
            switch(choice){
                case 0:{
                    System.out.println("Enter Pickup Point");
                    char pickup=sc.next().charAt(0);
                    System.out.println("Enter Drop Point");
                    char drop=sc.next().charAt(0);
                    System.out.println("Enter Pickup Time");
                    int pickuptime=sc.nextInt();
                    if(pickup<'A' || drop>'F' || pickup>'F' || drop<'A'){
                        System.out.println("Enter Valid Pickup and Drop Points");
                        return;
                    }
                    List<Taxi> freetaxis=getfreetaxis(taxis,pickuptime,pickup);
                    if(freetaxis.size()==0){
                        System.out.println("No taxis available");
                        return;
                    }
                    Collections.sort(freetaxis,(a,b)->a.totalearnings-b.totalearnings);
                    booktaxi(id,pickup,drop,pickuptime,freetaxis);
                    id++;
                    break;
                }

                case 1:
                {
                    for(Taxi t:taxis){
                        t.printtaxidetails();
                    }
                    for(Taxi t:taxis){
                        t.printdetails();
                    }
                    break;
                }
                default:return;
            }
        }
    }
}
