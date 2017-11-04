import java.util.Arrays;

public class Lotto {

	public static void main(String[] args) {
		int anzahlSpieler = 0;
		int[] aktuelleLottoZahlen = drawLottery();
		int k = 0;
		boolean zustand = true;
		int spieler=0;

		System.out.println("Anzahl der gewünschten Spieler eingeben!");
		anzahlSpieler = In.readInt();
		int[][] aa = new int[anzahlSpieler][6];
		for (int as = 0; as < anzahlSpieler; as++) {
			System.out.println("Spieler " + (as + 1) + " bitte seinen Lottoschein ausfüllen!");
			aa[as] = readPlayerTip(anzahlSpieler);

		}

		while (zustand == true) {
			int spielerNummer=0;
			k++;
			
			aktuelleLottoZahlen=drawLottery();
			for (spielerNummer = 0; spielerNummer < anzahlSpieler; spielerNummer++) {

				if (checkPlayerTip(aa, aktuelleLottoZahlen, spielerNummer) == 6) {
					
					spieler=spielerNummer;
					zustand = false;
				}
			}

			
			
			
		}
		
		System.out.println("Spieler "+(spieler+1)+" hat gewonnen!");
		System.out.println(k);
		System.out.println(Arrays.toString(bubblesort(aktuelleLottoZahlen)));

		for (int row = 0; row < aa.length; row++) {
			for (int column = 0; column < aa[row].length; column++) {
				System.out.print(aa[row][column] + "\t");
			}

			System.out.println();
		}
	}

	// int[] test = { 1, 2, 3, 4, 5, 6 };
	// System.out.println(drawLotteryNumber());
	// System.out.println(Arrays.toString(drawLottery()));
	// System.out.println(Arrays.toString(readPlayerTip()));
	// System.out.println(checkPlayerTip(readPlayerTip(), test));

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

	public static int[] readPlayerTip(int anzahlSpieler) {

		int[] SpielerZahlen;
		SpielerZahlen = new int[6];
		int ZwischenSpeicher;
		boolean bereich = true;

		for (int s = 0; s < 6; s++) {
			System.out.println("Bitte die " + (s + 1) + ". Zahl eingeben!");
			ZwischenSpeicher = In.readInt();

			for (int i = 0; i < s; i++) {
				while (ZwischenSpeicher == SpielerZahlen[i]) {

					System.err.println("Zahl Doppelt! Bitte eine andere Zahl eingeben!");
					ZwischenSpeicher = In.readInt();

					i = 0;
				}
			}

			if (ZwischenSpeicher <= 49 && ZwischenSpeicher >= 1) {

				bereich = false;

			} else {

				bereich = true;

			}

			while (bereich == true) {

				System.err
						.println("Die eingegebene Zahl ist nicht gültig! Bitte die eine andere Zahl eingeben!");
				ZwischenSpeicher = In.readInt();

				if (ZwischenSpeicher <= 49 && ZwischenSpeicher >= 1) {
					bereich = false;
				}

			}

			SpielerZahlen[s] = ZwischenSpeicher;

		}

		return SpielerZahlen;
	}

	public static int checkPlayerTip(int[][] tip, int[] lotteryNumbers, int spielerNummer) {
		int richtigeZahlen = 0;

		
		for (int column = 0; column < tip[spielerNummer].length; column++) {
			for (int h = 0; h < lotteryNumbers.length; h++) {
				if (tip[spielerNummer][column] == lotteryNumbers[h]) {

					richtigeZahlen++;
				}
			}

		}

		return richtigeZahlen;
	}
	// System.out.println(Arrays.toString(tip));
	// System.out.println(Arrays.toString(lotteryNumbers));
	// for (int j = 0; j < tip.length; j++) {
	// for (int h = 0; h < lotteryNumbers.length; h++) {
	// if (tip[j] == lotteryNumbers[h]) {
	//
	// richtigeZahlen++;
	// }
	// }
	//
	// }
	// return richtigeZahlen;
	// }

	public static int[] bubblesort(int[] Lottozahlen) {
		int n = 6;
		int buffer;
		do {
			int newn = 1;
			for (int i = 0; i < n - 1; ++i) {
				if (Lottozahlen[i] > Lottozahlen[i + 1]) {
					// Werte der Arrays tauschen
					buffer = Lottozahlen[i];
					Lottozahlen[i] = Lottozahlen[i + 1];
					Lottozahlen[i + 1] = buffer;
					newn = i + 1;
				}
			}
			n = newn;
		} while (n > 1);
		return Lottozahlen;
	}
}
