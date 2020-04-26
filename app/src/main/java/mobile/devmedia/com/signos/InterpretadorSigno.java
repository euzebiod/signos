package mobile.devmedia.com.signos;

import java.util.ArrayList;

public class InterpretadorSigno {

    private ArrayList<Signo> signos = new ArrayList<Signo>();

    public InterpretadorSigno(){
        Signo Aquario = new Signo(20,1,18,2,"Aquário","@drawable/aquario");
        signos.add(Aquario);

        Signo Peixes = new Signo(19,2,20,3,"Peixes","@drawable/peixes");
        signos.add(Peixes);

        Signo Aries = new Signo(21,3,19,4,"Aries","@drawable/aries");
        signos.add(Aries);

        Signo Touro = new Signo(20,4,20,5,"Touro","@drawable/touro");
        signos.add(Touro);

        Signo Gemeos = new Signo(21,5,20,6,"Gêmeos","@drawable/gemeos");
        signos.add(Gemeos);

        Signo Cancer = new Signo(21,6,22,7,"Câncer","@drawable/cancer");
        signos.add(Cancer);

        Signo Leao = new Signo(23,7,22,8,"Leão","@drawable/leao");
        signos.add(Leao);

        Signo Virgem = new Signo(23,8,22,9,"Virgem","@drawable/virgem");
        signos.add(Virgem);

        Signo Libra = new Signo(23,9,22,10,"Libra","@drawable/libra");
        signos.add(Libra);

        Signo Escorpiao = new Signo(23,10,21,11,"Escorpião","@drawable/escorpiao");
        signos.add(Escorpiao);

        Signo Sagitario = new Signo(22,11,21,12,"Sagitário","@drawable/sagitario");
        signos.add(Sagitario);

        Signo Capricornio = new Signo(22,12,19,1,"Capricórnio","@drawable/capricornio");
        signos.add(Capricornio);
    }
    public Signo interpretar(int dia, int mes) {
        Signo signo = null;

        for (Signo s : signos) {
            if (s.getMesInicio() == mes && dia >= s.getDiaInicio()) {
                signo = s;
                break;
            } else if (s.getMesFim() == mes && dia <= s.getDiaFim()) {
                signo = s;
                break;
            }
        }

        return signo;
    }
}
