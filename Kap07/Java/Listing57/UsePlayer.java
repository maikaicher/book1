public class UsePlayer {
	public static void main(String[] args) {
		Player[] allPlayer = new Player[4];
		allPlayer[0] = new Player();
		allPlayer[0].name = "Paul";
		allPlayer[0].x = 20;
		allPlayer[0].y = 10;
		System.out.println(allPlayer[0].name + " ist auf (" + allPlayer[0].x + "/" + allPlayer[0].y + ")");
	}
}
