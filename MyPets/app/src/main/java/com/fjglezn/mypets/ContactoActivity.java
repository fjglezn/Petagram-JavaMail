package com.fjglezn.mypets;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
*
* Autor: Francisco Gonzalez
*
* */
public class ContactoActivity extends AppCompatActivity {

    EditText mensaje, nombre, correo, contrasenia;
    Button  enviar;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        mensaje = (EditText)findViewById(R.id.mensajeContacto);
        enviar = (Button) findViewById(R.id.btnEnviar);
        nombre = (EditText) findViewById(R.id.etxtnombreContacto);
        correo = (EditText) findViewById(R.id.correoContacto);
        contrasenia = (EditText) findViewById(R.id.contrasenia);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = correo.getText().toString();
                final String password = contrasenia.getText().toString();
                String etxtnombreContacto = nombre.getText().toString();
                String mensajeContacto =mensaje.getText().toString();

                if (email.equalsIgnoreCase("")||etxtnombreContacto.equalsIgnoreCase("")||password.equalsIgnoreCase("")
                        ||mensajeContacto.equalsIgnoreCase("")){
                    Toast.makeText(ContactoActivity.this,"Por favor, complete todos los campos.",Toast.LENGTH_LONG).show();

                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);

                    Properties properties = new Properties();
                    properties.put("mail.smtp.host","smtp.googlemail.com" );//Host al que se mandara
                    properties.put("mail.smtp.socketFactory.port","465" );//agregamos el puerto socket
                    properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory" );//protocolo de seguridad SSL
                    properties.put("mail.smtp.auth","true" );//Indica la autenticación
                    properties.put("mail.smtp.port","465" );//Puerto de gmail

                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(email, password);
                        }
                    });

                }
                else
                {
                    try {

                        //Verificamos que la sesion no sea nula
                        if (session != null) {
                            Message message = new MimeMessage(session);
                            message.setFrom(new InternetAddress(email));
                            message.setSubject(etxtnombreContacto);//Asunto
                            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("coursera@gmail.com"));//Correo destinatario
                            message.setContent(mensajeContacto, "text/html; charset=utf-8");
                            Transport.send(message);
                            Toast.makeText(ContactoActivity.this, "Se envio correctamente. :) ", Toast.LENGTH_SHORT).show();

                        }

                    } catch (Exception e) {
                        Toast.makeText(ContactoActivity.this, "Error al enviar el correo", Toast.LENGTH_SHORT).show();

                        e.printStackTrace();
                    }
                }

            }
        });


    }
}
