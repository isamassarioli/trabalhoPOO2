package cgt;

import cgd.Conexao;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

public class GeradorRelatorio {

    public void abrirRelatorio() {
        try (
            Connection conexao = new Conexao("meu_exemplo", "postgres", "postgre").getConnection();
            InputStream relatorio = getClass().getResourceAsStream("/pooReport.jasper")
        ) {
            if (relatorio == null) {
                throw new RuntimeException("Arquivo pooReport.jasper não encontrado em src/main/resources.");
            }

            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, new HashMap<>(), conexao);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}