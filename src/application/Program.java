package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyy): ");
		Date checkout = sdf.parse(sc.next());
		
		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter dade to update the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyy): ");
			checkout = sdf.parse(sc.next());
			
			
			Date date = new Date();
			if (date.before(checkin) || date.before(checkout)) {
				System.out.println("Error in reseration: Reservation dates for update must be future dates.");
			} else {
				reservation.updateDates(checkin, checkout);
				System.out.println("Updated reservation: " + reservation);				
			}
			
		}
		
		
		
		
		sc.close();

	}

}
