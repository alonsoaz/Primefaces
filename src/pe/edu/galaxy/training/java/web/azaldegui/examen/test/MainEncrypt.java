package pe.edu.galaxy.training.java.web.azaldegui.examen.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import pe.edu.galaxy.training.java.web.azaldegui.examen.util.Encrypt;

public class MainEncrypt {
	
	public static void main(String args[]) throws GeneralSecurityException, IOException{
	
		String clave="abc";
		Encrypt.init("tr41n1ng");
		System.out.println(Encrypt.encrypt(clave));
		//System.out.println(Encrypt.decrypt("77nmYxDY3X8="));
		
		//xdlOnb5Nv0M=
		//KWE5epAli+M=
		
	}

}
