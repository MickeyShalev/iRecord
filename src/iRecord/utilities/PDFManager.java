package iRecord.utilities;
    
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author StackOverflow
 */
public class PDFManager {
    
    private HashMap<Integer, PDFFile> files;
    
    public PDFManager() {
        files = new HashMap<Integer, PDFFile>();
    }
    
    public void createPDF(Integer PDFNo, String fileName) {
        try {
            this.files.put(PDFNo, new PDFFile(fileName));
        } catch (DocumentException ex) {
            Logger.getLogger(PDFManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public PDFFile getPDFFile(int fileName) {
        return this.files.get(fileName);
    }
    
    
    
    
    
    
    public class PDFFile {
        
        private File pdfFile;
        private Document document;
        private Font catFont;
        private Font redFont;
        private Font subFont;
        private Font smallBold;
        private HashMap<Integer, Chapter> chapters;
        
        public PDFFile(String fileName) throws DocumentException, FileNotFoundException {
            catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
            subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            chapters = new HashMap<>();
            pdfFile = new File("src/sources/reports/"+fileName+".pdf");
            document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
            document.open();
        }
        
        public void addTitlePage(String title) throws DocumentException {
            Paragraph preface = new Paragraph();
            addEmptyLine(preface, 1);
            preface.add(new Paragraph(title, catFont));
            preface.add(new Paragraph(
                    "Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    smallBold));
            addEmptyLine(preface, 1);
            preface.add(new Paragraph(
                    "iRecord - MuzaMusic ltd.",
                    redFont));
            document.add(preface);
        }
        
        public void createChapter(int ChapterNo, String chapterTitle) throws DocumentException {
            Anchor anchor = new Anchor(chapterTitle, catFont);
            anchor.setName(chapterTitle);
            Chapter catPart = new Chapter(new Paragraph(anchor), ChapterNo);
            chapters.put(ChapterNo, catPart);
        }
        
        public Chapter getChapter(int chapterNo) throws DocumentException {
            return chapters.get(chapterNo);
        }
        
        public void addChapter(Chapter chapter) throws DocumentException {
            document.add(chapter);
        }
        
        public void addParagraph(Paragraph paragraph) throws DocumentException {
            document.add(paragraph);
        }
        
        public void addTable(int col, int row, String[] titles, String[] values) throws BadElementException, DocumentException {
            if (col == 0 || row == 0) {
                return;
            }
            Paragraph p1 = new Paragraph();
            addEmptyLine(p1, 1);
            PdfPTable table = new PdfPTable(col);
            PdfPCell c1;
            table.setHeaderRows(0);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.setWidthPercentage(100);
            if (titles != null) {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < col; j++) {
                        c1 = new PdfPCell(new Phrase(titles[j]));
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(c1);
                    }
                }
            }
            if (values != null) {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < col; j++) {
                        c1 = new PdfPCell(new Phrase(values[j]));
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(c1);
                    }
                }
            }
            p1.add(table);
            document.add(p1);
        }
        
        public void addList(String title, ArrayList<String> data) throws DocumentException {
            Paragraph p1 = new Paragraph();
            p1.add(title);
            List list = new List(true, false, 10);
            for (String s : data) {
                list.add(new ListItem(s));
            }
            p1.add(list);
                document.add(p1);
        }
        
        private void addEmptyLine(Paragraph paragraph, int number) {
            for (int i = 0; i < number; i++) {
                paragraph.add(new Paragraph(" "));
            }
        }
        
//        public void launchPDF() {
//            document.close();
//            try {
//                if (pdfFile.exists()) {
//                    if (Desktop.isDesktopSupported()) {
//                        Desktop.getDesktop().open(pdfFile);
//                    } else
//                        JOptionPane.showMessageDialog(WindowManager.getMainFrame(), "Awt Desktop is not supported :(",
//                                "File error", JOptionPane.ERROR_MESSAGE);
//                } else
//                    JOptionPane.showMessageDialog(WindowManager.getMainFrame(),"File not found :(",
//                            "File error",JOptionPane.ERROR_MESSAGE);
//            } catch (IOException ex) {
//                Logger.getLogger(PDFManager.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }
}