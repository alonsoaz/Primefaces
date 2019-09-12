package pe.edu.galaxy.training.java.web.azaldegui.examen.presentacion;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.GenericoBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.UsuarioBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.util.Constantes;
import pe.edu.galaxy.training.java.web.azaldegui.examen.util.Net;

public class GenericoMB {
	
	 protected void aviso(String msg) {
	        FacesContext.getCurrentInstance().addMessage(null,
	        		new FacesMessage(FacesMessage.SEVERITY_INFO,
	        				"Aviso", msg));
	    }
	     
	 protected void alerta(String msg) {
	        FacesContext.getCurrentInstance().addMessage(null,
	        		new FacesMessage(FacesMessage.SEVERITY_WARN,
	        				"Alerta!", msg));
	    }
	     
	 protected void error(String msg) {
	        FacesContext.getCurrentInstance().addMessage(null,
	        		new FacesMessage(FacesMessage.SEVERITY_ERROR, 
	        				"Error!", msg));
	    }
	     
	 protected void fatal(String msg) {
	        FacesContext.getCurrentInstance().addMessage(null, 
	        		new FacesMessage(FacesMessage.SEVERITY_FATAL, 
	        				"Fatal!", msg));
	    }
	 
		protected String getStringJSF(String key) {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			Properties properties = new Properties();
			try {
				properties.load(cl.getResourceAsStream(Constantes.FILE_NAME_RESOURCE));
				return properties.getProperty(key); 
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return "";
		}
		
		protected HttpServletRequest getRequest(){	
			FacesContext fctx = FacesContext.getCurrentInstance();
			ExternalContext ectx = fctx.getExternalContext();
			HttpServletRequest request = (HttpServletRequest) ectx.getRequest();
			return request;
		}
		
		protected HttpServletResponse getResponse(){	
			FacesContext fctx = FacesContext.getCurrentInstance();
			ExternalContext ectx = fctx.getExternalContext();
			HttpServletResponse response = (HttpServletResponse) ectx.getResponse();
			return response;
		}

		
		protected UsuarioBean getUsuarioActivo() {
			UsuarioBean oUsuarioBean=null;
			HttpSession session= this.getRequest().getSession();
			if (session!=null) {
				Object obj=session.getAttribute("usuario");
				if (obj!=null) {
					oUsuarioBean=(UsuarioBean)obj;
				}
			}
			return oUsuarioBean;
		}
		
		protected void setAuditoria(GenericoBean ge){
				
			HttpSession session= this.getRequest().getSession();
			if (session!=null) {
				
				// Usuario
				Object obj=session.getAttribute("usuario");
				if (obj!=null) {
					UsuarioBean oUsuarioBean=(UsuarioBean)obj;
					ge.setAudIdUsuario(oUsuarioBean.getCodigo());
				}
				
				// Sesion
				Object id=session.getAttribute("ID");
				if (id!=null) {
					String oID=(String)id;
					ge.setAudSession(oID);
				}
			}
			// IP
			String ip= Net.getClientIPAddres(this.getRequest());
			ge.setAudIp(ip);
		}
		
		/*
		 * Formato de Exportación de Excel
		 */
		
		protected void setStyleFormat(HSSFWorkbook workbook, Cell cell) {
	        HSSFFont font = workbook.createFont();
	        font.setFontHeightInPoints((short) 10);
	        font.setFontName("Arial");
	        font.setColor(IndexedColors.BLACK.getIndex());
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        font.setItalic(false);

	        CellStyle newCellStyle = workbook.createCellStyle();
	        newCellStyle.cloneStyleFrom(cell.getCellStyle());

//			newCellStyle.setFillBackgroundColor(IndexedColors.DARK_BLUE.getIndex());
//			newCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	        newCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
	        newCellStyle.setFont(font);

	        cell.setCellStyle(newCellStyle);
	    }

	    protected void setStyleLisCabecera(HSSFWorkbook workbook, Cell cell) {
	        HSSFFont font = workbook.createFont();
	        font.setFontHeightInPoints((short) 10);
	        font.setFontName("Arial");
	        font.setColor(IndexedColors.WHITE.getIndex());
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        font.setItalic(false);

	        CellStyle newCellStyle = workbook.createCellStyle();
	        newCellStyle.cloneStyleFrom(cell.getCellStyle());

	        newCellStyle.setFillForegroundColor(HSSFColor.RED.index);
	        newCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	        newCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
	        newCellStyle.setBorderTop((short) 1); // single line border
	        newCellStyle.setBorderBottom((short) 1); // single line border
	        newCellStyle.setBorderRight((short) 1);
	        newCellStyle.setBorderLeft((short) 1);
	        newCellStyle.setFont(font);

	        cell.setCellStyle(newCellStyle);
	    }

	    @SuppressWarnings({ "unchecked", "rawtypes" })
		protected JasperPrint setupReport(String rpt, String filtro,List<?> lst) {
	        ServletContext sc=(ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
	        String path="WEB-INF\\classes\\pe\\edu\\galaxy\\training\\java\\web\\presentacion\\rpt\\";
	        String realPath = sc.getRealPath("/")+path;
	        String reporte = realPath + rpt+".jasper";
	        
	        System.out.println("reporte "+reporte);
	        
	        String pathSO=sc.getRealPath("/");
	        String logo =pathSO+ "resources\\img\\galaxy-training-logo.png";
	        System.out.println("logo "+logo);
	        Map map = new HashMap();
	        map.put("prm_logo_izquierda", logo);
	        
	        map.put("prm_usuario", this.getUsuarioActivo().getNombre());
	        
	        
			map.put("prm_filtro", filtro);
			map.put("prm_sistema", this.getStringJSF("sistema.nombre"));
			map.put("prm_modulo", this.getStringJSF("modulo.maestro"));
			 JasperPrint jasperPrint = null;
			 try {
		            jasperPrint = JasperFillManager.fillReport(reporte, map, new JRBeanCollectionDataSource(lst));
		        } catch (JRException e) {
		            e.printStackTrace();
		        }
			
			return jasperPrint;
	    }
}
