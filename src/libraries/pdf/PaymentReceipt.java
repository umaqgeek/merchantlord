/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Cell;
import javax.swing.JOptionPane;
import libraries.My_func;
import main.RMIConnector;
import models.DBConn;

/**
 *
 * @author umarmukhtar
 */
public class PaymentReceipt {
    
    private String filename = "Receipt.pdf";
    protected Font font10 = new Font(Font.FontFamily.HELVETICA, 10);
    protected Font font12 = new Font(Font.FontFamily.HELVETICA, 12);
    protected Font font14 = new Font(Font.FontFamily.HELVETICA, 14);
    protected Font font18 = new Font(Font.FontFamily.HELVETICA, 18);
    
    public PaymentReceipt() {
        this.filename = "Receipt.pdf";
    }
    
    public PaymentReceipt(String filename) {
        this.filename = filename + ".pdf";
    }
    
    private void header() throws IOException {
        File file = new File(filename);
        boolean isFile = file.createNewFile();
        System.out.println("isFile:"+isFile);
    }
    
    private PdfPCell getCell(String data, int isBorder, int width, int colspan) {
        PdfPCell cellhr = new PdfPCell(new Phrase(data));
        if (isBorder != -1) {
            cellhr.setBorder(isBorder);
        } else {
            cellhr.setBorder(0);
        }
        if (width != -1) {
            cellhr.setBorderWidth(width);
        }
        if (colspan != -1) {
            cellhr.setColspan(colspan);
        }
        return cellhr;
    }
    
    private PdfPTable getTable(ArrayList<String[]> header, ArrayList<String[]> body) throws DocumentException {
        
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new float[] { 8, 1, 11 });
        table.getDefaultCell().setBorder(0);
        
        // row 0
        PdfPCell cellhr0 = getCell(" ", 0, -1, 3);
        cellhr0.setBorderWidthTop(0.2F);
        table.addCell(cellhr0);
        
        for (int i = 0; i < header.size(); i++) {
            table.addCell(header.get(i)[0]);
            table.addCell(header.get(i)[1]);
            table.addCell(header.get(i)[2]);
        }
        
        // row 4
        PdfPCell cellhr41 = getCell(" ", 0, -1, 3);
        cellhr41.setBorderWidthBottom(0.1F);
        table.addCell(cellhr41);
        PdfPCell cellhr42 = getCell(" ", 0, -1, 3);
        cellhr42.setBorderWidthTop(0.1F);
        table.addCell(cellhr42);
        
        for (int i = 0; i < body.size(); i++) {
            table.addCell(body.get(i)[0]);
            table.addCell(body.get(i)[1]);
            table.addCell(body.get(i)[2]);
        }
        
        return table;
    }
    
    private String[] getDataCell(String property, String value) {
        String data[] = new String[3];
        data[0] = property;
        data[1] = ":";
        data[2] = value;
        return data;
    }
    
    private void bodyReceiptTransfer(int tr_id) throws DocumentException, FileNotFoundException {
        
        // step 1
        Document document = new Document();
        
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        
        // step 3
        document.open();

        // stap 4 - data/body
        Paragraph p = new Paragraph("Debit Gram Transfer Receipt", font18);
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        document.add(new Paragraph(" ", font14));
        
        RMIConnector rmic = new RMIConnector(DBConn.getHost(), DBConn.getPort_rmi());
        ArrayList<String> dgt = rmic.dgt_getDataForReceipt(tr_id);
        if (dgt.size() > 0) {
            
            ArrayList<String[]> headers = new ArrayList<String[]>();
            headers.add(getDataCell("Transaction ID", dgt.get(0)+dgt.get(1)));
            headers.add(getDataCell("Transaction Type", dgt.get(2)));
            headers.add(getDataCell("Transaction Status", dgt.get(3)));
            
            ArrayList<String[]> bodies = new ArrayList<String[]>();
            bodies.add(getDataCell("Merchant ID", dgt.get(5)+" "+dgt.get(6)+" ("+dgt.get(4)+")"));
            bodies.add(getDataCell("Customer ID", dgt.get(8)+" "+dgt.get(9)+" ("+dgt.get(7)+")"));
            bodies.add(getDataCell("Payment Type", dgt.get(10)));
            double tr_amount = 0.0;
            try {
                tr_amount = Double.parseDouble(dgt.get(12));
            } catch (Exception e) {
                tr_amount = 0.0;
            }
            String str_amount = My_func.getStrDPGDPSUnit(tr_amount);
            bodies.add(getDataCell("Amount Transfer", dgt.get(11)+" "+str_amount+" grams"));
            bodies.add(getDataCell("Date & Time", dgt.get(13)));
            bodies.add(getDataCell("Description", dgt.get(14)));
            
            PdfPTable table = getTable(headers, bodies);
            document.add(table);
        }

        // step 5
        document.close();
    }
    
    private void openFile() throws IOException {
        Runtime.getRuntime().exec("open "+filename);
    }
    
    public void generate(int stat, int tr_id) {
        try {
            
            header();
            
            switch (stat) {
                case 1:
                    bodyReceiptTransfer(tr_id);
                    break;
            }
            
            openFile();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(), "Generate PDF", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: "+ex.getMessage());
        }
    }
}
