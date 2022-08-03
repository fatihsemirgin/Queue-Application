
public class Main {
	public static void randomnumber(Queue q) {	// To assign random numbers to player queues
		Queue random1 = new Queue(5000);
		boolean flag = true;
		for (int i = 0; i < 7; i++) {
			int a = (int) ((Math.random() * 17) + 1);
			if (i != 0) {
				for (int j = 0; j < random1.size(); j++) {
					if ((Integer) random1.peek() == a) {
						flag = false;
						i--;
						break;
					} else {
						flag = true;
					}
					random1.enqueue(random1.dequeue());
				}
				if (flag) {
					q.enqueue(a);
					random1.enqueue(a);
				}
			} else {
				q.enqueue(a);
				random1.enqueue(a);
			}
		}
	}
	public static void print_queue(Queue q) {	// To print queues
		for (int m = 0; m < q.size(); m++) {
			String lnt = (Integer.toString((int) q.peek()));
			if (lnt.length() == 1 && m != q.size() - 1)
				System.out.print(q.peek() + "    ");
			else if (m == q.size() - 1 && lnt.length() == 1)
				System.out.print(q.peek() + "    ");
			else
				System.out.print(q.peek() + "   ");
			q.enqueue(q.dequeue());
		}
	}

	public static int k = 20;	// the number of spaces added as the element in the player1 queue is deleted
	public static int k2 = 20;	// the number of spaces added as the element in the player2 queue is deleted

	public static void main(String[] args) {
		Queue player1 = new Queue(3000);
		Queue player2 = new Queue(3000);
		Queue bag1 = new Queue(5000);
		Queue bag2 = new Queue(5000);
		randomnumber(player1);
		randomnumber(player2);
		for (int i = 1; i < 18; i++) {
			bag1.enqueue(i);
		}
		int a = 0;	// Random number number
		int b = 1;	// Indicates the number of the selected number.
		int count_p1 = 0, count_p2 = 0;	// Counter for çinko states.
		int score_p1 = 0, score_p2 = 0;	// For player points
		boolean p1 = false, p2 = false;	// Boolean expressions necessary to prevent çinko repetition.
		System.out.println("     ********THE LOTTO GAME********\n");
		
		/// The cycle of the game
		while (!player1.isEmpty() && !player2.isEmpty()) {
			a = (int) (Math.random() * 17) + 1;
			if (!bag2.isEmpty()) {
				for (int i = 0; i < bag2.size(); i++) {
					if ((int) bag2.peek() != a) {
						bag2.enqueue(bag2.dequeue());
					} else {
						for (int p = i; p < bag2.size(); p++) {	// To appear in the order in which the queue was added
							bag2.enqueue(bag2.dequeue());
						}
						a = (int) (Math.random() * 17) + 1;
						i = -1;	// For the new random number to be looked at in the entire queue again
					}
				}
			}
			/// Print Screen
			System.out.print("Player1 : ");
			print_queue(player1);
			System.out.print(String.format("%" + k + "s", "Bag1 : "));
			print_queue(bag1);
			System.out.print("\nPlayer2 : ");
			print_queue(player2);
			System.out.print(String.format("%" + k2 + "s", "Bag2 : "));
			print_queue(bag2);
			/// Comparison of bag1 queue and players queue
			for (int i = 0; i < bag1.size(); i++) {
				if (a == (int) bag1.peek()) {
					for (int j = 0; j < player1.size(); j++) {
						if (bag1.peek() == player1.peek()) {
							count_p1++;
							k += 5;		// When removing 1 element from the queue, 5 spaces are removed. So add 5 to the variable k.
							player1.dequeue();
							j--;	// To prevent slipping when player1 is rotating.
						} else {
							player1.enqueue(player1.dequeue());
						}
					}
					for (int z = 0; z < player2.size(); z++) {
						if (bag1.peek() == player2.peek()) {
							count_p2++;
							k2 += 5;	// When removing 1 element from the queue, 5 spaces are removed. So add 5 to the variable k2.
							player2.dequeue();
							z--;	// To prevent slipping when player2 is rotating.
						} else {
							player2.enqueue(player2.dequeue());
						}
					}
					bag2.enqueue(bag1.dequeue());
					i--;
				} else {
					bag1.enqueue(bag1.dequeue());
				}
			}
			/// Çinko States
			if (count_p1 == 4 && p2 == false) {
				System.out.print("\n\nPlayer1 gets $10 (Birinci Çinko)");
				count_p1++;
				score_p1 += 10;
				p1 = true;
				if (count_p2 == 4) {
					System.out.print("\nPlayer2 gets $10 (Birinci Çinko)");
					score_p2 += 10;
					count_p2++;
				}
			} else if (count_p2 == 4 && p1 == false) {
				System.out.print("\n\nPlayer2 gets $10 (Birinci Çinko)");
				count_p2++;
				score_p2 += 10;
				p2 = true;
			}
			System.out.println("\n\n" + b + ".Randomly selected number : " + a);
			b++;
			System.out.println("-------------------------------------------");
			/// Game result and Score Table
			if (player1.isEmpty() && !player2.isEmpty()) {
				System.out.print("\nPlayer1 : ");
				score_p1 += 30;
				System.out.print(String.format("%" + k + "s", "Bag1 : "));
				print_queue(bag1);
				System.out.print("\nPlayer2 : ");
				print_queue(player2);
				System.out.print(String.format("%" + k2 + "s", "Bag2 : "));
				print_queue(bag2);
				System.out.println("\n\nPlayer1 is winner !!!\n\n*****Cash Table*****\nPlayer1 gets $" + score_p1
						+ "\nPlayer2 gets $" + score_p2);
			} else if (player2.isEmpty() && !player1.isEmpty()) {
				System.out.print("\nPlayer1 : ");
				print_queue(player1);
				System.out.print(String.format("%" + k + "s", "Bag1 : "));
				print_queue(bag1);
				score_p2 += 30;
				System.out.print("\nPlayer2 : ");
				System.out.print(String.format("%" + k2 + "s", "Bag2 : "));
				print_queue(bag2);
				System.out.println("\n\nPlayer2 is winner !!!\n\n*****Cash Table*****\nPlayer1 gets $" + score_p1
						+ "\nPlayer2 gets $" + score_p2);
			} else if (player1.isEmpty() && player2.isEmpty()) {
				score_p1 += 15;
				score_p2 += 15;
				System.out.print("\nPlayer1 : ");
				System.out.print(String.format("%" + k + "s", "Bag1 : "));
				print_queue(bag1);
				System.out.print("\nPlayer2 : ");
				System.out.print(String.format("%" + k2 + "s", "Bag2 : "));
				print_queue(bag2);
				if (score_p1 < score_p2)
					System.out.println("\n\nPlayer2 is winner !!!");
				else if (score_p1 > score_p2)
					System.out.println("\n\nPlayer1 is winner !!!");
				else
					System.out.println("\n\nThe cash of both players are equal ----> Tie");
				System.out.println("\n*****Cash Table*****\nPlayer1 gets $" + score_p1 + "\nPlayer2 gets $" + score_p2);
			}
		}
	}
}
