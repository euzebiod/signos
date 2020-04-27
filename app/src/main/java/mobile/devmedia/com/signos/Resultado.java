package mobile.devmedia.com.signos;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

//        StrictMode.ThreadPolicy policy = new  StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);

        Bundle args = getIntent().getBundleExtra("signo");
        if (args != null) {

            Signo signoRecebido = (Signo) args.getSerializable("resultado");

            int imageResource = getResources().getIdentifier(signoRecebido.getImagem(), null, getPackageName());

            Drawable res = getDrawable(imageResource);
            ImageView imagem_signo = (ImageView)findViewById(R.id.imgSigno);
            imagem_signo.setImageDrawable(res);

            TextView resultado = (TextView) findViewById(R.id.textSigno);
            resultado.setText(signoRecebido.getNome());

            TextView datas = (TextView) findViewById(R.id.dataSigno);
            datas.setText("de " + signoRecebido.getDiaInicio() +"/"+ signoRecebido.getMesInicio() + " até "+signoRecebido.getDiaFim() +"/"+ signoRecebido.getMesFim());

            TextView hoje = (TextView) findViewById(R.id.textHoje);
            SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date();
            hoje.setText("Previsão para hoje: " + formataData.format(data));

            TextView prevision = (TextView) findViewById(R.id.textPrevisao);
            prevision.setText(signoRecebido.getPrevisao());
        }

        Button volta = (Button) findViewById(R.id.voltarPrincipal);
        volta.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                finish();
            }

        });
    }
}
