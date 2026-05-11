public class PendakianSemeru {
    public static void main(String[] args) {

        char[][] peta = {
            {'P','X','X','X','X','X','X','X','X','G','G','G'},
            {'G','X','G','G','G','X','X','P','X','G','X','G'},
            {'G','X','X','X','G','P','G','G','G','G','X','G'},
            {'G','P','G','G','G','X','G','G','X','X','X','G'},
            {'G','G','X','G','G','X','P','X','X','X','X','G'},
            {'P','G','X','P','G','X','G','G','G','G','G','P'}
        };

        int baris = 5;
        int kolom = 11;

        int tenaga = 12;
        String jalur = "LLLLLUUULrLDLLLLUUU";

        for (int i = 0; i < jalur.length(); i++) {
            char jalan = jalur.charAt(i);

            if (jalan == 'L') {
                kolom = kolom - 1;
                tenaga = tenaga - 1;
            } else if (jalan == 'R') {
                kolom = kolom + 1;
                tenaga = tenaga - 1;
            } else if (jalan == 'U') {
                baris = baris - 1;
                tenaga = tenaga - 1;
            } else if (jalan == 'D') {
                baris = baris + 1;
                tenaga = tenaga - 1;
            } else if (jalan == 'r') {
                if (peta[baris][kolom] == 'P') {
                    tenaga = tenaga + 10;
                } else {
                    System.out.println("Mohon maaf, istirahat hanya diperbolehkan di Pos-pos yang tersedia");
                    return;
                }
            }

            if (baris < 0 || baris > 5 || kolom < 0 || kolom > 11) {
                System.out.println("Jalur anda salah, anda masuk ke jurang/blank 45");
                return;
            }

            if (peta[baris][kolom] == 'X') {
                System.out.println("Jalur anda salah, anda masuk ke jurang/blank 45");
                return;
            }
        }

        if (baris == 0 && kolom == 0) {
            if (tenaga >= 0) {
                System.out.println("Selamat Pendakian anda berhasil mencapai Puncak Mahameru, sisa tenaga anda " + tenaga);
            } else {
                System.out.println("Jalur anda benar, tapi tenaga anda tidak akan kuat, coba jalur lain atau sempatkan istirahat terlebih dahulu");
            }
        } else {
            System.out.println("Jalur belum sampai ke Puncak Mahameru, sisa tenaga anda " + tenaga);
        }
    }
}