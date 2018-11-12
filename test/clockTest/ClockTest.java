package clockTest;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import clockControler.ClockControler;
import clockModel.ClockModel;

public class ClockTest {
    static int HMS_VALEUR = 10;
    static int ZERO = 0;
    static int UN = 1;
    static int DEUX = 2;
    static int NEG_UN = -1;
    static int MAX_TESTS = 1000;
    ClockModel modele;
    ClockControler controleur;
    Random rd;

    // initialisation les variables modele controleur.
    //annotation "@Before" : initial() est execut� avant les tests
    @Before
    public void initial() {
        modele = new ClockModel(ZERO, ZERO, ZERO);
        controleur = new ClockControler(modele);
        rd = new Random();
    }

    //annotation "@Test" : m�thode suivante est un test
    // teste les m�thodes setHour(), getHour(), setMinute(), getMinute(), setSecond() et getSecond()
    // MinuteurModele.MAX_HEURE == 24
    // MinuteurModele.MAX_MINSEC== 60
    @Test
    public void testSetEtGet() {
        testSetHeure(); // testSetMinute(); testSetSeconde();
    }

    // tester les m�thodes setHour() et getHour()
    // MinuteurModele.MAX_HEURE == 24
    public void testSetHeure() {
        controleur.setHour(ClockModel.MAX_HOUR - UN);
        assertEquals(ClockModel.MAX_HOUR - UN, modele.getHour());
        controleur.setHour(HMS_VALEUR);
        assertEquals(HMS_VALEUR, modele.getHour());
        controleur.setHour(ZERO);
        assertEquals(ZERO, modele.getHour());

    }

    // tester les m�thodes setMinute() et getMinute()
    public void testSetMinute() {
        controleur.setMinute(ClockModel.MAX_MINSEC - UN);
        assertEquals(ClockModel.MAX_MINSEC - UN, modele.getMinute());
        controleur.setMinute(HMS_VALEUR);
        assertEquals(HMS_VALEUR, modele.getMinute());
        controleur.setMinute(ZERO);
        assertEquals(ZERO, modele.getMinute());
    }

    // tester les m�thodes setSecond() et getSecond()
    public void testSetSeconde() {
        controleur.setSecond(ClockModel.MAX_MINSEC - UN);
        assertEquals(ClockModel.MAX_MINSEC - UN, modele.getSecond());
        controleur.setSecond(HMS_VALEUR);
        assertEquals(HMS_VALEUR, modele.getSecond());
        controleur.setSecond(ZERO);
        assertEquals(ZERO, modele.getSecond());
    }

    // tester la m�thode incHour(x) avec x = 1 et avec x=-1;
    // tester la m�thode incHour(x) avec x choisi al�atoirement
    @Test
    public void testIncEtDecHeure() {
        testIncHeure();
        testDecHeure();
        testIncHeureQuelconque();
    }

    // tester la m�thode incHour(x) avec x choisi al�atoirement
    public void testIncHeureQuelconque() {
        int ajout, h;
        for (int i = 0; i < MAX_TESTS; i++) {
            h = modele.getHour();
            ajout = rd.nextInt(MAX_TESTS);
            controleur.incHour(ajout);
            assertEquals(modele.getHour(), (h + ajout) % ClockModel.MAX_HOUR);
        }
    }

    // tester la m�thode incHour(x) avec x = 1;
    public void testIncHeure() {
        /* 23h plus une heure donne 0h */
        controleur.setHour(ClockModel.MAX_HOUR - UN);
        controleur.incHour(UN);
        assertEquals(ZERO, modele.getHour());
        /* 0h plus une heure donne 1h */
        controleur.incHour(UN);
        assertEquals(UN, modele.getHour());
    }

    // tester la m�thode incHour(x) avec x = -1;
    public void testDecHeure() {
        /* 0h moins une heure donne 23h */
        controleur.setHour(ZERO);
        controleur.incHour(NEG_UN);
        assertEquals(ClockModel.MAX_HOUR - UN, modele.getHour());
        /* 23h moins une heure donne 22h */
        controleur.incHour(NEG_UN);
        assertEquals(ClockModel.MAX_HOUR - DEUX, modele.getHour());
    }

    // tester la m�thode incMinute(x) avec x = 1 et avec x=-1;
    // tester la m�thode incMinute(x) avec x choisi al�atoirement
    @Test
    public void testIncEtDecMinute() {
        testIncMinute();
        testDecMinute();
        testIncMinuteQuelconque();
    }

    // tester la m�thode incMinute(x) avec x choisi al�atoirement
    public void testIncMinuteQuelconque() {
        int ajout, m;
        for (int i = 0; i < MAX_TESTS; i++) {
            m = modele.getMinute();
            ajout = rd.nextInt(MAX_TESTS);
            controleur.incMinute(ajout);
            assertEquals(modele.getMinute(), (m + ajout) % ClockModel.MAX_MINSEC);
        }
    }

    // tester la m�thode incMinute(x) avec x = 1;
    public void testIncMinute() {
        // 10h:59m plus une minute donne 11h:0m
        controleur.setHour(HMS_VALEUR);
        controleur.setMinute(ClockModel.MAX_MINSEC - UN);
        controleur.incMinute(UN);
        assertEquals(HMS_VALEUR + UN, modele.getHour());
        assertEquals(ZERO, modele.getMinute());
        // 11h:0m plus une minute donne 11h:1m
        controleur.incMinute(UN);
        assertEquals(HMS_VALEUR + UN, modele.getHour());
        assertEquals(UN, modele.getMinute());
    }

