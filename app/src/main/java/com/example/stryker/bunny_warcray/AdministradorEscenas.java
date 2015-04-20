package com.example.stryker.bunny_warcray;

import org.andengine.engine.Engine;

/**
 * Administra la escena que se verá en la pantalla
 */
public class AdministradorEscenas
{
    // Instancia única
    private static final AdministradorEscenas INSTANCE =
            new AdministradorEscenas();

    // Declara las distintas escenas que forman el juego
    private EscenaBase escenaSplash;
    private EscenaBase escenaMenu;
    private EscenaBase escenaAcercaDe;
    private EscenaBase escenaJuego;
    private EscenaBase escenaJuego1;
    private EscenaBase escenaJuego2;
    private EscenaBase escenaJuego3;
    private EscenaBase escenaJuego4;
    private EscenaBase escenaJuego0;
    private EscenaBase escenaCreditos;
    private EscenaBase escenaExperiencia;
    private EscenaBase escenaGameover;
    private EscenaBase escenaNiveles;
    private EscenaBase escenaOpciones;


    // El tipo de escena que se está mostrando
    private TipoEscena tipoEscenaActual = TipoEscena.ESCENA_SPLASH;
    // La escena que se está mostrando
    private EscenaBase escenaActual;
    // El engine para hacer el cambio de escenas
    private Engine engine = AdministradorRecursos.getInstance().engine;
    // El administrados de recursos
    private AdministradorRecursos admRecursos = AdministradorRecursos.getInstance();

    // Regresa la instancia del administrador de escenas
    public static AdministradorEscenas getInstance() {
        return INSTANCE;
    }

    // Regresa el tipo de la escena actual
    public TipoEscena getTipoEscenaActual() {
        return tipoEscenaActual;
    }

    // Regresa la escena actual
    public EscenaBase getEscenaActual() {
        return escenaActual;
    }

    /*
     * Pone en la pantalla la escena que llega como parámetro y guarda el nuevo estado
     */
    private void setEscenaBase(EscenaBase nueva) {
        engine.setScene(nueva);
        escenaActual = nueva;
        tipoEscenaActual = nueva.getTipoEscena();
    }

    /**
     * Cambia a la escena especificada en el parámetro
     * @param nuevoTipo la nueva escena que se quiere mostrar
     */
    public void setEscena(TipoEscena nuevoTipo) {
        switch (nuevoTipo) {
            case ESCENA_SPLASH:
                setEscenaBase(escenaSplash);
                break;
            case ESCENA_MENU:
                setEscenaBase(escenaMenu);
                break;
            case ESCENA_JUEGO:
                setEscenaBase(escenaJuego);
                break;
            case ESCENA_ACERCA_DE:
                setEscenaBase(escenaAcercaDe);
                break;
            case ESCENA_CREDITOS:
                setEscenaBase(escenaCreditos);
                break;
            case ESCENA_EXPERIENCIA:
                setEscenaBase(escenaExperiencia);
                break;
            case ESCENA_GAMEOVER:
                setEscenaBase(escenaGameover);
                break;
            case ESCENA_NIVELES:
                setEscenaBase(escenaNiveles);
                break;
            case ESCENA_JUEGO1:
                setEscenaBase(escenaJuego1);
                break;
            case ESCENA_JUEGO2:
                setEscenaBase(escenaJuego2);
                break;
            case ESCENA_JUEGO3:
                setEscenaBase(escenaJuego3);
                break;
            case ESCENA_JUEGO4:
                setEscenaBase(escenaJuego4);
                break;
            case ESCENA_JUEGO0:
                setEscenaBase(escenaJuego0);
                break;
            case ESCENA_OPCIONES:
                setEscenaBase(escenaOpciones);
                break;

        }
    }

    //*** Crea la escena de Splash
    public void crearEscenaSplash() {
        // Carga los recursos
        admRecursos.cargarRecursosSplash();
        escenaSplash = new EscenaSplash();
    }

    //*** Libera la escena de Splash
    public void liberarEscenaSplash() {
        admRecursos.liberarRecursosSplash();
        escenaSplash.liberarEscena();
        escenaSplash = null;
    }

    //*** Crea la escena de Menú
    public void crearEscenaMenu() {
        // Carga los recursos
        admRecursos.cargarRecursosMenu();
        escenaMenu = new EscenaMenu();
    }
    //*** Libera la escena de Menú
    public void liberarEscenaMenu() {
        admRecursos.liberarRecursosMenu();
        escenaMenu.liberarEscena();
        escenaMenu = null;
    }

