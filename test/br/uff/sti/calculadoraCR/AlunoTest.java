package br.uff.sti.calculadoraCR;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/* @author Luam */

public class AlunoTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    
    @Before
    public void setStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @After
    public void restoreInitialStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    
    /* Test of calcularCR method, of class Aluno. */
    @Test
    public void testCalcularCR() {
        Aluno a = new Aluno(100,4);
        Disciplina d = new Disciplina("SEN00209",82, 60, 20171);
        ArrayList<Disciplina> historico =  new ArrayList(Arrays.asList(d));
        a.setHistorico(historico);
        a.calcularCR();
        assertEquals(82f,a.cr,0);
    }

    
    /* Test of imprimirCR method, of class Aluno. */
    @Test
    public void testImprimirCR() {
        Aluno a = new Aluno(100,4);
        Disciplina d = new Disciplina("SEN00209",82, 60, 20171);
        ArrayList<Disciplina> historico =  new ArrayList(Arrays.asList(d));
        a.setHistorico(historico);
        a.calcularCR();
        a.imprimirCR();
        assertEquals("100 - 82 \n",out.toString());
        
    }

}
