package cgt;

import cgd.Conexao;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperExportManager;

import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.util.HashMap;

public class GeradorRelatorio {

    public void abrirRelatorio(String nomeRelatorio) {
        try (Connection conexao = new Conexao("meu_exemplo", "postgres", "isadora").getConnection()) {
            
            String caminho = "/Reports/" + nomeRelatorio;
            InputStream input = getClass().getResourceAsStream(caminho); 
            
            if (input == null) {
                throw new RuntimeException("Arquivo do relatório não encontrado em: src/main/resources" + caminho);
            }

            // Transforma as imagens em blocos de memória (byte arrays) seguros para o Jasper
            byte[] imgPainel = lerBytes(getClass().getResourceAsStream("/Reports/painel2.png"));
            byte[] imgLogo = lerBytes(getClass().getResourceAsStream("/Reports/logohorizontal.png"));
            
            if (imgPainel == null) {
                System.out.println("[AVISO] Imagem 'painel2.png' não foi localizada em src/main/resources/Reports/");
            }
            if (imgLogo == null) {
                System.out.println("[AVISO] Imagem 'logohorizontal.png' não foi localizada em src/main/resources/Reports/");
            }

            // injeta as imagens nos parâmetros correspondentes do arquivo JRXML
            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("PARAM_PAINEL", imgPainel);
            parametros.put("PARAM_LOGO", imgLogo);

            // Compila o layout e preenche com os dados do banco de dados
            JasperReport jasperReport = JasperCompileManager.compileReport(input); 
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conexao);
            
            // Define o nome e caminho temporário do PDF para não entulhar o disco do usuário
            String nomeArquivoPdf = nomeRelatorio.replace(".jrxml", "").replace(".jasper", "") + ".pdf";
            File arquivoPdf = new File(System.getProperty("java.io.tmpdir") + File.separator + nomeArquivoPdf);
            
            // Exporta o relatório gerado diretamente para formato PDF físico
            JasperExportManager.exportReportToPdfFile(jasperPrint, arquivoPdf.getAbsolutePath());
            
            // Dispara o leitor de PDF padrão do sistema operacional do usuário
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(arquivoPdf);
            } else {
                System.out.println("Visualização automática indisponível. Arquivo gerado em: " + arquivoPdf.getAbsolutePath());
            }

        } catch (Exception e) {
            System.out.println("--- ERRO AO CARREGAR RELATÓRIO COM IMAGENS ---");
            e.printStackTrace();
        }
    }

    // Lê os streams das imagens do JAR/projeto e converte em bytes limpos
    private byte[] lerBytes(InputStream stream) {
        if (stream == null) return null;
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
            int nRead;
            byte[] data = new byte[4096];
            while ((nRead = stream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            return buffer.toByteArray();
        } catch (Exception e) {
            System.out.println("[ERRO] Falha ao processar fluxo de bytes da imagem.");
            return null;
        }
    }
}
