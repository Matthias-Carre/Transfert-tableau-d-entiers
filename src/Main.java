
public class Main {

    public static void compression6bits(int[] tabin, int[] tabout){
        int indiceout=0;
        int pos=0;
        for (int i = 0; i < tabin.length; i++){
            if((pos+1)*6>32){
                indiceout++;
                pos=0;
            }
            tabout[indiceout]=tabout[indiceout]+tabin[i]* (int) Math.pow(2,32-(pos+1)*6);
            pos++;
        }
    }
    public static void decompression6bits(int[] tabin, int[] tabout){
        for (int j=0; j<2;j++) { //il faut voir la taille
            for (int i = 0; i < 32 / 6; i++) {
                //tabout[0] = tabin[0] / 2^32-6
                //tabout[1] = tabin[0] /

                //le 5 viens de 32/6
                tabout[i+(5*j)]=((tabin[j]/(int) Math.pow(2,32-6*(i+1))) % 32);

            }
        }
    }

    public static void printTabInt(int[] tab){
        System.out.print("Tab int: ");
        for (int i=0; i<tab.length; i++){
            System.out.print(tab[i]+" ");
        }
        System.out.println();
    }
    public static void printTabBin(int[] tab){
        System.out.print("Tab bin: ");
        for (int i=0; i<tab.length; i++){
            System.out.print(Integer.toBinaryString(tab[i])+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] intSur6bits = new int[10];

        //dans ce cas out est de taille (32/6)/10 soit le nombre qui rentre sur 32 par le nombre de val
        int[] outSur6bits = new int[10];
        int[] retour6bits = new int[10];
        for (int i = 0; i < intSur6bits.length; i++){
            intSur6bits[i]=i+1;
            outSur6bits[i]=0;
            retour6bits[i]=0;
        }
        //on veux passer les valeur de 1 a 10 donc les valeur de 1 a 5 doivent etre dans out[0] sous forme
        // 000001 000010 000011 000100 000101 (= 1*2^(32-6) + 2*2^(32-12) + 3*...)
        // ici on laisse les 2 derniers vide
        System.out.println(32/6);
        printTabInt(intSur6bits);

        compression6bits(intSur6bits, outSur6bits);

        printTabBin(outSur6bits);

        decompression6bits(outSur6bits, retour6bits);

        printTabInt(retour6bits);
    }
}