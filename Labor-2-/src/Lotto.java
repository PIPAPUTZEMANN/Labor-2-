import java.util.Arrays;

public class Lotto {

	public static void main(String[] args) {
		int k=0;
		int [] array = null;
		System.out.println("Anzahl der gewünschten Spieler eingeben!");
		int AnzahlSpieler=In.readInt();
		for(int as=0;as<AnzahlSpieler;as++){
			
			System.out.println("Spieler "+(as+1)+" bitte seinen Lottoschein ausfüllen!");
			array=readPlayerTip();}
			
		while(checkPlayerTip(array,drawLottery() )!=6){
			
			
			drawLottery();
			k++;
		}
		System.out.println(k);
		}
		

		
		
		
		
		
		
		//int[] test = { 1, 2, 3, 4, 5, 6 };
		// System.out.println(drawLotteryNumber());
		//System.out.println(Arrays.toString(drawLottery()));
		// System.out.println(Arrays.toString(readPlayerTip()));
		//System.out.println(checkPlayerTip(readPlayerTip(), test));

	

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

			for (int i = 0; i < s; i++) {
				while (ZwischenSpeicher == SpielerZahlen[i]) {

					System.out.println("Zahl Doppelt! Bitte erneut die " + (i + 2) + ".eingeben!");
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

	public static int checkPlayerTip(int[] tip, int[] lotteryNumbers) {
		int richtigeZahlen = 0;

		//System.out.println(Arrays.toString(tip));
		//System.out.println(Arrays.toString(lotteryNumbers));
		for (int j = 0; j < tip.length; j++) {
			for (int h = 0; h < lotteryNumbers.length; h++) {
				if (tip[j] == lotteryNumbers[h]) {

					richtigeZahlen++;
				}
			}

		}
		return richtigeZahlen;
	}
}