    // tester la m�thode incMinute(x) avec x = -1;
    public void testDecMinute() {
        // 10h:0m moins une minute donne 9h:59m
        controleur.setHour(HMS_VALEUR);
        controleur.setMinute(ZERO);
        controleur.incMinute(NEG_UN);
        assertEquals(HMS_VALEUR - UN, modele.getHour());
        assertEquals(ClockModel.MAX_MINSEC - UN, modele.getMinute());
        // 9h:59m moins une minute donne 9h:58m
        controleur.incMinute(NEG_UN);
        assertEquals(HMS_VALEUR - UN, modele.getHour());
        assertEquals(ClockModel.MAX_MINSEC - DEUX, modele.getMinute());
    }

    // tester la m�thode incSecond(x) avec x = 1;
    @Test
    public void testIncSeconde() {
        // 10m:59s plus une seconde donne 11m:0s
        controleur.setMinute(HMS_VALEUR);
        controleur.setSecond(ClockModel.MAX_MINSEC - UN);
        controleur.incSecond(UN);
        assertEquals(HMS_VALEUR + UN, modele.getMinute());
        assertEquals(ZERO, modele.getSecond());
        // 11m:0s plus une seconde donne 11m:1s
        controleur.incSecond(UN);
        assertEquals(HMS_VALEUR + UN, modele.getMinute());
        assertEquals(UN, modele.getSecond());
        // 10h:59m:59s plus une seconde donne 11h:0m:0s
        controleur.setHour(HMS_VALEUR);
        controleur.setMinute(ClockModel.MAX_MINSEC - UN);
        controleur.setSecond(ClockModel.MAX_MINSEC - UN);
        controleur.incSecond(UN);
        assertEquals(HMS_VALEUR + UN, modele.getHour());
        assertEquals(ZERO, modele.getMinute());
        assertEquals(ZERO, modele.getSecond());
        // 23h:59m:59s plus une seconde donne 0h:0m:0s
        controleur.setHour(ClockModel.MAX_HOUR - UN);
        controleur.setMinute(ClockModel.MAX_MINSEC - UN);
        controleur.setSecond(ClockModel.MAX_MINSEC - UN);
        controleur.incSecond(UN);
        assertEquals(ZERO, modele.getHour());
        assertEquals(ZERO, modele.getMinute());
        assertEquals(ZERO, modele.getSecond());
    }

    // tester la m�thode incSecond(x) avec x = -1;
    @Test
    public void testDecSeconde() {
        // 10m:0s moins une seconde donne 9m:59s
        controleur.setMinute(HMS_VALEUR);
        controleur.setSecond(ZERO);
        controleur.incSecond(NEG_UN);
        assertEquals(HMS_VALEUR - UN, modele.getMinute());
        assertEquals(ClockModel.MAX_MINSEC - UN, modele.getSecond());
        // 9m:59s moins une seconde donne 9m:58s
        controleur.incSecond(NEG_UN);
        assertEquals(HMS_VALEUR - UN, modele.getMinute());
        assertEquals(ClockModel.MAX_MINSEC - DEUX, modele.getSecond());
        // 10h:0m:0s moins une seconde donne 9h:59m:59s
        controleur.setHour(HMS_VALEUR);
        controleur.setMinute(ZERO);
        controleur.setSecond(ZERO);
        controleur.incSecond(NEG_UN);
        assertEquals(HMS_VALEUR - UN, modele.getHour());
        assertEquals(ClockModel.MAX_MINSEC - UN, modele.getMinute());
        assertEquals(ClockModel.MAX_MINSEC - UN, modele.getSecond());
        // 0h:0m:0s moins une seconde donne 23h:59m:59s
        controleur.setHour(ZERO);
        controleur.setMinute(ZERO);
        controleur.setSecond(ZERO);
        controleur.incSecond(NEG_UN);
        assertEquals(ClockModel.MAX_HOUR - UN, modele.getHour());
        assertEquals(ClockModel.MAX_MINSEC - UN, modele.getMinute());
        assertEquals(ClockModel.MAX_MINSEC - UN, modele.getSecond());
    }

    // tester la m�thode incSecond(x) avec x choisi al�atoirement
    @Test
    public void testIncSecondeQuelconque() {
        int ajout, s, m, h, sec, min, heure;
        for (int i = 0; i < MAX_TESTS; i++) {
            s = modele.getSecond();
            m = modele.getMinute();
            h = modele.getHour();
            ajout = rd.nextInt(MAX_TESTS);
            controleur.incSecond(ajout);
            sec = (s + ajout) % ClockModel.MAX_MINSEC;
            min = (m + (s + ajout) / ClockModel.MAX_MINSEC) % ClockModel.MAX_MINSEC;
            heure = (h +
                    (m +
                            (s + ajout) / ClockModel.MAX_MINSEC
                    ) / ClockModel.MAX_MINSEC
            )
                    % ClockModel.MAX_HOUR;
            assertEquals(modele.getSecond(), sec);
            assertEquals(modele.getMinute(), min);
            assertEquals(modele.getHour(), heure);
        }
    }
}


