package com.example.stryker.bunny_warcray;

import android.util.Log;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.bitmap.AssetBitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import java.io.IOException;

/**
 * Carga/Descarga los recurso del juego. Imágenes, Audios
 */
public class
        AdministradorRecursos
{
    // Instancia única de la clase
    private static final AdministradorRecursos INSTANCE = new AdministradorRecursos();

    public Engine engine;
    public ControlJuego actividadJuego;
    public Camera camara;
    public VertexBufferObjectManager vbom;

    // ** TEXTURAS **
    // Escena Splash (imagen estática)
    private ITexture texturaSplash;
    public ITextureRegion regionSplash;

    // Escena gameover (imagen estática)
    private ITexture texturaGameover;
    public ITextureRegion regionGameover;

    // Escena Juego
    private ITexture texturaFondoJuego;
    public ITextureRegion regionFondoJuego;
    private ITexture texturaEnemigo;
    public ITextureRegion regionEnemigo;
    private ITexture texturaPerro;
    public ITextureRegion regionPerro;
    private ITexture texturaPersonajeFrente;
    public ITextureRegion regionPersonajeFrente;
    private ITexture texturaPersonajeAtras;
    public ITextureRegion regionPersonajeAtras;
    private ITexture texturaPersonajeDerecha;
    public ITextureRegion regionPersonajeDerecha;
    private ITexture texturaPersonajeGolpeado;
    public ITextureRegion regionPersonajeGolpeado;
    private ITexture texturaPersonajeIzquierda;
    public ITextureRegion regionPersonajeIzquierda;
    private ITexture texturaFondoControl;
    public ITextureRegion regionFondoControl;
    private ITexture texturaBotonControl;
    public ITextureRegion regionBotonControl;
    public ITiledTextureRegion regionBtnAtacar;
    private BuildableBitmapTextureAtlas btaBtnAtacar;
    private BuildableBitmapTextureAtlas texturaPataqueAtras;
    public TiledTextureRegion regionPataqueAtras;
    private BuildableBitmapTextureAtlas texturaPataqueIzquierda;
    public TiledTextureRegion regionPataqueIzquierda;
    private BuildableBitmapTextureAtlas texturaPataqueDerecha;
    public TiledTextureRegion regionPataqueDerecha;
    private BuildableBitmapTextureAtlas texturaPataqueFrente;
    public TiledTextureRegion regionPataqueFrente;

    // Escena Acerca de (imagen estática)
    private ITexture texturaFondoAcerca;
    public ITextureRegion regionFondoAcerca;

    // Escena Creditos (imagen estática)
    private ITexture texturaFondoCreditos;
    public ITextureRegion regionFondoCreditos;

    // Escena Menú (imagen estática)
    private ITexture texturaMenu;
    public ITextureRegion regionMenu;

    // Botón jugar del menú
    public ITiledTextureRegion regionBtnJugar;
    private BuildableBitmapTextureAtlas btaBtnJugar;

    // Botón acerca de del menú
    public ITiledTextureRegion regionBtnAcerca;
    private BuildableBitmapTextureAtlas btaBtnAcerca;

    // Botón creditos del menú
    public ITiledTextureRegion regionBtnCreditos;
    private BuildableBitmapTextureAtlas btaBtnCreditos;

    // Escena niveles (imagen estática)
    private ITexture texturaFondoNivel;
    public ITextureRegion regionFondoNivel;

    // Botón niveles
    public ITiledTextureRegion regionBtnN0;
    private BuildableBitmapTextureAtlas btaBtnN0;
    public ITiledTextureRegion regionBtnN1;
    private BuildableBitmapTextureAtlas btaBtnN1;
    public ITiledTextureRegion regionBtnN2;
    private BuildableBitmapTextureAtlas btaBtnN2;
    public ITiledTextureRegion regionBtnN3;
    private BuildableBitmapTextureAtlas btaBtnN3;
    public ITiledTextureRegion regionBtnN4;
    private BuildableBitmapTextureAtlas btaBtnN4;
    public ITiledTextureRegion regionBtnN5;
    private BuildableBitmapTextureAtlas btaBtnN5;

    public ITextureRegion regionFondoExperiencia;
    public ITexture texturaFondoExperiencia;

    public static AdministradorRecursos getInstance() {
        return INSTANCE;
    }

    public static void inicializarAdministrador(Engine engine,
                                                ControlJuego control, Camera camara,
                                                VertexBufferObjectManager vbom) {

        getInstance().engine = engine;
        getInstance().actividadJuego=control;
        getInstance().camara = camara;
        getInstance().vbom = vbom;
    }

    //*** Recursos de la pantalla de Splash
    public void cargarRecursosSplash() {

    try {
        // Carga la imagen de fondo de la pantalla Splash
        texturaSplash = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                actividadJuego.getAssets(), "EscenaSplash/logoTec.png");
        regionSplash = TextureRegionFactory.extractFromTexture(texturaSplash);
        texturaSplash.load();
    } catch (IOException e) {

        Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
    }
}
    public void liberarRecursosSplash() {

        texturaSplash.unload();
        regionSplash = null;
    }

    //*** Recursos de la pantalla de juego
    public void cargarRecursosJuego() {

        try {
            // Carga la imagen de fondo de la pantalla juego
            texturaFondoJuego = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaJuego/FondoJuego.jpg");
            regionFondoJuego = TextureRegionFactory.extractFromTexture(texturaFondoJuego);
            texturaFondoJuego.load();
        } catch (IOException e) {

            Log.d("cargarRecursosJuego", "No se puede cargar el fondo");
        }
        try {

            // Carga la imagen del enemigo
            texturaEnemigo = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "Enemigos/Hamster/Hamster.png");
            regionEnemigo = TextureRegionFactory.extractFromTexture(texturaEnemigo);
            texturaEnemigo.load();
        } catch (IOException e) {

            Log.d("cargarRecursosJuego", "No se puede cargar el enemigo");
        }
        try {

            // Carga la imagen del enemigo
            texturaPerro = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "Enemigos/Hamster/HamsterCreep.png");
            regionPerro = TextureRegionFactory.extractFromTexture(texturaPerro);
            texturaPerro.load();
        } catch (IOException e) {

            Log.d("cargarRecursosJuego", "No se puede cargar el enemigo");
        }

        try {
            // Carga la imagen del personajeFrente
            texturaPersonajeFrente = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "Personaje/personajeFrente.png");
            regionPersonajeFrente = TextureRegionFactory.extractFromTexture(texturaPersonajeFrente);
            texturaPersonajeFrente.load();
        } catch (IOException e) {

            Log.d("cargarRecursosJuego", "No se puede cargar el personajeFrente");
        }

        try {
            // Carga la imagen del personajeGolpeado
            texturaPersonajeGolpeado = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "Personaje/ConejoGolpeado.png");
            regionPersonajeGolpeado = TextureRegionFactory.extractFromTexture
                    (texturaPersonajeGolpeado );
            texturaPersonajeGolpeado.load();
        } catch (IOException e) {

            Log.d("cargarRecursosJuego", "No se puede cargar el personajeGolpeado");
        }

        try {
            // Carga la imagen del personajeAtras
            texturaPersonajeAtras = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "Personaje/personajeAtras.png");
            regionPersonajeAtras = TextureRegionFactory.extractFromTexture(texturaPersonajeAtras);
            texturaPersonajeAtras.load();
        } catch (IOException e) {

            Log.d("cargarRecursosJuego", "No se puede cargar el personajeAtras");
        }

        try {
            // Carga la imagen del personajeDerecha
            texturaPersonajeDerecha = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "Personaje/personajeDerecha.png");
            regionPersonajeDerecha = TextureRegionFactory.extractFromTexture
                    (texturaPersonajeDerecha);
            texturaPersonajeDerecha.load();
        } catch (IOException e) {

            Log.d("cargarRecursosJuego", "No se puede cargar el personajeDerecha");
        }

        try {
            // Carga la imagen del personajeIzquierda
            texturaPersonajeIzquierda = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "Personaje/personajeIzquierda.png");
            regionPersonajeIzquierda = TextureRegionFactory.extractFromTexture
                    (texturaPersonajeIzquierda);
            texturaPersonajeIzquierda.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el personajeIzquierda");
        }
        // Carga la imagen para el joystick

        try {
            texturaFondoControl = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaJuego/BaseControl.png");
            texturaBotonControl = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaJuego/BotonControl.png");
            regionFondoControl = TextureRegionFactory.extractFromTexture(texturaFondoControl);
            texturaFondoControl.load();
            regionBotonControl = TextureRegionFactory.extractFromTexture(texturaBotonControl);
            texturaBotonControl.load();
        } catch (IOException e) {
            Log.d("cargarRecursosJuego", "No se puede cargar el joystick");
        }
        // Carga la imagen del botón de ataque
        btaBtnAtacar = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                296,296);
        regionBtnAtacar = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnAtacar,
                actividadJuego.getAssets(),
                "EscenaJuego/BotonPalo.png", 1, 1);

        try {
            btaBtnAtacar.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón atacar");
        }
        btaBtnAtacar.load();

        // Carga la imagen del ataque de frente
        texturaPataqueFrente = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                795,131);
        regionPataqueFrente = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPataqueFrente,actividadJuego, "Personaje/PataqueFrente.png",5,1);
        try {
            texturaPataqueFrente.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueFrente");
        }
        texturaPataqueFrente.load();

        // Carga la imagen del ataque de derecha
        texturaPataqueDerecha = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                795,131);
        regionPataqueDerecha = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPataqueDerecha,actividadJuego, "Personaje/PataqueDerecha.png",5,1);
        try {
            texturaPataqueDerecha.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueDerecha");
        }
        texturaPataqueDerecha.load();

        // Carga la imagen del ataque de atras
        texturaPataqueAtras = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                795,131);
        regionPataqueAtras = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPataqueAtras,actividadJuego, "Personaje/PataqueAtras.png",5,1);
        try {
            texturaPataqueAtras.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueAtras");
        }
        texturaPataqueAtras.load();

        // Carga la imagen del ataque de izquierda
        texturaPataqueIzquierda = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager()
                ,795,131);
        regionPataqueIzquierda = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                texturaPataqueIzquierda,actividadJuego, "Personaje/PataqueIzquierda.png",5,1);
        try {
            texturaPataqueIzquierda.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource
                    , BitmapTextureAtlas>(0,0,0));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("onCreateResources","No se puede cargar la imagen del ataqueIzquierda");
        }
        texturaPataqueIzquierda.load();


    }
    public void liberarRecursosJuego() {
        texturaFondoJuego.unload();
        regionFondoJuego = null;
        texturaEnemigo.unload();
        regionEnemigo = null;
        texturaPersonajeFrente.unload();
        regionPersonajeFrente = null;
        texturaBotonControl.unload();
        regionBotonControl = null;

    }

    // crear escena acerca de
    public void cargarRecursosAcercaDe() {
        try {
            // Carga la imagen de fondo de la pantalla de Acerca
            texturaFondoAcerca = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaAcercaDe/FondoAcercaDe.jpg");
            regionFondoAcerca = TextureRegionFactory.extractFromTexture(texturaFondoAcerca);
            texturaFondoAcerca.load();
        } catch (IOException e) {
            Log.d("cargarRecursosMenu", "No se puede cargar el fondoAcercaDe");
        }
    }
    public void liberarRecursosAcercaDe() {
        // Fondo
        texturaFondoAcerca.unload();
        regionFondoAcerca = null;
    }

    // crear escena créditos
    public void cargarRecursosCreditos() {
        try {
            // Carga la imagen de fondo de la pantalla de créditos
            texturaFondoCreditos = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaCreditos/FondoCreditos.jpg");
            regionFondoCreditos = TextureRegionFactory.extractFromTexture(texturaFondoCreditos);
            texturaFondoCreditos.load();
        } catch (IOException e) {
            Log.d("cargarRecursosMenu", "No se puede cargar el fondoCreditos");
        }
    }
    public void liberarRecursosCreditos() {
        // Fondo
        texturaFondoCreditos.unload();
        regionFondoCreditos = null;
    }

    //*** Recursos de la pantalla de Menú
    public void cargarRecursosMenu() {
        try {
            // Carga la imagen de fondo de la pantalla del Menú
            texturaMenu = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaMenu/FondoMenu.jpg");
            regionMenu = TextureRegionFactory.extractFromTexture(texturaMenu);
            texturaMenu.load();
        } catch (IOException e) {
            //System.out.print(e.toString());
            Log.d("cargarRecursosMenu","No se puede cargar el fondoMenu");

        }

        // Carga la imagen para el botón jugar
        btaBtnJugar = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                368,120);
        regionBtnJugar = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnJugar,
                actividadJuego.getAssets(),
                "EscenaMenu/BotonJugar.png", 1, 1);
        try {
            btaBtnJugar.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnJugar.load();
        // Fin de carga imagen botón jugar
        // Carga la imagen para el botón Acerca de
        btaBtnAcerca = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                368,120);
        regionBtnAcerca = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnAcerca,
                actividadJuego.getAssets(),
                "EscenaMenu/BotonAcercaDe.png", 1, 1);
        try {
            btaBtnAcerca.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón acerca de");
        }
        btaBtnAcerca.load();
        // Carga la imagen para el botón Creditos
        btaBtnCreditos = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                296,296);
        regionBtnCreditos = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                btaBtnCreditos, actividadJuego.getAssets(),
                "EscenaMenu/BotonCredito.jpg", 1, 1);
        try {
            btaBtnCreditos.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón creditos");
        }
        btaBtnCreditos.load();

    }
    public void liberarRecursosMenu() {
        // Fondo
        texturaMenu.unload();
        regionMenu = null;
        // botón jugar
        btaBtnJugar.unload();
        regionBtnJugar = null;
    }

    public void cargarRecursosNiveles() {
        try {
            // Carga la imagen de fondo de la pantalla del Menú
            texturaFondoNivel = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaNivel/fondoNiveles.jpg");
            regionFondoNivel = TextureRegionFactory.extractFromTexture(texturaFondoNivel);
            texturaFondoNivel.load();
        } catch (IOException e) {
            //System.out.print(e.toString());
            Log.d("cargarRecursosMenu","No se puede cargar el fondoNiveles");

        }

        // Carga la imagen para el botón jugar
        btaBtnN0 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                120,157);
        regionBtnN0 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN0,
                actividadJuego.getAssets(),
                "EscenaNivel/btaBtnN0.png", 1, 1);
        try {
            btaBtnN0.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón nivel 0 ");
        }
        btaBtnN0.load();

