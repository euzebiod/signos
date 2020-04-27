package mobile.devmedia.com.signos;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.Serializable;

public class Signo implements Serializable{
    private int diaInicio;
    private int diaFim;
    private int mesInicio;
    private int mesFim;
    private String nome;
    private String imagem;
    private String mapNome;
    private String previsao;


    public Signo(){

    }

    public Signo(int diaInicio, int mesInicio, int diaFim, int mesFim, String nome, String imagem, String mapNome){
        this.diaInicio = diaInicio;
        this.diaFim = diaFim;
        this.mesInicio = mesInicio;
        this.mesFim = mesFim;
        this.nome = nome;
        this.imagem = imagem;
        this.mapNome = mapNome;
    }

    public int getDiaInicio() {
        return diaInicio;
    }

    public int getDiaFim() {
        return diaFim;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public int getMesFim() {
        return mesFim;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    public String getMapNome() {
        return mapNome;
    }

    public String getPrevisao() {
        return previsao;
    }

    public boolean setPrevisao(){
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.terra.com.br/vida-e-estilo/horoscopo/signos/" + this.getMapNome() ).get();
        } catch (IOException e) {
            this.previsao = "";
            return false;
        }

        if (doc == null){
            this.previsao = "";
            return false;
        }else {
            Element content = doc.getElementById("article_embed_text1");
            Elements paragraphs = content.getElementsByTag("p");
            for (Element paragraph : paragraphs) {
                String text = paragraph.text();
                this.previsao =  text;
                break;
            }
        }
        return true;
    }

}
