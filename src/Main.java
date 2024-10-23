
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

    public static void main(String[] args) {
        int[] intSur6bits = new int[10];
        int[] outSur6bits = new int[10];
        for (int i = 0; i < intSur6bits.length; i++){
            intSur6bits[i]=i+1;
            outSur6bits[i]=0;
        }
        //on veux passer les valeur de 1 a 10 donc les valeur de 1 a 5 doivent etre dans out[0] sous forme
        // 000001 000010 000011 000100 000101 (= 1*2^(32-6) + 2*2^(32-12) + 3*...)
        // ici on laisse les 2 derniers vide
        compression6bits(intSur6bits, outSur6bits);
        System.out.println(Integer.toBinaryString(outSur6bits[0])+" "+Integer.toBinaryString(outSur6bits[1]));


    }
}