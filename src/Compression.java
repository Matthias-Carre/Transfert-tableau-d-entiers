public class Compression {
    public void compression6bits(int[] tabin, int[] tabout){
        int indiceout=0;
        int pos=0;
        for (int i = 0; i < tabin.length; i++){
            if(pos*6>32){
                indiceout++;
                pos=0;
            }
            tabout[indiceout]=tabin[i]*2^(32 - (pos +1)*6);

        }
    }
}
