package pe.edu.galaxy.training.java.web.azaldegui.examen.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.UsuarioBean;

public class usuario_listado_rpt_test {
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		
		List<UsuarioBean> lstUsuarios = new ArrayList<UsuarioBean>();
		
		try {
			
			UsuarioBean usuario1 = new UsuarioBean();
			usuario1.setCodigo(1);
			usuario1.setNombre("Aristedes Novoa");
			usuario1.setUsuario("anovoa");
			
			lstUsuarios.add(usuario1);
			
			UsuarioBean usuario2 = new UsuarioBean();
			usuario2.setCodigo(2);
			usuario2.setNombre("Luis Vega");
			usuario2.setUsuario("lvega");
			
			lstUsuarios.add(usuario2);
			
			
		} catch (Exception e) {
			System.out.println("Error List" + e.getMessage());
		}
		
        String url="src/pe/edu/galaxy/training/java/web/presentacion/rpt/";
        try {
            JasperPrint jasperPrint;
            JasperDesign desing= null;
            try {
            	String reporte=url+"usuario_listado_rpt.jrxml";
				desing = JRXmlLoader.load(new FileInputStream(reporte));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		String reporte;
			JasperCompileManager.compileReportToFile(desing,url+"usuario_listado_rpt.jasper");
			reporte=url+"usuario_listado_rpt.jasper";
			
			@SuppressWarnings("rawtypes")
			Map map=new HashMap();
		
			map.put("prm_empresa", "Galaxy Training");
			map.put("prm_usuario", "Lucas Cueva");
			map.put("prm_filtro", "Situacion: Bloqueados");
			map.put("prm_logo_izquierda","WebContent/resources/img/galaxy-training-logo.png");		
			map.put("prm_sistema", "� Copyright 2016 - Sistema de Pedidos (SIPE) v1.0");
						
           jasperPrint = JasperFillManager.fillReport(reporte, map, new JRBeanCollectionDataSource(lstUsuarios));
           JasperViewer jv=new JasperViewer(jasperPrint,false);
           jv.show();
           
            System.out.println("Visualizando el reporte en Desktop");
            System.out.println("Agregado exitosamente");
            
        } catch (JRException e) {
            System.out.println("Error"+e.getMessage());
            //e.printStackTrace();
        }

		
		
	}

}
