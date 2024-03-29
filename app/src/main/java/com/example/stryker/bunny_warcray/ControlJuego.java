package com.example.stryker.bunny_warcray;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

        //Esta es la clase principal que controla completamente el juego
        //Aquí se implementa el ciclo de vida
        //import org.andengine.engine.camera.Camera;
import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import java.io.IOException;

public class ControlJuego extends SimpleBaseGameActivity
{
    // Dimensiones de la cámara
    public static final int ANCHO_CAMARA = 1280;
    public static final int ALTO_CAMARA = 720;
    // La cámara
    private Camera camara;
    // El administrador de escenas
    private AdministradorEscenas admEscenas;

    public Music musicaMenu;
    public Music musicaJuego0;
    public Music musicaJuego;

    private boolean musicaGeneral;

    @Override
    public EngineOptions onCreateEngineOptions() {
        camara = new Camera(0,0,ANCHO_CAMARA,ALTO_CAMARA);
        EngineOptions opciones= new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,
                new FillResolutionPolicy(),camara);
        opciones.getAudioOptions().setNeedsMusic(true);
        return opciones;
    }

    @Override
    protected void onCreateResources() throws IOException {
        // Pasamos toda la información al administrador de recursos
        AdministradorRecursos.inicializarAdministrador(mEngine,this,
                camara,getVertexBufferObjectManager());
        admEscenas = AdministradorEscenas.getInstance();
        musicaMenu = MusicFactory.createMusicFromAsset(getMusicManager(),
                this, "MusicaMenu.wav");
        musicaJuego0 = MusicFactory.createMusicFromAsset(getMusicManager(),
                this, "MusicaJuego0.mp3");
        musicaJuego = MusicFactory.createMusicFromAsset(getMusicManager(),
                this, "MusicaJuego.mp3");

        SharedPreferences preferencias = getSharedPreferences("Sonido", Context.MODE_PRIVATE);
        musicaGeneral = preferencias.getBoolean("musicaGeneral",true);

        if (musicaGeneral) {
            musicaMenu.play();
        }
    }

    @Override
    protected Scene onCreateScene() {
        // Crea la primer escena que se quiere mostrar
        admEscenas.crearEscenaSplash();
        admEscenas.setEscena(TipoEscena.ESCENA_SPLASH);

        // Programa la carga de la segunda escena, después de cierto tiempo
        mEngine.registerUpdateHandler(new TimerHandler(2,
                new ITimerCallback() {
                    @Override
                    public void onTimePassed(TimerHandler pTimerHandler) {
                        mEngine.unregisterUpdateHandler(pTimerHandler); // Invalida el timer
                        // Cambia a la escena del MENU
                        //** 1. Crea la escena del menú
                        //** 2. Pone la escena del menú
                        //** 3. LIBERA la escena de Splash
                        admEscenas.crearEscenaMenu();
                        admEscenas.setEscena(TipoEscena.ESCENA_MENU);
                        admEscenas.liberarEscenaSplash();
                    }
                }));

        return admEscenas.getEscenaActual();
    }

    // Atiende la tecla de BACK
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK) {
            if(admEscenas.getTipoEscenaActual()==TipoEscena.ESCENA_MENU) {
                // Si está en el menú, termina
                finish();
            } else {
                // La escena que esté en pantalla maneja el evento
                admEscenas.getEscenaActual().onBackKeyPressed();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // La aplicación sale de memoria
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (admEscenas!=null) {
            System.exit(0);
        }
    }
    public synchronized void onPauseGame() {
        // Pausar la música en ACERCA DE

            if (musicaJuego.isPlaying()) {
                musicaJuego.pause();
        }
        if (musicaJuego0.isPlaying()) {
            musicaJuego0.pause();
        }
        if (musicaMenu.isPlaying()) {
            musicaMenu.pause();
        }



        super.onPauseGame();
    }
    public synchronized void onResumeGame() {
        SharedPreferences preferencias = getSharedPreferences("Sonido", Context.MODE_PRIVATE);
        musicaGeneral = preferencias.getBoolean("musicaGeneral",true);
        // Reanudar la música en ACERCA DE
        if (admEscenas!=null && admEscenas.getTipoEscenaActual()==TipoEscena.ESCENA_JUEGO0&&musicaGeneral) {
            // Esta en AcercaDe, revisar si está reproduciendo música

            if (!musicaJuego0.isPlaying()) {
                musicaJuego0.play();
            }
        }
        if (admEscenas!=null && admEscenas.getTipoEscenaActual()==TipoEscena.ESCENA_JUEGO1&&musicaGeneral) {

            if (!musicaJuego.isPlaying()) {
                musicaJuego.play();
            }
        }
        if (admEscenas!=null && admEscenas.getTipoEscenaActual()==TipoEscena.ESCENA_JUEGO2&&musicaGeneral) {

            if (!musicaJuego.isPlaying()) {
                musicaJuego.play();
            }
        }if (admEscenas!=null && admEscenas.getTipoEscenaActual()==TipoEscena.ESCENA_JUEGO3&&musicaGeneral) {

            if (!musicaJuego.isPlaying()) {
                musicaJuego.play();
            }
        }if (admEscenas!=null && admEscenas.getTipoEscenaActual()==TipoEscena.ESCENA_JUEGO4&&musicaGeneral) {

            if (!musicaJuego.isPlaying()) {
                musicaJuego.play();
            }
        }
        if (admEscenas!=null && admEscenas.getTipoEscenaActual()==TipoEscena.ESCENA_JUEGO5&&musicaGeneral) {

            if (!musicaJuego.isPlaying()) {
                musicaJuego.play();
            }
        }
        if (admEscenas!=null && admEscenas.getTipoEscenaActual()==TipoEscena.ESCENA_MENU&&musicaGeneral) {

            if (!musicaMenu.isPlaying()) {
                musicaMenu.play();
            }
        }
        if (admEscenas!=null && admEscenas.getTipoEscenaActual()==TipoEscena.ESCENA_CREDITOS&&musicaGeneral) {

            if (!musicaMenu.isPlaying()) {
                musicaMenu.play();
            }
        }
        if (admEscenas!=null && admEscenas.getTipoEscenaActual()==TipoEscena.ESCENA_ACERCA_DE&&musicaGeneral) {

            if (!musicaMenu.isPlaying()) {
                musicaMenu.play();
            }
        }
        if (admEscenas!=null && admEscenas.getTipoEscenaActual()==TipoEscena.ESCENA_NIVELES&&musicaGeneral) {

            if (!musicaMenu.isPlaying()) {
                musicaMenu.play();
            }
        }
        if (admEscenas!=null && admEscenas.getTipoEscenaActual()==TipoEscena.ESCENA_EXPERIENCIA&&musicaGeneral) {

            if (!musicaMenu.isPlaying()) {
                musicaMenu.play();
            }
        }
        if (admEscenas!=null && admEscenas.getTipoEscenaActual()==TipoEscena.ESCENA_OPCIONES&&musicaGeneral) {

            if (!musicaMenu.isPlaying()) {
                musicaMenu.play();
            }
        }



        super.onResumeGame();
    }

}