/*        // Fin de carga imagen botón jugar
        // Carga la imagen para el botón Acerca de
        btaBtnN1 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                400,150);
        regionBtnN1 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN1,
        actividadJuego.getAssets(),
                "btaBtnN1.png", 1, 1);
        try {
            btaBtnN1.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
            BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN1.load();
        // Carga la imagen para el botón Creditos
        btaBtnN2 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                400,400);
        regionBtnN2 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN2,
        actividadJuego.getAssets(),
                "BotonN2.png", 1, 1);
        try {
            btaBtnN2.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
            BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN2.load();
        btaBtnN3 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                400,400);
        regionBtnN3 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN3,
        actividadJuego.getAssets(),
                "BotonN3.png", 1, 1);
        try {
            btaBtnN3.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
            BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN3.load();
        btaBtnN4 = new BuildableBitmapTextureAtlas(actividadJuego.getTextureManager(),
                400,400);
        regionBtnN4 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(btaBtnN4,
        actividadJuego.getAssets(),
                "BotonN4.png", 1, 1);
        try {
            btaBtnN4.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
            BitmapTextureAtlas>(0,0,0));

        } catch(ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Log.d("cargarRecursosMenu","No se puede cargar la imagen del botón jugar");
        }
        btaBtnN4.load();
        */

    }
    public void liberarRecursosNiveles() {
        // Fondo
        texturaFondoNivel.unload();
        regionFondoNivel = null;
        // botón jugar
        btaBtnN0.unload();
        regionBtnN0 = null;
    /*    btaBtnN1.unload();
        regionBtnN1 = null;
        btaBtnN2.unload();
        regionBtnN2 = null;
        btaBtnN3.unload();
        regionBtnN3 = null;
        btaBtnN4.unload();
        regionBtnN4 = null;
        */
    }

    public void cargarRecursosGameover() {

    try {
        // Carga la imagen de fondo de la pantalla Splash
        texturaGameover = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                actividadJuego.getAssets(), "EscenaGameover/fondoGameover.jpg");
        regionGameover = TextureRegionFactory.extractFromTexture(texturaGameover);
        texturaGameover.load();
    } catch (IOException e) {

        Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
    }
}
    public void liberarRecursosGameover() {
        texturaGameover.unload();
        regionGameover = null;
    }

    public void cargarRecursosExperiencia() {

        try {
            // Carga la imagen de fondo de la pantalla Splash
            texturaFondoExperiencia = new AssetBitmapTexture(actividadJuego.getTextureManager(),
                    actividadJuego.getAssets(), "EscenaExperiencia/fondoExperiencia.jpg");
            regionFondoExperiencia = TextureRegionFactory.extractFromTexture(texturaFondoExperiencia);
            texturaFondoExperiencia.load();
        } catch (IOException e) {

            Log.d("cargarRecursosSplash", "No se puede cargar el fondo tec");
        }
    }
    public void liberarRecursosExperiencia() {
        texturaFondoExperiencia.unload();
        regionFondoExperiencia = null;
    }
}
