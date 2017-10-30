import java.util.Arrays;

public class Lotto {

	public static void main(String[] args) {

		System.out.println(drawLotteryNumber());
		System.out.println(Arrays.toString(drawLottery()));
		System.out.println(Arrays.toString(readPlayerTip()));
		
	}

	public static int drawLotteryNumber() {

		int zufallLottoZahl;
		zufallLottoZahl = (int) (Math.random() * 49) + 1;

		return zufallLottoZahl;

	}

	public static int[] drawLottery() {

		int[] ZiehungZahlen;
		ZiehungZahlen = new int[6];

		for (int b = 0; b < ZiehungZahlen.length; b++) {

			ZiehungZahlen[b] = drawLotteryNumber();

			for (int i = 0; i < b; i++) {
				while (ZiehungZahlen[b] == ZiehungZahlen[i]) {

					ZiehungZahlen[b] = drawLotteryNumber();
					i = 0;

				}

			}
		}
		return ZiehungZahlen;//
	}

	public static int[] readPlayerTip() {

		int[] SpielerZahlen;
		SpielerZahlen = new int[6];
		int ZwischenSpeicher;
		boolean bereich = true;

		for (int s = 0; s < SpielerZahlen.length; s++) {
			System.out.println("Bitte die " + (s + 1) + ". Zahl eingeben!");
			ZwischenSpeicher = In.readInt();

			if (ZwischenSpeicher <= 49 && ZwischenSpeicher >= 1) {

				bereich = false;

			} else {

				bereich = true;

			}

			while (bereich == true) {

				System.out
						.println("Die eingegebene Zahl ist nicht gültig! Bitte die " + (s + 1) + ". nochmal eingeben!");
				ZwischenSpeicher = In.readInt();

				if (ZwischenSpeicher <= 49 && ZwischenSpeicher >= 1) {
					bereich = false;
				}

			}

			SpielerZahlen[s] = ZwischenSpeicher;

		}
		return SpielerZahlen;

	}
	public static int[] checkPlayerTip(int[] tip,int[] lotterNumbers){
		
		
	
		
		
		
	}
}