    public void crearEscenaOpciones() {
        // Carga los recursos
        admRecursos.cargarRecursosOpciones();
        escenaOpciones= new EscenaOpciones();
    }
    public void liberarEscenaOpciones() {
        admRecursos.liberarRecursosOpciones();
        escenaOpciones.liberarEscena();
        escenaOpciones = null;
    }

    //*** Crea la escena de Acerca de
    public void crearEscenaAcerca() {
        // Carga los recursos
        admRecursos.cargarRecursosAcercaDe();
        escenaAcercaDe = new EscenaAcercaDe();
    }

    //*** Libera la escena de Acerca de
    public void liberarEscenaAcercaDe() {
        admRecursos.liberarRecursosAcercaDe();
        escenaAcercaDe.liberarEscena();
        escenaAcercaDe = null;
    }
    //*** Crea la escena de Creditos
    public void crearEscenaCreditos() {
        // Carga los recursos
        admRecursos.cargarRecursosCreditos();
        escenaCreditos = new EscenaCreditos();
    }

    //*** Libera la escena de Creditos
    public void liberarEscenaCreditos() {
        admRecursos.liberarRecursosCreditos();
        escenaCreditos.liberarEscena();
        escenaCreditos = null;
    }


    //*** Crea la escena de juego
  /*  public void crearEscenaJuego() {
        // Carga los recursos
        admRecursos.cargarRecursosJuego();
        escenaJuego = new EscenaJuego();
    }

    //*** Libera la escena de juego
    public void liberarEscenaJuego() {
        admRecursos.liberarRecursosJuego();
        escenaJuego.liberarEscena();
        escenaJuego = null;
    }
*/
    public void crearEscenaJuego1() {
        // Carga los recursos
        admRecursos.cargarRecursosJuego1();
        escenaJuego1 = new EscenaJuego1();
    }

    //*** Libera la escena de juego
    public void liberarEscenaJuego1() {
        admRecursos.liberarRecursosJuego1();
        escenaJuego1.liberarEscena();
        escenaJuego1 = null;
    }

    public void crearEscenaJuego2() {
        // Carga los recursos
        admRecursos.cargarRecursosJuego2();
        escenaJuego2 = new EscenaJuego2();
    }

    //*** Libera la escena de juego
    public void liberarEscenaJuego2() {
        admRecursos.liberarRecursosJuego2();
        escenaJuego2.liberarEscena();
        escenaJuego2 = null;
    }
/*
    public void crearEscenaJuego3() {
        // Carga los recursos
        admRecursos.cargarRecursosJuego();
        escenaJuego = new EscenaJuego();
    }

    //*** Libera la escena de juego
    public void liberarEscenaJuego3() {
        admRecursos.liberarRecursosJuego();
        escenaJuego.liberarEscena();
        escenaJuego = null;
    }

    public void crearEscenaJuego4() {
        // Carga los recursos
        admRecursos.cargarRecursosJuego();
        escenaJuego = new EscenaJuego();
    }

    //*** Libera la escena de juego
    public void liberarEscenaJuego4() {
        admRecursos.liberarRecursosJuego();
        escenaJuego.liberarEscena();
        escenaJuego = null;
    }

    public void crearEscenaJuego0() {
        // Carga los recursos
        admRecursos.cargarRecursosJuego();
        escenaJuego = new EscenaJuego();
    }

    //*** Libera la escena de juego
    public void liberarEscenaJuego0() {
        admRecursos.liberarRecursosJuego();
        escenaJuego.liberarEscena();
        escenaJuego = null;
    }
    */

    //*** Crea la escena de juego
    public void crearEscenaNiveles() {
        // Carga los recursos
        admRecursos.cargarRecursosNiveles();
        escenaNiveles = new EscenaNiveles();
    }

    //*** Libera la escena de juego
    public void liberarEscenaNiveles() {
        admRecursos.liberarRecursosNiveles();
        escenaNiveles.liberarEscena();
        escenaNiveles = null;
    }

    //*** Crea la escena de juego game over
    public void crearEscenaGameover() {
        // Carga los recursos
        admRecursos.cargarRecursosGameover();
        escenaGameover = new EscenaGameover();
    }

    //*** Libera la escena de juego game over
    public void liberarEscenaGameover() {
        admRecursos.liberarRecursosGameover();
        escenaGameover.liberarEscena();
        escenaGameover = null;
    }

    public void crearEscenaExperiencia() {
        // Carga los recursos
        admRecursos.cargarRecursosExperiencia();
        escenaExperiencia = new EscenaExperiencia();
    }

    //*** Libera la escena de juego game over
    public void liberarEscenaExperiencia() {
        admRecursos.liberarRecursosExperiencia();
        escenaExperiencia.liberarEscena();
        escenaExperiencia = null;
    }

}