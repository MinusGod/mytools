package com.feng.util;

import java.io.FileOutputStream;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFUtil {
	public static void  main (String[] args){
		Document doc=new Document(PageSize.A4);
		try {
			BaseFont chinese=BaseFont.createFont("c://windows//fonts//simsun.ttc,1", BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
			//BaseFont chinese=BaseFont.createFont("STFangsong", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
			Font fontChinese=new Font(chinese,12,Font.NORMAL);
			PdfWriter writer=PdfWriter.getInstance(doc, new FileOutputStream("F:\\itext.pdf"));
			doc.open();
			int i=0;
			while(i<40){
				i++;
				doc.add(new Paragraph("你好,这是我的测试程序。尊敬的用户。欢迎您来到融友网。PDF",fontChinese));
			}
			Image img=Image.getInstance("F:\\test.jpg");
			img.scalePercent(5f);
			doc.add(img);
			doc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		PDFUtil.waterMark("F:/itext.pdf","F:/test.png","F:/text.pdf","水印",1);
		System.out.println("水印生成成功");
		PDFUtil.waterMark("F:/itext.pdf","F:/test.png","F:/text.pdf","水印",1);
		System.out.println("水印生成成功");
	}
	
	
	 public static void waterMark1(String inputFile, String imageFile,
	            String outputFile, String waterMarkName, int permission) {  
	        try {  
	            PdfReader reader = new PdfReader(inputFile);  
	            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(  
	                    outputFile));  
	  
	            BaseFont base = BaseFont.createFont(  
	                    "C:/WINDOWS/Fonts/SIMSUN.TTC,1", "Identity-H", true);// 使用系统字体  
	  
	            int total = reader.getNumberOfPages() + 1;  
	            Image image = Image.getInstance(imageFile);  
	  
	            // 图片位置  
	            image.setAbsolutePosition(100, 100);  
	            PdfContentByte under;  
	            int j = waterMarkName.length();  
	            char c = 0;  
	            int rise = 0;  
	            for (int i = 1; i < total; i++) {  
	                rise = 400;  
	                under = stamper.getUnderContent(i);  
	                under.beginText();  
	                under.setFontAndSize(base, 30);  
	  
	                if (j >= 15) {  
	                    under.setTextMatrix(200, 120);  
	                    for (int k = 0; k < j; k++) {  
	                        under.setTextRise(rise);  
	                        c = waterMarkName.charAt(k);  
	                        under.showText(c + "");  
	                    }  
	                } else {  
	                    under.setTextMatrix(240, 100);  
	                    for (int k = 0; k < j; k++) {  
	                        under.setTextRise(rise);  
	                        c = waterMarkName.charAt(k);  
	                        under.showText(c + "");  
	                        rise -= 18;  
	  
	                    }  
	                }

	                // 添加水印文字  
	                under.endText();  
	  
	                // 添加水印图片  
	                under.addImage(image);  
	  
	                // 画个圈  
	                under.ellipse(250, 450, 350, 550);  
	                under.setLineWidth(1f);  
	                under.stroke();  
	            }  
	            stamper.close();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  

	
	
	
	 public static boolean waterMark(String inputFile, String imageFile,
	            String outputFile, String waterMarkName, int permission) {
	        try {
	            PdfReader reader = new PdfReader(inputFile);
	            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
	                    outputFile));
	            //这里的字体设置比较关键，这个设置是支持中文的写法
	           // BaseFont base = BaseFont.createFont("STSong-Light",
	           //         "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 使用系统字体
	            BaseFont base=BaseFont.createFont("c://windows//fonts//simsun.ttc,1", BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
	            int total = reader.getNumberOfPages() + 1;
	            Image image = Image.getInstance(imageFile);
	            // 图片位置
	            //image.setAbsolutePosition(110, 110);
	            image.scalePercent(5F);
	            image.setAbsolutePosition(80, 80); 
	            PdfContentByte under;
	            Rectangle pageRect = null;
	            for (int i = 1; i < total; i++) {
	                pageRect = stamper.getReader().
	                           getPageSizeWithRotation(i);
	                // 计算水印X,Y坐标
	                float x = pageRect.getWidth()/10;
	                float y = pageRect.getHeight()/10-10;
	                // 获得PDF最顶层不会透明
	                //under = stamper.getOverContent(i);
	                //会有透明效果
	                under = stamper.getUnderContent(i);
	                under.saveState();
	                // set Transparency
	                PdfGState gs = new PdfGState();
	                // 设置透明度为0.2
	                gs.setFillOpacity(0.2f);
	                under.setGState(gs);
	                // 注意这里必须调用一次restoreState 否则设置无效
	                under.restoreState();
	                under.addImage(image);
	                under.beginText();
	                under.setFontAndSize(base, 30);
	                under.setColorFill(new BaseColor(238, 209, 212));
	               
	                // 水印文字成45度角倾斜
	                under.showTextAligned(Element.ALIGN_CENTER
	                        , waterMarkName, x,
	                        y, 55);
	                // 添加水印文字
	                under.endText();
	                under.setLineWidth(1f);
	                under.stroke();
	            }
	            stamper.close();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

}
