package pe.edu.galaxy.training.java.web.azaldegui.examen.presentacion;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pe.edu.galaxy.training.java.web.azaldegui.examen.bean.UsuarioBean;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.exception.ServicioException;
import pe.edu.galaxy.training.java.web.azaldegui.examen.service.inf.UsuarioService;

@Controller("usuarioMB")
@Scope(value="session")
public class UsuarioMB extends GenericoMB{
	
	private List<UsuarioBean> lstUsuarios;
	
	@Autowired 
	private UsuarioService usuarioService;
	
	private UsuarioBean usuario;

	@PostConstruct
	public void init() {
		this.setUsuario(new UsuarioBean());
		this.setLstUsuarios(new ArrayList<UsuarioBean>());
		this.buscar();

	}
	
	public void limpiar() {
		this.setUsuario(new UsuarioBean());
		this.buscar();
	}
	
	
	public void buscar() {
		try {

			this.lstUsuarios = this.getUsuarioService().listar(this.usuario);

		} catch (ServicioException e) {
			e.printStackTrace();
		}
	}
	
	 public void exportExcel() {

	        try {

	            HttpServletResponse response = super.getResponse();

	            response.setContentType("application/vnd.ms-excel");
	            response.setHeader("Content-Disposition", "attachment; filename=Listado_de_usuarios.xls");

	            HSSFWorkbook workbook = new HSSFWorkbook();

	            if (this.lstUsuarios != null) {
	                workbook = this.exportExcelFormato(this.lstUsuarios);

	            }

	            OutputStream out = response.getOutputStream();
	            workbook.write(out);
	            out.close();
	            FacesContext.getCurrentInstance().responseComplete();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private HSSFWorkbook exportExcelFormato(List<UsuarioBean> lstUsuarioBeans) {
	        HSSFWorkbook workbook = new HSSFWorkbook();
	        HSSFSheet sheet = workbook.createSheet("Listado de Usuarios");

	        int countRow = 0;

	        // CABECERA
	        Row row = sheet.createRow(countRow);

	        Cell cell = row.createCell(0);
	        cell.setCellValue("Item");
	        super.setStyleLisCabecera(workbook, cell);

	        cell = row.createCell(1);
	        cell.setCellValue("Código");
	        super.setStyleLisCabecera(workbook, cell);

	        cell = row.createCell(2);
	        cell.setCellValue("Nombre");
	        super.setStyleLisCabecera(workbook, cell);

	        cell = row.createCell(3);
	        cell.setCellValue("Usuario");
	        super.setStyleLisCabecera(workbook, cell);

	        // LISTADO
	        int item = 0;

	        for (UsuarioBean usuarioBean : lstUsuarioBeans) {

	            countRow++;
	            item++;

	            row = sheet.createRow(countRow);

	            cell = row.createCell(0);
	            cell.setCellValue(item);

	            // CODIGO
	            cell = row.createCell(1);
	            cell.setCellValue(usuarioBean.getCodigo());

	            // NOMBRE
	            cell = row.createCell(2);
	            cell.setCellValue(usuarioBean.getNombre());

	            // USUARIO
	            cell = row.createCell(3);
	            cell.setCellValue(usuarioBean.getUsuario());

	        }

	        return workbook;
	    }
	    
		   public void exportPDF() {
		        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		        httpServletResponse.addHeader("Content-disposition", "attachment; filename=producto_listado_rpt.pdf");
		        ServletOutputStream servletStream;
		        try {
		            servletStream = httpServletResponse.getOutputStream();
		            
		            String filtro="";
			        
			        if(this.getUsuario().getNombre().trim().length()>0) {
			        	filtro="Nombre :"+this.getUsuario().getNombre();
			        }
			        
			        if(this.getUsuario().getUsuario().trim().length()>0) {
			        	if (filtro.length()>0) {
			        		filtro+=",";
						}
			        	filtro+="Usuario :"+this.getUsuario().getUsuario();
			        }
			        JasperPrint jasperPrint = super.setupReport("usuario_listado_rpt", filtro, this.lstUsuarios);
		            try {
		                JasperExportManager.exportReportToPdfStream(jasperPrint, servletStream);

		            } catch (JRException e) {
		                e.printStackTrace();
		            }

		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		        FacesContext.getCurrentInstance().responseComplete();
		    }


	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioBean> getLstUsuarios() {
		return lstUsuarios;
	}

	public void setLstUsuarios(List<UsuarioBean> lstUsuarios) {
		this.lstUsuarios = lstUsuarios;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	
}
