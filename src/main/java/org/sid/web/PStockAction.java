package org.sid.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;

import java.io.FileOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.struts2.ServletActionContext;


import org.apache.log4j.Logger;
import org.sid.entities.Produits_Stock;
import org.sid.service.IsevicePStock;
import org.springframework.beans.factory.annotation.Autowired;


public class PStockAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//instantion de Produits_Stock 
	public Produits_Stock produitStock = new Produits_Stock();
	//liste des produits de stock
	public List<Produits_Stock> listPStock;
	//false pour ajouter un produit et true pour modifier
	public boolean editMode=false;
	//message d'erreur
	public String codeErr = "";
	//code de produit
	public int codeP;
	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 18,
			Font.BOLD);
	@Autowired
	private IsevicePStock service;
	Logger logger =Logger.getLogger(this.getClass());
	
	//remplir la liste des stock
	public String index() {
		listPStock = service.listProduit();
		  return SUCCESS;
	  }
	
	//cette methode va modifier ou ajouter un produit stock 
	public String save() {
		try {
			if(editMode == false) {
				//ajouter un produit
				service.addProduit(produitStock);
				produitStock = new Produits_Stock();
				codeErr = "";
			}
				  else {
					  //modifier un produit
					  service.updateProduit(produitStock);
					  editMode=false;
					  produitStock = new Produits_Stock();
					  codeErr = "";
				  }
		} catch (Exception e) {
			//erreur: si le code de produit est déja existe
			codeErr = "Ce code est déja existe";
			System.err.println("erroooooor");
		}
			//remplir la liste des stock
		  listPStock = service.listProduit();
		  return SUCCESS;
	  }
	//suppression d'un produit
	public String delete() {
		  service.deleteProduit(codeP);
		  listPStock = service.listProduit();
		  return SUCCESS;
	  }
	
	//initialiser les inputs avec les valeurs de produit selectioné
	public String edit() {
		  editMode= true;
		  produitStock = service.getProduit(codeP);
		  listPStock = service.listProduit();
		  return SUCCESS;
	  }
	  
	  // telecharger le pdf
	  public String downloadCSVFileAction()  throws Exception {
			 
			final ServletContext servletContext = ServletActionContext.getServletContext();
		    final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		    final String temperotyFilePath = tempDirectory.getAbsolutePath();
	 
		    String fileName = "Situation Stock.pdf";
		    HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/pdf");
		    response.setHeader("Content-disposition", "attachment; filename="+ fileName);
	 
		    try {
	 
		    	createPDF(temperotyFilePath+"\\"+fileName);
		        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		        baos = convertPDFToByteArrayOutputStream(temperotyFilePath+"\\"+fileName);
		        OutputStream os = response.getOutputStream();
		        baos.writeTo(os);
		        os.flush();
		        os.close();
		        return SUCCESS;
		    } catch (Exception e1) {
		        e1.printStackTrace();
		    }
			return SUCCESS;
		}
	  
		private ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {
			 
			InputStream inputStream = null;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
	 
				inputStream = new FileInputStream(fileName);
				byte[] buffer = new byte[1024];
				baos = new ByteArrayOutputStream();
	 
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					baos.write(buffer, 0, bytesRead);
				}
	 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return baos;
		}
		//creer le contenu du pdf
		public  Document createPDF(String file) {
			 
			Document document = null;
	 
			try {
				document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(file));
				document.open();
	 
				addMetaData(document);
				
				AddImage(document);
	 
				addTitlePage(document);
	 
				createTable(document);
	 
				document.close();
	 
			} catch (FileNotFoundException e) {
	 
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			return document;
	 
		}
		private  void addMetaData(Document document) {
			document.addTitle("situation de Stock");
			document.addSubject("situation de Stock");
			document.addAuthor("Java Honk");
			document.addCreator("Java Honk");
		}
		private  void addTitlePage(Document document)
				throws DocumentException {
	 
			Paragraph preface = new Paragraph();
			creteEmptyLine(preface, 1);
			preface.add(new Paragraph("Situation de Stock", TIME_ROMAN));
			preface.setAlignment(Element.ALIGN_CENTER);
	 
			creteEmptyLine(preface, 1);
			document.add(preface);
	 
		}
		private  void creteEmptyLine(Paragraph paragraph, int number) {
			for (int i = 0; i < number; i++) {
				paragraph.add(new Paragraph(" "));
			}
		}
		//creation de la table situation de stock pdf
		private  void createTable(Document document) throws DocumentException {
					listPStock = service.listProduit();
			Paragraph paragraph = new Paragraph();
			creteEmptyLine(paragraph, 2);
			document.add(paragraph);
			PdfPTable table = new PdfPTable(6);
	 
			PdfPCell c1 = new PdfPCell(new Phrase("Code Produit"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
	 
			c1 = new PdfPCell(new Phrase("Quantite"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
	 
			c1 = new PdfPCell(new Phrase("Nom"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase("Description"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase("Prix Unitaire"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase("Prix Total"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
				table.setHeaderRows(1);
	 
				for (Produits_Stock p : listPStock) {
					table.setWidthPercentage(100);
					table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
					table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
						table.addCell(p.getCodePdt()+"");
						table.addCell(p.getQtePdt()+"");
						table.addCell(p.getNomPdt());
						table.addCell(p.getDescPdt());
						table.addCell(p.getPrixPdt()+"");
						table.addCell(p.getPrixPdt()*p.getQtePdt()+"");
				}
				
			
			document.add(table);
		}
		
		//Ajouter une image dans le pdf
		
		private void AddImage(Document document) throws DocumentException {
			 
	        Image img;
				try {
					
					img = Image.getInstance("D:/java jEE/eclipse/workspJSF/Gestion-Stock/src/main/java/org/sid/web/shop.png");
					img.scaleAbsolute(100f,100f);
					document.add(img);
			        System.out.println("Done");
				} catch (BadElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   
	   }
}
